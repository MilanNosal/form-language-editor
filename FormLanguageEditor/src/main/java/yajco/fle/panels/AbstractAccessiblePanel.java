package yajco.fle.panels;

import java.awt.Color;
import yajco.fle.panels.interfaces.PanelAccessor;
import javax.swing.JPanel;

/** @author Michaela Bačíková */
public abstract class AbstractAccessiblePanel <T> extends JPanel implements PanelAccessor<T> {

    public AbstractAccessiblePanel() {
        setOpaque(false);
        setBackground(Color.WHITE);
    }    
}
