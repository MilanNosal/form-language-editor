package sk.tuke.magsa.tools.metamodel.constraints;

import java.util.Arrays;
import java.util.List;

public class PropertyRef {

    private final String name;
    private final List<Constraint> constraints;

    public PropertyRef(String name, List<Constraint> constraints) {
        this.name = name;
        this.constraints = constraints;
    }

    public String getName() {
        return name;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    @Override
    public String toString() {
        return name + " constraints " + Arrays.toString(constraints.toArray());
    }
}
