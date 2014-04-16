package prototyped.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milan
 */
public class Entity {
    private String name;
    
    private List<Property> properties;

    public Entity(String name, List<Property> properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Entity{" + "name=" + name + ", properties=" + properties + '}';
    }
}
