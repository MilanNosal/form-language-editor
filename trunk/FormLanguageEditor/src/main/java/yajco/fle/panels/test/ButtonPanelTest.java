package yajco.fle.panels.test;

import yajco.fle.panels.*;

/** *  @author Michaela Bačíková
 * @param <T> type of the concept */
public class ButtonPanelTest <T> extends javax.swing.JPanel implements PanelAccessor<T> {

    
    public ButtonPanelTest() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("yajco/fle/panels/icons/add.png")));
        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void setValue(T value) {
        //nothing, testing method
    }

    @Override
    public T getValue() {
        //nothing, testing method
        return null;
    }

    @Override
    public void reset() {
        //nothing, testing method
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
