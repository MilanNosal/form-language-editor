package sk.tuke.magsa.tools.metamodel;

import java.util.Arrays;
import sk.tuke.magsa.tools.metamodel.constraints.Constraint;
import yajco.annotation.Before;
import yajco.annotation.Exclude;
import yajco.annotation.Separator;
import yajco.annotation.reference.Identifier;

public class Property implements Named {
    @Identifier(unique = "../sk.tuke.magsa.tools.metamodel.Property")
    private final String name;

    private final Type type;

    private Constraint[] constraints;

    public Property(String name,
            @Before(":") Type type,
            @Separator(",") Constraint[] constraints) {
        this.name = name;
        this.type = type;
        this.constraints = constraints;
    }

    @Exclude
    public Property(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Constraint[] getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraint[] constraints) {
        this.constraints = constraints;
    }

    @SuppressWarnings("unchecked")
    public <T extends Constraint> T getConstraint(Class<T> clazz) {
        if (constraints != null) {
            for (Constraint constraint : constraints) {
                if (constraint.getClass().equals(clazz)) {
                    return (T) constraint;
                }
            }
        }
        return null;
    }

    public boolean hasConstraint(Class<? extends Constraint> clazz) {
        return getConstraint(clazz) != null;
    }

    @Override
    public String toString() {
        return name + ":" + type + " constraints " + Arrays.toString(constraints);
    }
}
