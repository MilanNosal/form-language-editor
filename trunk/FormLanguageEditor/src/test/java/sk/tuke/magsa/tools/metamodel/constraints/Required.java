package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import yajco.annotation.Before;

//TASK 3
public class Required extends Constraint {
    @Before("required")
    public Required() {
    }

    @Override
    public String toString() {
        return "required";
    }

    @Override
    public boolean supportsType(Type type) {
        return true;
    }
}
