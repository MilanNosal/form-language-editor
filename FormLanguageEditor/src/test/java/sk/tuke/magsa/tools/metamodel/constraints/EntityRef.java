package sk.tuke.magsa.tools.metamodel.constraints;

import java.util.Arrays;
import java.util.List;

public class EntityRef {

    private final String name;
    private final List<PropertyRef> properties;

    public EntityRef(String name, List<PropertyRef> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public List<PropertyRef> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "entity_ref " + name + " " + Arrays.toString(properties.toArray());
    }
}
