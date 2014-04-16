package yajco.fle.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        List<String> subtypesNames = new ArrayList<>(subtypes.size());
        for (Concept concept : subtypes) {
            subtypesNames.add(concept.getName());
        }
        return "\n\tabstractConcept "+getName()+" subtypes:{({\n\t\t"+Arrays.toString(subtypesNames.toArray())+"\n\t})}";
    }
    
}
