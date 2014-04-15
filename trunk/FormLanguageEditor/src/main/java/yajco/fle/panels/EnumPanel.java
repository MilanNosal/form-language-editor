package yajco.fle.panels;

import javax.swing.DefaultComboBoxModel;

/** *  @author Michaela Bačíková
 * @param <T> enum class */
public class EnumPanel <T extends Enum<T>> extends javax.swing.JPanel implements PanelAccessor<T> {

    public EnumPanel(Class<T> clazz) {
        initComponents();
        
        T[] values = getEnumValues(clazz);
        
        if(values != null)
            enumCmbbx.setModel(new DefaultComboBoxModel(values));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enumCmbbx = new javax.swing.JComboBox();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enumCmbbx, 0, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enumCmbbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox enumCmbbx;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setValue(T value) {
        enumCmbbx.setSelectedItem(value);
    }

    @Override
    public T getValue() {
        return (T) enumCmbbx.getSelectedItem();
    }

    @Override
    public void reset() {
        enumCmbbx.setSelectedIndex(0);
    }

    @Override
    public void setLabel(String label) {
        enumCmbbx.setName(label);
    }

    @Override
    public void setDescription(String description) {
        enumCmbbx.setToolTipText(description);
    }

    private T[] getEnumValues(Class<T> clazz) {
        try {
            return (T[]) clazz.getDeclaredMethod("values").invoke(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
