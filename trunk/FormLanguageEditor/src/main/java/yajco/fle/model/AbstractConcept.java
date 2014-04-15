package yajco.fle.model;

import java.util.Arrays;
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

    @Override
    public String toString() {
        return "\n\tabstractConcept "+getName()+" subtypes:{({\n\t\t"+Arrays.toString(subtypes.toArray())+"\n\t})}";
    }
    
}
