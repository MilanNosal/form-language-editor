package yajco.fle.model;

import java.util.Set;

/**
 *
 * @author Milan
 */
public class AbstractConcept extends Concept {

    private final Set<Concept> subtypes;

    public AbstractConcept(String name, String className, Set<Concept> subtypes) {
        super(name, className);
        this.subtypes = subtypes;
    }

    public Set<Concept> getDirectSubtypes() {
        return subtypes;
    }
}
