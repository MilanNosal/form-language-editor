/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yajco.fle.panels.primitive;

import yajco.fle.panels.PanelAccessor;

/** @author Michaela Bačíková */
public class BooleanPanel extends javax.swing.JPanel implements PanelAccessor<Boolean> {

    public BooleanPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        booleanComponent = new javax.swing.JCheckBox();

        booleanComponent.setText("Boolean value text");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(booleanComponent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(booleanComponent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox booleanComponent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setValue(Boolean value) {
        booleanComponent.setSelected(value);
    }

    @Override
    public Boolean getValue() {
        return booleanComponent.isSelected();
    }

    @Override
    public void reset() {
        booleanComponent.setSelected(false);
    }

    @Override
    public void setLabel(String label) {
        booleanComponent.setText(label);
    }

    @Override
    public void setDescription(String description) {
        booleanComponent.setToolTipText(description);
    }
}
