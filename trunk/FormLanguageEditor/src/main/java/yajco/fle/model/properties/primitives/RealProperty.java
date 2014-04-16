package yajco.fle.model.properties.primitives;

import yajco.fle.model.Property;
import yajco.fle.model.properties.interfaces.HasType;

/**
 *
 * @author Milan
 */
public class RealProperty extends Property implements HasType {
    public RealProperty(String name) {
        super(name);
    }

    @Override
    public String getTypeName() {
        return "Double";
    }
}
