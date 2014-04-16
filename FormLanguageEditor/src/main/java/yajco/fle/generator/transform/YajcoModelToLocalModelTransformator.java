package yajco.fle.generator.transform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import yajco.fle.model.AbstractConcept;
import yajco.fle.model.ConcreteConcept;
import yajco.fle.model.Property;
import yajco.fle.model.properties.ConceptProperty;
import yajco.fle.model.properties.EnumProperty;
import yajco.fle.model.properties.ListProperty;
import yajco.fle.model.properties.ReferenceProperty;
import yajco.fle.model.properties.primitives.BooleanProperty;
import yajco.fle.model.properties.primitives.IntegerProperty;
import yajco.fle.model.properties.primitives.RealProperty;
import yajco.fle.model.properties.primitives.StringProperty;
import yajco.model.Concept;
import yajco.model.Language;
import yajco.model.LocalVariablePart;
import yajco.model.Notation;
import yajco.model.NotationPart;
import yajco.model.PropertyReferencePart;
import yajco.model.TokenPart;
import yajco.model.pattern.impl.Identifier;
import yajco.model.pattern.impl.References;
import yajco.model.type.ListType;
import yajco.model.type.PrimitiveType;
import yajco.model.type.ReferenceType;
import yajco.model.type.Type;
import yajco.model.utilities.Utilities;

/**
 *
 * @author DeeL
 */
public class YajcoModelToLocalModelTransformator {

    private final Language inputLanguage;
    private final Map<Concept, yajco.fle.model.Concept> concepts = new LinkedHashMap<>();
    private final Map<yajco.model.Property, Property> properties = new HashMap<>();

    public static yajco.fle.model.Language transform(Language language) {
        YajcoModelToLocalModelTransformator transformator = new YajcoModelToLocalModelTransformator(language);
        yajco.fle.model.Language lang = transformator.transformLanguage();

        System.out.println(lang);

        return lang;
    }

    public YajcoModelToLocalModelTransformator(Language inputLanguage) {
        this.inputLanguage = inputLanguage;
    }

    private yajco.fle.model.Language transformLanguage() {
        for (Concept concept : inputLanguage.getConcepts()) {
            yajco.fle.model.Concept c = transformPartialConcept(concept);
            if (c != null) {
                concepts.put(concept, c);
            }
        }
        for (yajco.fle.model.Concept concept : concepts.values()) {
            reprocessConcept(concept);
        }
        return new yajco.fle.model.Language(new ArrayList<>(concepts.values()));
    }

    private yajco.fle.model.Concept transformPartialConcept(Concept concept) {
        //ignorovat ENUM concepty, tie sa pouziju len ako primitivnejsi typ
        if (concept.getPattern(yajco.model.pattern.impl.Enum.class) != null) {
            return null;
        }
        String name = concept.getConceptName();
        String className = Utilities.getFullConceptClassName(inputLanguage, concept);
        List<Concept> descendants = getAllDescendantConcepts(concept);

        yajco.fle.model.Concept newConcept;
        if (descendants.isEmpty()) {
            newConcept = new ConcreteConcept(name, className, new ArrayList<Property>());
        } else {
            newConcept = new AbstractConcept(name, className, new HashSet<yajco.fle.model.Concept>());
        }
        newConcept.setSourceElement(concept);

        return newConcept;
    }

    private void reprocessConcept(yajco.fle.model.Concept concept) {
        if (concept instanceof ConcreteConcept) {
            reprocessConcept((ConcreteConcept) concept);
        } else if (concept instanceof AbstractConcept) {
            reprocessConcept((AbstractConcept) concept);
        } else {
            throw new IllegalArgumentException("Not known concept type " + concept.getClassName() + "[" + concept.getClass().getCanonicalName() + "]");
        }
    }

    private void reprocessConcept(ConcreteConcept concept) {
        Concept sourceConcept = concept.getSourceElement();
        List<Property> properties = concept.getProperties();
        if (!sourceConcept.getConcreteSyntax().isEmpty()) {
            Notation notation = sourceConcept.getConcreteSyntax().get(0);
            for (NotationPart notationPart : notation.getParts()) {
                Property property = transformNotationPart(notationPart, sourceConcept);
                if (property != null) {
                    properties.add(property);
                }
            }
        }
    }

