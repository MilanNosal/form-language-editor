/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yajco.fle.panels.primitive;

import yajco.fle.panels.AbstractAccessiblePanel;

/** @author Michaela Bačíková */
public class RealPanel extends AbstractAccessiblePanel<Double> {
    
    public RealPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        realFrmttdTxtfld = new javax.swing.JFormattedTextField();

        realFrmttdTxtfld.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        realFrmttdTxtfld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        realFrmttdTxtfld.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        realFrmttdTxtfld.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(realFrmttdTxtfld, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(realFrmttdTxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField realFrmttdTxtfld;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setValue(Double value) {
        realFrmttdTxtfld.setValue(value);
    }

    @Override
    public Double getValue() {
        return Double.parseDouble(realFrmttdTxtfld.getText());
    }

    @Override
    public void reset() {
        realFrmttdTxtfld.setValue(0.0);
    }
}
