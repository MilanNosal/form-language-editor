package prototyped;

import yajco.fle.panels.ConcreteConceptPanelBase;
import prototyped.model.Constraint;
import yajco.fle.panels.PanelAccessor;
import yajco.fle.panels.primitive.IntegerPanel;

/**
 *
 * @author Milan
 */
public class ConstraintPanel extends ConcreteConceptPanelBase<Constraint> {

    private final PanelAccessor<Integer> min = new IntegerPanel();
    private final PanelAccessor<Integer> max = new IntegerPanel();
    
    public ConstraintPanel() {
        addProperty("min", min);
        addProperty("max", max);
    }

    @Override
    public void setValue(Constraint value) {
        min.setValue(value.getMin());
        max.setValue(value.getMax());
    }

    @Override
    public Constraint getValue() {
        return new Constraint(min.getValue(), max.getValue());
    }

    @Override
    public void reset() {
        min.reset();
        max.reset();
    }

    @Override
    public void setLabel(String label) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDescription(String description) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
