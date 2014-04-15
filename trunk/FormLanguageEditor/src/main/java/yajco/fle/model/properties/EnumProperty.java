package yajco.fle.model.properties;

import java.util.Set;
import yajco.fle.model.Property;

/**
 * Enum.getValue of alebo nieco take na tvorenie instancii.
 *
 * @author Milan
 */
public class EnumProperty extends Property {

    private final Set<String> constants;

    public EnumProperty(String name, Set<String> constants) {
        super(name);
        this.constants = constants;
    }

    public Set<String> getConstants() {
        return constants;
    }

}
