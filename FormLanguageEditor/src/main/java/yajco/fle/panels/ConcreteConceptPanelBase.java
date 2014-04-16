package yajco.fle.panels;

import java.awt.Label;
import javax.swing.JPanel;

/**
 *
 * @author Milan
 * @param <T> type 
 */
public abstract class ConcreteConceptPanelBase <T> extends AbstractAccessiblePanel<T> {

    /**
     * Creates new form ConceptPanelBase
     */
    public ConcreteConceptPanelBase() {
        initComponents();
    }
    
    protected void addRowForProperty(String label, AbstractAccessiblePanel panel) {
        add(new Label(label));
        add(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.GridLayout(0, 2));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
