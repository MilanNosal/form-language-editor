package yajco.fle.panels;

import java.util.List;
import javax.swing.DefaultComboBoxModel;

/** @author Michaela Bačíková */
public class ReferencePanel <T> extends javax.swing.JPanel implements PanelAccessor<T> {

    // TODO: toto by malo byt dynamicke, nie? ci budem zakazdym ked sa ma zobrazit reference panel tvorit novy objekt?
    public ReferencePanel(List<T> values) {
        initComponents();
        
        valuesCmbbx.setModel(new DefaultComboBoxModel(values.toArray()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valuesCmbbx = new javax.swing.JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valuesCmbbx, 0, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(valuesCmbbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox valuesCmbbx;
    // End of variables declaration//GEN-END:variables

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

    @Override
    public void setLabel(String label) {
        valuesCmbbx.setName(label);
    }

    @Override
    public void setDescription(String description) {
        valuesCmbbx.setToolTipText(description);
    }
}