    private void reprocessConcept(AbstractConcept concept) {
        Concept sourceConcept = concept.getSourceElement();
        List<Concept> descendants = getAllDescendantConcepts(sourceConcept);
        Set<yajco.fle.model.Concept> directSubtypes = concept.getDirectSubtypes();
        for (Concept desc : descendants) {
            if (concepts.containsKey(desc)) {
                directSubtypes.add(concepts.get(desc));
            }
        }
    }

    private List<Concept> getAllDescendantConcepts(Concept concept) {
        List<Concept> finalList = new ArrayList<>();
        List<Concept> descendants = Utilities.getDirectDescendantConcepts(concept, inputLanguage);
        for (Concept descendant : descendants) {
            finalList.addAll(getAllDescendantConcepts(descendant));
        }
        finalList.addAll(0, descendants);
        return finalList;
    }

    private Property transformNotationPart(NotationPart part, Concept concept) {
        Property property = null;
        if (part instanceof TokenPart) {
            //nothing to do, just skip it
        } else if (part instanceof PropertyReferencePart) {
            property = transformNotationPart((PropertyReferencePart) part, concept);
        } else if (part instanceof LocalVariablePart) {
            property = transformNotationPart((LocalVariablePart) part, concept);
        }
        return property;
    }

    private Property transformNotationPart(PropertyReferencePart part, Concept concept) {
        if (part == null || part.getProperty() == null) {
            throw new IllegalArgumentException("Argument part cannot be null or part.getProperty() cannot by null");
        }
        yajco.model.Property property = part.getProperty();
        return processProperty(property, concept);
    }

    private Property processProperty(yajco.model.Property property, Concept concept) {
        Property processedProperty;
        if (properties.containsKey(property)) {
            processedProperty = properties.get(property);
        } else {
            processedProperty = transformProperty(property, concept);
            if (processedProperty != null) {
                properties.put(property, processedProperty);
            }
        }
        return processedProperty;
    }

    private Property transformProperty(yajco.model.Property property, Concept concept) {
        String name = property.getName();
        Type type = property.getType();
        if (type instanceof PrimitiveType) {
            PrimitiveType t = (PrimitiveType) type;
            switch (t.getPrimitiveTypeConst()) {
                case BOOLEAN:
                    return new BooleanProperty(name);
                case INTEGER:
                    return new IntegerProperty(name);
                case REAL:
                    return new RealProperty(name);
                case STRING:
                    return new StringProperty(name);
            }
        } else if (type instanceof ReferenceType) {
            ReferenceType referenceType = (ReferenceType) type;
            if (referenceType.getConcept().getPattern(yajco.model.pattern.impl.Enum.class) != null) {
                Set<String> notations = new HashSet<>();
                for (Notation notation : referenceType.getConcept().getConcreteSyntax()) {
                    notations.add(((TokenPart) notation.getParts().get(0)).getToken());
                }
                return new EnumProperty(name, Utilities.getFullConceptClassName(inputLanguage, referenceType.getConcept()), notations);
            } else {
                return new ConceptProperty(name, concepts.get(referenceType.getConcept()));
            }
        } else if (type instanceof ListType) {
            ListType t = (ListType) type;
            Type componentType = t.getComponentType();
            if (componentType instanceof ReferenceType) {
                ReferenceType rt = (ReferenceType) componentType;
                return new ListProperty(name, concepts.get(rt.getConcept()));
            } else {
                throw new IllegalArgumentException("List contains not supported type " + componentType.getClass());
            }
        } else {
            throw new IllegalArgumentException("Cannot transform " + concept.getName() + ":" + name + " [" + property.getType().getClass().getCanonicalName() + "] to FLE Model");
        }
        return null;
    }

    private Property transformNotationPart(LocalVariablePart part, Concept concept) {
        References ref = (References) part.getPattern(References.class);
        if (ref != null) {
            //TODO: pridat zistenie fieldu, ktory je identifikator
            yajco.model.Property indentProperty = null;
            for (yajco.model.Property property : ref.getConcept().getAbstractSyntax()) {
                if (property.getPattern(Identifier.class) != null) {
                    indentProperty = property;
                }
            }
            return new ReferenceProperty(part.getName(), concepts.get(ref.getConcept()),processProperty(indentProperty, concept));
        } else {
            throw new IllegalArgumentException("Cannot transform " + part.getClass().getCanonicalName() + " to FLE Model, should contain References pattern.");
        }
    }

}
