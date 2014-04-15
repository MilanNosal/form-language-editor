package yajco.fle.model.properties;

import yajco.fle.model.Concept;
import yajco.fle.model.Property;

/**
 *
 * @author Milan
 */
public class ListProperty extends Property {

    private final Concept componentType;

    public ListProperty(String name, Concept componentType) {
        super(name);
        this.componentType = componentType;
    }

    public Concept getComponentType() {
        return componentType;
    }
}
