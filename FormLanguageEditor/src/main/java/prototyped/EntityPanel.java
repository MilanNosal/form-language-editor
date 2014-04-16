package prototyped;

import yajco.fle.panels.ConcreteConceptPanelBase;
import java.util.List;
import prototyped.model.Entity;
import prototyped.model.Property;
import yajco.fle.panels.ListPanel;
import yajco.fle.panels.PanelAccessor;
import yajco.fle.panels.primitive.StringPanel;

/**
 *
 * @author Milan
 */
public class EntityPanel extends ConcreteConceptPanelBase<Entity> {
    
    private final PanelAccessor<String> name = new StringPanel();
    private final PanelAccessor<List<Property>> properties = new ListPanel<>(new PropertyPanel(), new PropertyPanel());
    
    public EntityPanel() {
        addProperty("name", name);
        addProperty("properties", properties);
    }

    @Override
    public void setValue(Entity value) {
        name.setValue(value.getName());
        properties.setValue(value.getProperties());
    }

    @Override
    public Entity getValue() {
        return new Entity(name.getValue(), properties.getValue());
    }

    @Override
    public void reset() {
        name.reset();
        properties.reset();
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
