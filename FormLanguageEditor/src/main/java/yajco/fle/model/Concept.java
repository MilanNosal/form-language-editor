package yajco.fle.model;

/**
 *
 * @author DeeL
 */
public abstract class Concept {

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
}
