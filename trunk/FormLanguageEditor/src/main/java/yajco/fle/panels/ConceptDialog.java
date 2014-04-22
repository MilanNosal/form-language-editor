package yajco.fle.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import yajco.fle.panels.interfaces.Labeled;

/**
 * @author Michaela Bačíková
 */
public class ConceptDialog extends javax.swing.JDialog {
    private boolean okPressed = false;

    private final AbstractAccessiblePanel content;

    public ConceptDialog(java.awt.Frame parent, AbstractAccessiblePanel content) {
        super(parent, true);
        initComponents();
        //rootPane.setWindowDecorationStyle(JRootPane.FRAME);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.content = content;

        contentPanel.add(content);
        pack();
        setLocationRelativeTo(parent);

        //Enter/ESC behaviour        
        rootPane.setDefaultButton(okButton);

        ActionListener cancelListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelButtonActionPerformed(e);
            }
        };
        cancelButton.addActionListener(cancelListener);
        rootPane.registerKeyboardAction(cancelListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        //set title
        if (content instanceof Labeled) {
            this.setTitle(((Labeled) content).getLabel());
        }
        
        //set dialog move/resize adapter
        new DialogResizeAdapter(this, topPanel, DialogResizeAdapter.Action.MOVE);
        new DialogResizeAdapter(this, resizeRightPanel, DialogResizeAdapter.Action.RESIZE_RIGHT);
        new DialogResizeAdapter(this, resizeLeftPanel, DialogResizeAdapter.Action.RESIZE_LEFT);
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
        titleLabel.setText(title);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        contentPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        resizeRightPanel = new javax.swing.JLabel();
        resizeLeftPanel = new javax.swing.JLabel();

        setModal(true);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        topPanel.setBackground(new java.awt.Color(0, 0, 0));

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("title");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("yajco.flee");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(topPanel, java.awt.BorderLayout.PAGE_START);

        scrollPane.setBorder(null);

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setLayout(new java.awt.BorderLayout());
        scrollPane.setViewportView(contentPanel);

        jPanel1.add(scrollPane, java.awt.BorderLayout.CENTER);

        buttonPanel.setBackground(new java.awt.Color(255, 255, 255));

        okButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/ok.png"))); // NOI18N
        okButton.setToolTipText("OK");
        okButton.setBorderPainted(false);
        okButton.setContentAreaFilled(false);
        okButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/ok_disabled.png"))); // NOI18N
        okButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        okButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/ok_pressed.png"))); // NOI18N
        okButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/ok_selected.png"))); // NOI18N
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        resetButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/reset.png"))); // NOI18N
        resetButton.setToolTipText("Reset");
        resetButton.setBorderPainted(false);
        resetButton.setContentAreaFilled(false);
        resetButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/reset_disabled.png"))); // NOI18N
        resetButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        resetButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/reset_pressed.png"))); // NOI18N
        resetButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/reset_selected.png"))); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/cancel.png"))); // NOI18N
        cancelButton.setToolTipText("Cancel");
        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/cancel_disabled.png"))); // NOI18N
        cancelButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        cancelButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/cancel_pressed.png"))); // NOI18N
        cancelButton.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/cancel_selected.png"))); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        resizeRightPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/resize_right.png"))); // NOI18N

        resizeLeftPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yajco/fle/panels/icons/resize_left.png"))); // NOI18N

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(okButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addComponent(resizeLeftPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resizeRightPanel))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                        .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(okButton)
                            .addComponent(resetButton)
                            .addComponent(cancelButton))
                        .addGap(3, 3, 3)
                        .addComponent(resizeRightPanel))
                    .addComponent(resizeLeftPanel, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

        jPanel1.add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        okPressed = true;
        setVisible(false);
    }//GEN-LAST:event_okButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        content.reset();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    public boolean showDialog() {
        setVisible(true);
        return okPressed;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JLabel resizeLeftPanel;
    private javax.swing.JLabel resizeRightPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
