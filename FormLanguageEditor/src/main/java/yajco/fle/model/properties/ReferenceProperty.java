package yajco.fle.model.properties;

import yajco.fle.model.Concept;
import yajco.fle.model.Property;

/**
 *
 * @author Milan
 */
public class ReferenceProperty extends Property {
    private Concept concept;
    
    private Property refId;

    public Concept getConcept() {
        return concept;
    }

    public Property getRefId() {
        return refId;
    }
}
