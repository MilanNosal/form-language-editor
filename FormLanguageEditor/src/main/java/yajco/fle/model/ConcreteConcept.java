package yajco.fle.model;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Milan
 */
public class ConcreteConcept extends Concept {

    private final List<Property> properties;

    public ConcreteConcept(String name, String className, List<Property> properties) {
        super(name, className);
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "\n\tconcreteConcept "+this.getName()+" {"+Arrays.toString(properties.toArray())+"}";
    }
    
}
