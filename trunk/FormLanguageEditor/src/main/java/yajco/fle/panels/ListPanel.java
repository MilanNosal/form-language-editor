package yajco.fle.panels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/** *  @author Michaela Bačíková
 * @param <T> type of the list item*/
public class ListPanel <T> extends AbstractAccessiblePanel<List<T>> {

    private final DefaultListModel listModel;
    
    // TODO: naco dva rozne panely toho isteho typu?
    private final ConcreteConceptPanelBase addPanel;
    private final ConcreteConceptPanelBase editPanel;
    
    public ListPanel(ConcreteConceptPanelBase addPanel, ConcreteConceptPanelBase editPanel) {
        this.addPanel = addPanel;
        this.editPanel = editPanel;
        //model sa na list nastavi v initComponents
        listModel = new DefaultListModel();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listScrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        buttonPanel = new javax.swing.JPanel();
        addBttn = new javax.swing.JButton();
        editBttn = new javax.swing.JButton();
        deleteBttn = new javax.swing.JButton();

        list.setModel(listModel);
        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        listScrollPane.setViewportView(list);

        buttonPanel.setMaximumSize(new java.awt.Dimension(37, 32767));
        buttonPanel.setMinimumSize(new java.awt.Dimension(37, 100));
        buttonPanel.setPreferredSize(new java.awt.Dimension(37, 0));
        buttonPanel.setLayout(new javax.swing.BoxLayout(buttonPanel, javax.swing.BoxLayout.PAGE_AXIS));

        addBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/add.png"))); // NOI18N
        addBttn.setBorderPainted(false);
        addBttn.setContentAreaFilled(false);
        addBttn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addBttn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/add_pressed.png"))); // NOI18N
        addBttn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/add_selected.png"))); // NOI18N
        addBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBttnActionPerformed(evt);
            }
        });
        buttonPanel.add(addBttn);

        editBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/edit.png"))); // NOI18N
        editBttn.setBorderPainted(false);
        editBttn.setContentAreaFilled(false);
        editBttn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editBttn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/edit_pressed.png"))); // NOI18N
        editBttn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/edit_selected.png"))); // NOI18N
        editBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBttnActionPerformed(evt);
            }
        });
        buttonPanel.add(editBttn);

        deleteBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/delete.png"))); // NOI18N
        deleteBttn.setBorderPainted(false);
        deleteBttn.setContentAreaFilled(false);
        deleteBttn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        deleteBttn.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/delete_pressed.png"))); // NOI18N
        deleteBttn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/delete_selected.png"))); // NOI18N
        deleteBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBttnActionPerformed(evt);
            }
        });
        buttonPanel.add(deleteBttn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBttnActionPerformed
        boolean okPressed = new ConceptDialog(null, addPanel).showDialog();
        if(okPressed) {
            Object value = addPanel.getValue();
            
        }
        
        //panelManager.show(addPanel);
        //odpamatam si index, ktory bol kliknuty
        //TODO: do buducnosti specificky observer pre edit/add v listPaneli
    }//GEN-LAST:event_addBttnActionPerformed

    private void editBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBttnActionPerformed
        //odpamatat si index, ktory bol kliknuty
        //panelManager.show(editPanel);
    }//GEN-LAST:event_editBttnActionPerformed

    private void deleteBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBttnActionPerformed
        List<Object> selectedValues = list.getSelectedValuesList();
        for(Object o : selectedValues) {
            listModel.removeElement(o);
        }
    }//GEN-LAST:event_deleteBttnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBttn;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton deleteBttn;
    private javax.swing.JButton editBttn;
    private javax.swing.JList list;
    private javax.swing.JScrollPane listScrollPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setValue(List<T> value) {
        reset();
        for(T t : value) {
            listModel.addElement(t);
        }
    }

    @Override
    public List<T> getValue() {
        List<T> tlist =  new ArrayList<>();
        for(int i = 0; i < listModel.size(); i++) {
            T elem = (T) listModel.getElementAt(i);
            tlist.add(elem);
        }
        
        return tlist;
    }

    @Override
    public void reset() {
        listModel.removeAllElements();
    }

    @Override
    public void setLabel(String label) {
        list.setName(label);
    }

    @Override
    public void setDescription(String description) {
        list.setToolTipText(description);
    }

    private void addValue(Object value) {
        
    }
}
