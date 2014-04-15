package yajco.fle.model.properties;

import yajco.fle.model.Concept;
import yajco.fle.model.Property;

/**
 *
 * @author Milan
 */
public class ReferenceProperty extends Property {

    private final Concept concept;

    private final Property refId;

    public ReferenceProperty(String name, Concept concept, Property refId) {
        super(name);
        this.concept = concept;
        this.refId = refId;
    }

    public Concept getConcept() {
        return concept;
    }

    public Property getRefId() {
        return refId;
    }
}
