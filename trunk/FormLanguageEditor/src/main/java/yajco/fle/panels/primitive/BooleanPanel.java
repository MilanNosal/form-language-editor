/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yajco.fle.panels.primitive;

import yajco.fle.panels.AbstractAccessiblePanel;

/** @author Michaela Bačíková */
public class BooleanPanel extends AbstractAccessiblePanel<Boolean> {

    public BooleanPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        booleanChckbx = new javax.swing.JCheckBox();

        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        booleanChckbx.setText("Boolean value text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(booleanChckbx)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(booleanChckbx)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox booleanChckbx;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setValue(Boolean value) {
        booleanChckbx.setSelected(value);
    }

    @Override
    public Boolean getValue() {
        return booleanChckbx.isSelected();
    }

    @Override
    public void reset() {
        booleanChckbx.setSelected(false);
    }
}
