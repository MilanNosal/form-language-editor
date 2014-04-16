package generated;

// <editor-fold defaultstate="collapsed" desc="Imports section generated by '/src/main/resources/yajco/fle/generator/templates/imports/Imports.vsl'">
// TODO: prepare a real base
import prototyped.ConceptPanelBase;
import yajco.fle.panels.PanelAccessor;

import yajco.fle.panels.primitive.StringPanel;
import java.util.List;
import yajco.fle.panels.ListPanel;
// </editor-fold>

public class EntityPanel extends ConceptPanelBase implements PanelAccessor<prototyped.model.Entity> {
    // <editor-fold defaultstate="collapsed" desc="Properties declarations">
    private final PanelAccessor<String> name = new StringPanel();
    private final PanelAccessor<List<prototyped.model.Property>> properties 
                                = new ListPanel<>(new PropertyPanel(), new PropertyPanel());
    // </editor-fold>

// TODO konstruktor + pridanie ale nezabudntut nastavit label a desc miskinym panelom

    // <editor-fold defaultstate="collapsed" desc="PanelAccessor interface implementation (differs between abstract and concrete concepts)">
    @Override
    public void setValue(prototyped.model.Entity value) {
        this.name.setValue(value.getName());
        this.properties.setValue(value.getProperties());
    }

    @Override
    public prototyped.model.Entity getValue() {
        return new prototyped.model.Entity(
                    this.name.getValue(),
                    this.properties.getValue()
        );
    }

    @Override
    public void reset() {
        this.name.reset();
        this.properties.reset();
    }

    @Override
    public void setLabel(String label) {
        System.err.println("Setting label on EntityPanel is not supported.");
    }

    @Override
    public void setDescription(String description) {
        System.err.println("Setting description on EntityPanel is not supported.");
    }
    // </editor-fold>

    // TODO: prepare abstract concept template too
}