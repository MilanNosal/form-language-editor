package yajco.fle.panels;

import javax.swing.JPanel;

/** *  @author Michaela Bačíková
 * @param <T> type of the concept */
public class DirectConceptPanel <T> extends javax.swing.JPanel implements PanelAccessor<T> {

    private final PanelAccessor<T> directConceptPanel;
    
    public DirectConceptPanel(PanelAccessor<T> directConceptPanel) {
        initComponents();
        this.directConceptPanel = directConceptPanel;
        this.add((JPanel)directConceptPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void setValue(T value) {
        directConceptPanel.setValue(value);
    }

    @Override
    public T getValue() {
        return directConceptPanel.getValue();
    }

    @Override
    public void reset() {
        directConceptPanel.reset();
    }

    @Override
    public void setLabel(String label) {
        this.setName(label);
    }

    @Override
    public void setDescription(String description) {
        this.setToolTipText(description);
    }
}
