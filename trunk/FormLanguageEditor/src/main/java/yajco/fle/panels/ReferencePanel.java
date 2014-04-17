package yajco.fle.panels;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

/** @author Michaela Bačíková */
public class ReferencePanel <T> extends AbstractAccessiblePanel<T> {

    // TODO: toto by malo byt dynamicke, nie? ci budem zakazdym ked sa ma zobrazit reference panel tvorit novy objekt?
    public ReferencePanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valuesCmbbx = new javax.swing.JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(valuesCmbbx, 0, 250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(valuesCmbbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox valuesCmbbx;
    // End of variables declaration//GEN-END:variables
    
    public void setReferences(List<T> references) {
        valuesCmbbx.setModel(new DefaultComboBoxModel(references.toArray()));
    }
    
    @Override
    public void setValue(T value) {
        valuesCmbbx.setSelectedItem(value);
    }

    @Override
    public T getValue() {
        return (T) valuesCmbbx.getSelectedItem();
    }

    @Override
    public void reset() {
        valuesCmbbx.setSelectedIndex(0);
    }
}
