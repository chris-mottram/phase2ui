/*
 * SeeingConstraintPanel.java
 *
 * Created on 15 January 2008, 14:38
 */
package ngat.oss.client.gui.panel.observingConstraint;

import ngat.oss.client.gui.panel.interfaces.IObservingConstraintPanel;
import ngat.phase2.IObservingConstraint;
import ngat.phase2.XPhotometricityConstraint;

/**
 *
 * @author  nrc
 */
public class PhotometricityObservingConstraintPanel extends javax.swing.JPanel implements IObservingConstraintPanel {
    
    private boolean enabled;
    private boolean delete;

    /** Photometricity category, one of:
        IObservingConstraint.PHOTOMETRIC
        IObservingConstraint.NON_PHOTOMETRIC
   
        value of maximumExtinction if photometricityCategory == IObservingConstraint.PHOTOMETRIC 
    */

    /** Creates new form SeeingConstraintPanel */
    public PhotometricityObservingConstraintPanel(XPhotometricityConstraint photometricityConstraint, boolean newObsConstraint) {
        initComponents();
        setValues(photometricityConstraint, newObsConstraint);
    }

    private void setValues(XPhotometricityConstraint photometricityConstraint, boolean newObsConstraint) {
        jbtnDelete.setVisible(false);

        int category = photometricityConstraint.getPhotometricityCategory();
        double maxExtinction = photometricityConstraint.getMaximumExtinction();
        switch(category) {
            case IObservingConstraint.PHOTOMETRIC:
                jcbPhotometricity.setSelectedIndex(0);
                /*
                jtfMaximumExtinction.setEnabled(true);
                jtfMaximumExtinction.setText("" + maxExtinction);
                 */
                break;
            case IObservingConstraint.NON_PHOTOMETRIC:
                jcbPhotometricity.setSelectedIndex(1);
                /*
                jtfMaximumExtinction.setText("");
                jtfMaximumExtinction.setEnabled(false);
                 */
                break;
        }
    }

    public XPhotometricityConstraint getObservingConstraint() {
        int selectedIndex = jcbPhotometricity.getSelectedIndex();
        int category = 0;
        double maxExtinction = 0;
        
        switch (selectedIndex) {
            case 0:
                category = IObservingConstraint.PHOTOMETRIC;
                //maxExtinction = Double.parseDouble(jtfMaximumExtinction.getText());
                break;
            case 1:
                category = IObservingConstraint.NON_PHOTOMETRIC;
                break;
        }
        return new XPhotometricityConstraint(category, maxExtinction);
    }
    
    public boolean containsValidObservingConstraint() {
        return true;
    }
            
    public boolean isEditable() {
        return enabled;
    }

    public void setEditable(boolean enabled) {
        this.enabled = enabled;
        
        jbtnDelete.setVisible(enabled);
        jcbPhotometricity.setEnabled(enabled);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jcbPhotometricity = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpHelpPane = new javax.swing.JTextPane();
        jbtnDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Photometricity Constraint", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 10))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jLabel2.setText("PHOTOMETRICITY=");

        jcbPhotometricity.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jcbPhotometricity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PHOTOMETRIC", "NON_PHOTOMETRIC" }));
        jcbPhotometricity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPhotometricityActionPerformed(evt);
            }
        });

        jtpHelpPane.setEditable(false);
        jtpHelpPane.setText("This constraint is applied at the start of the group. Note these options REQUIRE the given conditions (so observations requesting non-photometric conditions will NOT be executed in photometric ones).  If you do not care about photometricity then delete this constraint entirely.");
        jScrollPane1.setViewportView(jtpHelpPane);

        jbtnDelete.setText("Click to delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jbtnDelete)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
                .add(33, 33, 33))
            .add(layout.createSequentialGroup()
                .add(jLabel2)
                .add(2, 2, 2)
                .add(jcbPhotometricity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jcbPhotometricity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jbtnDelete)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean shouldBeDeleted() {
        return delete;
    }
    
    private void jcbPhotometricityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPhotometricityActionPerformed
        
       // jtfMaximumExtinction.setEnabled(jcbPhotometricity.getSelectedIndex() ==0);
    }//GEN-LAST:event_jcbPhotometricityActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        if (!delete) {
            jbtnDelete.setText("Will be deleted, click to undelete");
            delete = true;
        } else {
            jbtnDelete.setText("Click to delete");
            delete = false;
        }
}//GEN-LAST:event_jbtnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JComboBox jcbPhotometricity;
    private javax.swing.JTextPane jtpHelpPane;
    // End of variables declaration//GEN-END:variables
}
