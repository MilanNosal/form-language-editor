/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package yajco.fle.panels.primitive;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import yajco.fle.panels.PanelAccessor;

/** @author Michaela Bačíková */
public class RealPanel extends javax.swing.JPanel implements PanelAccessor<Double> {
    
    public RealPanel() {
        initComponents();
        
        InputVerifier verifier = new DoubleVerifier();
        realFrmttdTxtfld.setInputVerifier(verifier);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        realFrmttdTxtfld = new javax.swing.JFormattedTextField();

        realFrmttdTxtfld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(realFrmttdTxtfld, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(realFrmttdTxtfld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        realFrmttdTxtfld.setValue("");
    }

    @Override
    public void setLabel(String label) {
        //zatial nic
    }

    @Override
    public void setDescription(String description) {
        realFrmttdTxtfld.setToolTipText(description);
    }
    
    private class DoubleVerifier extends InputVerifier implements ActionListener {

        private final NumberFormat realFormat = (NumberFormat)NumberFormat.getNumberInstance();
        
        @Override
        public boolean verify(JComponent input) {
            return checkField(input, false);
        }
        
        @Override
        public boolean shouldYieldFocus(JComponent input) {
            boolean inputOK = verify(input);
            makeItPretty(input);
             
            if (inputOK) {
                return true;
            } else {
                return false;
            }
        }

        protected void makeItPretty(JComponent input) {
            checkField(input, true);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField source = (JTextField)e.getSource();
            shouldYieldFocus(source); //ignore return value
            source.selectAll();
        }
        
        protected boolean checkField(JComponent input, boolean changeIt) {
            boolean wasValid = true;
            double amount = 0.0;
            //Parse the value.
            try {
                amount = realFormat.parse(realFrmttdTxtfld.getText()).
                                  doubleValue();
            } catch (ParseException pe) {
                wasValid = false;
            }
            
            //Whether value was valid or not, format it nicely.
            if (changeIt) {
                realFrmttdTxtfld.setText(realFormat.format(amount));
                realFrmttdTxtfld.selectAll();
            }

            return wasValid;
        }
    }
}
