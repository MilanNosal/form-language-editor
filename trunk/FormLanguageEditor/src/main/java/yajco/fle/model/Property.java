package yajco.fle.model;

import java.io.Serializable;

/**
 *
 * @author DeeL
 */
public abstract class Property implements Serializable{

    private final String name;

    public Property(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName() + "[" +this.getClass().getSimpleName()+"]";
    }
    
}
