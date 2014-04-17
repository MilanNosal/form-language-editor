package yajco.fle.panels;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import yajco.fle.panels.interfaces.Labeled;

/**
 *
 * @author Milan
 * @param <T>
 */
public abstract class AbstractConceptPanelBase<T> extends AbstractAccessiblePanel<T> implements Labeled {

    /**
     * Creates new form AbstractConceptPanelBase
     */
    public AbstractConceptPanelBase() {
        initComponents();

    }

    protected void registerSubtype(String label, Class<? extends T> clazz, AbstractAccessiblePanel<? extends T> conceptPanel) {
        conceptsComboBox.addItem(label);
        classes.add(clazz);
        panels.add(conceptPanel);
    }

    protected final List<Class<? extends T>> classes = new LinkedList<Class<? extends T>>();

    protected final List<AbstractAccessiblePanel<? extends T>> panels
            = new LinkedList<AbstractAccessiblePanel<? extends T>>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conceptsComboBox = new javax.swing.JComboBox();
        contentPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        conceptsComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        conceptsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conceptsComboBoxActionPerformed(evt);
            }
        });
        add(conceptsComboBox, java.awt.BorderLayout.PAGE_START);

        contentPanel.setOpaque(false);
        contentPanel.setLayout(new java.awt.BorderLayout());
        add(contentPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void conceptsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conceptsComboBoxActionPerformed
        if (panels.size() > 0) {
            contentPanel.removeAll();
            contentPanel.add(panels.get(conceptsComboBox.getSelectedIndex()));
            JDialog dialog = ((JDialog) SwingUtilities.getWindowAncestor(this));
            if (dialog != null) {
                dialog.pack();
            }
        }
    }//GEN-LAST:event_conceptsComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JComboBox conceptsComboBox;
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public T getValue() {
        int selected = conceptsComboBox.getSelectedIndex();
        return panels.get(selected).getValue();
    }

    @Override
    public void reset() {
        for (AbstractAccessiblePanel<? extends T> panel : panels) {
            panel.reset();
        }
        conceptsComboBoxActionPerformed(null);
    }
}
