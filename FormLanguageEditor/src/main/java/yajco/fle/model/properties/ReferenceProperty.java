package yajco.fle.model.properties;

import java.util.Objects;
import yajco.fle.model.Concept;
import yajco.fle.model.Property;
import yajco.fle.model.properties.interfaces.HasType;

/**
 *
 * @author Milan
 */
public class ReferenceProperty extends Property implements HasType {

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
    public String getTypeName() {
        return concept.getClassName();
    }

    @Override
    public String toString() {
        return "ReferenceProperty {concept:"+concept.getName()+" | refId:"+refId.getName()+"}";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(getTypeName());
        hash = 59 * hash + Objects.hashCode(this.refId.getName());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReferenceProperty other = (ReferenceProperty) obj;
        if (!this.getTypeName().equals(other.getTypeName())) {
            return false;
        }
        if (!refId.getName().equals(other.refId.getName())) {
            return false;
        }
        return true;
    }
}
