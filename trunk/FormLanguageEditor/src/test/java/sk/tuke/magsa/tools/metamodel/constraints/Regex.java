package sk.tuke.magsa.tools.metamodel.constraints;

import sk.tuke.magsa.tools.metamodel.Type;
import yajco.annotation.Before;
import yajco.annotation.Token;

//TASK 3: Obmedzenie prostrednictvom reg. vyrazu
public class Regex extends Constraint {
    private final String regex;

    @Before("regex")
    public Regex(@Token("STRING_VALUE") String regex) {
        this.regex = regex.substring(1, regex.length() - 1);
    }

    public String getRegex() {
        return regex;
    }

    @Override
    public String toString() {
        return "regex regex=" + regex;
    }

    @Override
    public boolean supportsType(Type type) {
        return true;
    }
}
