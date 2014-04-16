package prototyped;

import yajco.fle.panels.ConceptPanelBase;
import prototyped.model.Constraint;
import prototyped.model.Property;
import yajco.fle.panels.ConceptPanel;
import yajco.fle.panels.PanelAccessor;
import yajco.fle.panels.primitive.StringPanel;

/**
 *
 * @author Milan
 */
public class PropertyPanel extends ConceptPanelBase<Property>{
    private final PanelAccessor<String> name = new StringPanel();
    private final PanelAccessor<Constraint> constraint = new ConceptPanel<>(new ConstraintPanel());
    
    public PropertyPanel() {
        addProperty("name", name);
        addProperty("constraint", constraint);
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
