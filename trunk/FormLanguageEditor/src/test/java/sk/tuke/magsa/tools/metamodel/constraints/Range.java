package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import yajco.annotation.Before;
import yajco.annotation.Token;

public class Range extends Constraint {
    private final long minValue;

    private final long maxValue;

    @Before("range")
    public Range(@Token("INT_VALUE") long minValue, @Token("INT_VALUE") long maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public long getMaxValue() {
        return maxValue;
    }

    public long getMinValue() {
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
