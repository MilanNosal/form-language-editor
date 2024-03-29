package yajco.fle.model.properties;

import yajco.fle.model.Concept;
import yajco.fle.model.Property;
import yajco.fle.model.properties.interfaces.HasType;

/**
 *
 * @author Milan
 */
public class ListProperty extends Property implements HasType {
    private final Concept componentType;

    public ListProperty(String name, Concept componentType) {
        super(name);
        this.componentType = componentType;
    }

    public Concept getComponentType() {
        return componentType;
    }

    @Override
    public String getTypeName() {
        return componentType.getClassName();
    }

    @Override
    public String toString() {
        return "listProperty[innerType:"+componentType.getName()+"]";
    }
}
