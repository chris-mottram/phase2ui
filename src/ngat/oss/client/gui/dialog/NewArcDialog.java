/*
 * NewTimingConstraintDialog.java
 *
 * Created on April 30, 2009, 10:38 AM
 */
package ngat.oss.client.gui.dialog;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import ngat.phase2.XArc;
import ngat.phase2.XLampDef;
import ngat.phase2.XLampFlat;

/**
 *
 * @author  nrc
 */
public class NewArcDialog extends javax.swing.JDialog {

    XArc arc;

    public NewArcDialog(boolean modal, boolean limitToXeOnly) {
        this.setModal(modal);
        
        initComponents();
        populateComponents(limitToXeOnly);
        centerFrame();
        addListeners();
    }

    private void populateComponents(boolean limitToXeOnly) {
        if (limitToXeOnly)
            jcbLampName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Xe"}));
        else 
            jcbLampName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Xe", "W" }));
    }
    
    private void centerFrame() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        double hd = screenDimension.getHeight();
        double wd = screenDimension.getWidth();

        double yd = (hd - this.getBounds().getHeight()) / 2;
        double xd = (wd - this.getBounds().getWidth()) / 2;

        final int x = (int) xd;
        final int y = (int) yd;

        EventQueue.invokeLater(
                new Runnable() {
                    public void run() {
                        NewArcDialog.this.setLocation(x, y);
                    }
                });
    }

    private void addListeners() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                NewArcDialog.this.setVisible(false);
                NewArcDialog.this.dispose();
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnCreate = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jcbLampName = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create new arc");

        jbtnCreate.setForeground(new java.awt.Color(255, 0, 0));
        jbtnCreate.setText("Create");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel3.setText("Lamp Name:");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 10)); // NOI18N
        jLabel1.setText("Arc");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(jbtnCreate)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jbtnCancel))
                    .add(layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(18, 18, 18)
                        .add(jcbLampName, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(123, 123, 123))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addContainerGap(311, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jcbLampName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnCancel)
                    .add(jbtnCreate))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed
    arc = new XArc();
    arc.setLamp(new XLampDef((String)jcbLampName.getSelectedItem()));
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_jbtnCreateActionPerformed

private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    arc = null;
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_jbtnCancelActionPerformed

public XArc getArc() {
    return this.arc;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JComboBox jcbLampName;
    // End of variables declaration//GEN-END:variables
}