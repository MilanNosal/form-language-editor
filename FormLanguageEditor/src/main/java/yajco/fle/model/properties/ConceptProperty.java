package yajco.fle.model.properties;

import yajco.fle.model.Concept;
import yajco.fle.model.Property;

/**
 *
 * @author Milan
 */
public class ConceptProperty extends Property {

    private final Concept concept;

    public ConceptProperty(String name, Concept concept) {
        super(name);
        this.concept = concept;
    }

    public Concept getConcept() {
        return concept;
    }
}
