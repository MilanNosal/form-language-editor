package prototyped;

import yajco.fle.panels.ConcreteConceptPanelBase;
import prototyped.model.Constraint;
import prototyped.model.Property;
import yajco.fle.panels.AbstractAccessiblePanel;
import yajco.fle.panels.ConceptPanel;
import yajco.fle.panels.PanelAccessor;
import yajco.fle.panels.primitive.StringPanel;

/**
 *
 * @author Milan
 */
public class PropertyPanel extends ConcreteConceptPanelBase<Property> {
    private final AbstractAccessiblePanel<String> name = new StringPanel();
    private final AbstractAccessiblePanel<Constraint> constraint = new ConceptPanel<>(new ConstraintPanel());
    
    public PropertyPanel() {
        addRowForProperty("name", name);
        addRowForProperty("constraint", constraint);
    }

    @Override
    public void setValue(Property value) {
        name.setValue(value.getName());
        constraint.setValue(value.getConstraint());
    }

    @Override
    public Property getValue() {
        return new Property(name.getValue(), constraint.getValue());
    }

    @Override
    public void reset() {
        name.reset();
        constraint.reset();
    }

    @Override
    public void setLabel(String label) {
        System.err.println("");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDescription(String description) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
