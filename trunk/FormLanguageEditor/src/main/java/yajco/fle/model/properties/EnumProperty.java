package yajco.fle.model.properties;

import java.util.Set;
import yajco.fle.model.Property;
import yajco.fle.model.properties.interfaces.HasType;

/**
 * Enum.getValue of alebo nieco take na tvorenie instancii.
 *
 * @author Milan
 */
public class EnumProperty extends Property implements HasType {
 
    private final Set<String> constants;
    
    private final String className;

    public EnumProperty(String name, String className, Set<String> constants) {
        super(name);
        this.className = className;
        this.constants = constants;
    }

    public Set<String> getConstants() {
        return constants;
    }


    @Override
    public String getTypeName() {
        return className;
    }

    public String getClassName() {
        return className;
    }
}
