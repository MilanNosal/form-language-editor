package yajco.fle.panels.primitive;

import yajco.fle.panels.AbstractAccessiblePanel;

/** @author Michaela Bačíková */
public class IntegerPanel extends AbstractAccessiblePanel<Integer> {
    
    public IntegerPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        integerFrmttdTxtfld = new javax.swing.JFormattedTextField();

        integerFrmttdTxtfld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(integerFrmttdTxtfld, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(integerFrmttdTxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField integerFrmttdTxtfld;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setValue(Integer value) {
        integerFrmttdTxtfld.setValue(value);
    }

    @Override
    public Integer getValue() {
        return Integer.parseInt(integerFrmttdTxtfld.getText());
    }

    @Override
    public void reset() {
        integerFrmttdTxtfld.setValue(0);
    }
}
