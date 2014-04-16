package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import yajco.annotation.Before;
import yajco.annotation.Token;

public class Range extends Constraint {
    private final int minValue;

    private final int maxValue;

    @Before("range")
    public Range(@Token("INT_VALUE") int minValue, @Token("INT_VALUE") int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    @Override
    public String toString() {
        return "range minValue=" + minValue + " maxValue=" + maxValue;
    }

    @Override
    public boolean supportsType(Type type) {
        if (type.equals(Type.INTEGER)) {
            return true;
        }
        return false;
    }
}
