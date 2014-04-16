package yajco.fle.model.properties.primitives;

import yajco.fle.model.Property;
import yajco.fle.model.properties.interfaces.HasType;

/**
 *
 * @author Milan
 */
public class IntegerProperty extends Property implements HasType {
    public IntegerProperty(String name) {
        super(name);
    }

    @Override
    public String getTypeName() {
        return "Integer";
    }
}
