package yajco.fle.model;

import java.io.Serializable;

/**
 *
 * @author DeeL
 */
public abstract class Concept extends BaseSourceElement<yajco.model.Concept> implements Serializable, Comparable<Concept> {

    private final String name;

    private final String className;

    public Concept(String name, String className) {
        this.name = name;
        this.className = className;
    }
    
    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public int compareTo(Concept o) {
        return name.compareTo(o.name);
    }
}
