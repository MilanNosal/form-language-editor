package yajco.fle.model.properties;

import yajco.fle.model.Concept;
import yajco.fle.model.Property;
import yajco.fle.model.properties.interfaces.DomainProperty;

/**
 *
 * @author Milan
 */
public class ReferenceProperty extends Property implements DomainProperty {

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
    
    @Override
    public String getDomainClassName() {
        return concept.getClassName();
    }

    @Override
    public String toString() {
        return "ReferenceProperty {concept:"+concept.getName()+" | refId:"+refId.getName()+"}";
    }
}
