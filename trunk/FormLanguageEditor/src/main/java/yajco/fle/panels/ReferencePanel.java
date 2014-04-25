package yajco.fle.panels;

import yajco.fle.panels.references.ReferenceModel;

/** @author Michaela Bačíková */
public class ReferencePanel <T> extends AbstractAccessiblePanel<T> {

    private final ReferenceModel<T> referenceModel;
    
    public ReferencePanel(ReferenceModel<T> refModel) {
        initComponents();
        this.referenceModel = refModel;
        valuesCombobox.setModel(referenceModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valuesCombobox = new javax.swing.JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(valuesCombobox, 0, 250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(valuesCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox valuesCombobox;
    // End of variables declaration//GEN-END:variables
       
    @Override
    public void setValue(T value) {
        valuesCombobox.setSelectedIndex(referenceModel.getIndexOf(value));
    }

    @Override
    public T getValue() {
        return this.referenceModel.getValueAt(valuesCombobox.getSelectedIndex());
    }

    @Override
    public void reset() {
        valuesCombobox.setEnabled(valuesCombobox.getModel().getSize() > 0);
        if(valuesCombobox.isEnabled()) {
            valuesCombobox.setSelectedIndex(0);
        } 
    }
}
