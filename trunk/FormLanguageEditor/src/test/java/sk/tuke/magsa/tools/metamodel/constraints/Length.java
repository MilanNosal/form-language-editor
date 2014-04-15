package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import yajco.annotation.Before;
import yajco.annotation.Token;

//TASK 3: obmedanie dlzky retazca
public class Length extends Constraint {
    public static final int DEFAULT_LENGTH = 32;

    private final int minLength;

    private final int maxLength;

    @Before("length")
    public Length(@Token("INT_VALUE") int minLength, @Token("INT_VALUE") int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    @Override
    public String toString() {
        return "length minLength=" + minLength + " maxLength=" + maxLength;
    }

    @Override
    public boolean supportsType(Type type) {
        if (type.equals(Type.STRING)) {
            return true;
        }
        return false;
    }
}
