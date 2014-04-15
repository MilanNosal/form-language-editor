package sk.tuke.magsa.tools.metamodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import yajco.annotation.After;
import yajco.annotation.Before;
import yajco.annotation.Range;
import yajco.annotation.reference.Identifier;

public class Entity implements Named {
    @Identifier
    private final String name;

    private final List<Property> properties;

    private final List<Reference> outgoingReferences = new ArrayList<Reference>();

    @Before("entity")
    public Entity(String name,
            @Before("{") @After("}") @Range(minOccurs = 1) List<Property> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public Property findProperty(String name) {
        for (Property property : properties) {
            if (name.equals(property.getName())) {
                return property;
            }
        }
        return null;
    }

    public List<Reference> getOutgoingReferences() {
        return outgoingReferences;
    }

    public void addOutgoingReference(Reference reference) {
        outgoingReferences.add(reference);
    }

    public Reference findReferenceTo(String entity) {
        for (Reference reference : outgoingReferences) {
            if (entity.equals(reference.getTo().getName())) {
                return reference;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "entity " + name + " " + Arrays.toString(properties.toArray()) + " outgoing references " + Arrays.toString(outgoingReferences.toArray());
    }
}
