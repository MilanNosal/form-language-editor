package yajco.fle.model.properties.primitives;

import yajco.fle.model.Property;
import yajco.fle.model.properties.interfaces.HasType;

/**
 *
 * @author Milan
 */
public class StringProperty extends Property implements HasType {

    public StringProperty(String name) {
        super(name);
    }

    @Override
    public String getTypeName() {
        return "String";
    }
}
