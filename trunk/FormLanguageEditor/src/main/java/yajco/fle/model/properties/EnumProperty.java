package yajco.fle.model.properties;

import java.util.HashSet;
import java.util.Set;
import yajco.fle.model.Property;

/**
 * Enum.getValue of alebo nieco take na tvorenie instancii.
 * @author Milan
 */
public class EnumProperty extends Property {
    
    // TODO: prerobit na Set a pozriet sa na to cudzimi ocami
    private Set<String> constants = new HashSet<String>();

    public Set<String> getConstants() {
        return constants;
    }
    
}
