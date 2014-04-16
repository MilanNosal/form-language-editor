package yajco.fle.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.processing.Filer;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import yajco.fle.model.AbstractConcept;
import yajco.fle.model.Concept;
import yajco.fle.model.ConcreteConcept;
import yajco.fle.model.Property;
import yajco.fle.model.properties.ConceptProperty;
import yajco.fle.model.properties.ListProperty;
import yajco.fle.model.properties.interfaces.HasType;
import yajco.fle.model.properties.primitives.IntegerProperty;
import yajco.fle.model.properties.primitives.StringProperty;
import yajco.generator.FilesGenerator;
import yajco.model.Language;

/**
 *
 * @author DeeL
 */
public class PanelsGenerator implements FilesGenerator {

    public static void main(String[] args) {
        new PanelsGenerator().generateFiles(null, null, null);
    }

    @Override
    public void generateFiles(Language language, Filer filer, Properties properties) {
        yajco.fle.model.Language lang = createDummy(); //YajcoModelToLocalModelTransformator.transform(language);

        try {
            String path = TEMPLATE_PACKAGE + "/" + template + ".java.vsl";
            File dirs = new File("src/main/java/generated");
            dirs.mkdirs();
            for (Concept concept : lang.getConcepts()) {
                File wrt = new File("src/main/java/generated/" + concept.getName() + "Panel.java");
                wrt.createNewFile();
                try (
                        InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "utf-8");
                        Writer writer = new BufferedWriter(new FileWriter(wrt))) {
                    // filer.createSourceFile("generated." + concept.getName()+ "Panel").openWriter()) {
                    Map<String, Object> params = new HashMap<>();
                    VelocityContext context = new VelocityContext(params);

                    context.put("generator", this);
                    context.put("concept", concept);
                    context.put("package", "generated");
                    velocityEngine.evaluate(context, writer, "", reader);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot generate output.", e);
        }

    }

    public Set<String> getDomainProperties(Concept concept) {
        Set<String> retVal = new HashSet<>();
        if (concept instanceof ConcreteConcept) {
            for (Property property : ((ConcreteConcept) concept).getProperties()) {
                if (property instanceof HasType) {
                    retVal.add(((HasType) property).getTypeName());
                }
            }
        } else if (concept instanceof AbstractConcept) {
            for (Concept subType : ((AbstractConcept) concept).getDirectSubtypes()) {
                retVal.add(subType.getClassName());
            }
        }
        return retVal;
    }

    public Set<Class> getPanelClasses(Concept concept) {
        Set<Class> retVal = new HashSet<>();
        if (concept instanceof ConcreteConcept) {
            for (Property property : ((ConcreteConcept) concept).getProperties()) {
                retVal.add(property.getClass());
            }
        }
        return retVal;
    }
    
    /**
     * Vystrihnutie mena konceptu, ktore potom pouzivam pre pracu vdaka
     * mennym konvenciam.
     * @param property
     * @return 
     */
    public String getPropertyTypeName(Property property) {
        String propSimpleName = property.getClass().getSimpleName();
        return propSimpleName.substring(0, propSimpleName.length() - 8);
    }

    public PanelsGenerator() {
    }

    private yajco.fle.model.Language createDummy() {
        List<Property> properties = new ArrayList<>();
        properties.add(new IntegerProperty("min"));
        properties.add(new IntegerProperty("max"));
        Concept constraint = new ConcreteConcept("Constraint", "prototyped.model.Constraint", properties);

        properties = new ArrayList<>();
        properties.add(new StringProperty("name"));
        properties.add(new ConceptProperty("constraint", constraint));
        Concept property = new ConcreteConcept("Property", "prototyped.model.Property", properties);

        properties = new ArrayList<>();
        properties.add(new StringProperty("name"));
        properties.add(new ListProperty("properties", property));
        Concept entity = new ConcreteConcept("Entity", "prototyped.model.Entity", properties);
        
        List<Concept> concepts = new ArrayList<>();
        concepts.add(entity);
        concepts.add(property);
        concepts.add(constraint);

        return new yajco.fle.model.Language(concepts);
    }

    protected static final String VELOCITY_PROPERTIES_FILE = "velocity.properties";
    protected static final String TEMPLATE_PACKAGE = "src/main/resources/yajco/fle/generator/templates";
    protected static VelocityEngine velocityEngine;
    protected final String template = "Concept";

    static {
        try {
            Properties velocityProperties = new Properties();
            //velocityProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream(VELOCITY_PROPERTIES_FILE));
            velocityEngine = new VelocityEngine(velocityProperties);
        } catch (Exception e) {
            throw new ConfigurationException("Failed during loading of the configuration file '" + VELOCITY_PROPERTIES_FILE + "'", e);
        }
    }
}
