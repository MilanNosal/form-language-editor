package yajco.fle.model;

/**
 *
 * @author DeeL
 */
public abstract class Property {

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
}
