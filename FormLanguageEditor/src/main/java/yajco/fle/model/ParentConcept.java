package yajco.fle.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Milan
 */
public class ParentConcept extends Concept {
    
    private Set<Concept> directSubtypes = new HashSet<>();

    public Set<Concept> getDirectSubtypes() {
        return directSubtypes;
    }

}
