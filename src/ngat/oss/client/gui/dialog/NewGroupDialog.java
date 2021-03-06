/*
 * NewTimingConstraintDialog.java
 *
 * Created on April 30, 2009, 10:38 AM
 */
package ngat.oss.client.gui.dialog;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import ngat.oss.client.Phase2ModelClient;
import ngat.oss.client.gui.frame.MainFrame;
import ngat.oss.client.gui.util.LimitedCharactersDocument;
import ngat.oss.exception.Phase2Exception;
import ngat.phase2.IObservingConstraint;
import ngat.phase2.IProposal;
import ngat.phase2.ITimingConstraint;
import ngat.phase2.XFixedTimingConstraint;
import ngat.phase2.XGroup;
import ngat.phase2.XPhotometricityConstraint;
import ngat.phase2.XSeeingConstraint;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 */
public class NewGroupDialog extends javax.swing.JDialog implements ActionListener {

    static Logger logger = Logger.getLogger(NewGroupDialog.class);

    private IProposal proposal = null;

    public NewGroupDialog(boolean modal, IProposal proposal) {
        this.proposal = proposal;
        this.setModal(modal);
        initComponents();
        initComponents2();
        centerFrame();
        addListeners();
    }

    private void initComponents2() {
        jtfName.setDocument(new LimitedCharactersDocument(LimitedCharactersDocument.STRICT_LIMITATION));

        jcbUrgent.setVisible(proposal.allowsUrgentGroups());
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
                        NewGroupDialog.this.setLocation(x, y);
                    }
                });
    }

    private void addListeners() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                NewGroupDialog.this.setVisible(false);
                NewGroupDialog.this.dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent actionEvent) {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        timingConstraintEditorPanel = new ngat.beans.guibeans.TimingConstraintEditorPanel(proposal.allowsFixedGroups());
        observingConstraintsEditorPanel = new ngat.beans.guibeans.ObservingConstraintsEditorPanel();
        jcbEnabled = new javax.swing.JCheckBox();
        jcbUrgent = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Group");

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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 10));
        jLabel1.setText("GROUP");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 10));
        jLabel2.setText("Name:");

        timingConstraintEditorPanel.setEnabled(true);

        observingConstraintsEditorPanel.setEnabled(true);

        jcbEnabled.setSelected(true);
        jcbEnabled.setText("Group is Enabled");

        jcbUrgent.setText("Group is Urgent");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(layout.createSequentialGroup()
                                .add(12, 12, 12)
                                .add(jLabel1))
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jtfName))
                            .add(timingConstraintEditorPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(observingConstraintsEditorPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE))
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(jbtnCreate)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCancel)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jcbEnabled)
                        .add(18, 18, 18)
                        .add(jcbUrgent)
                        .add(180, 180, 180))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jtfName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(timingConstraintEditorPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(3, 3, 3)
                .add(observingConstraintsEditorPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnCreate)
                    .add(jbtnCancel)
                    .add(jcbEnabled)
                    .add(jcbUrgent))
                .add(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private boolean isValidTimingConstraintVersusObsConstraints() {
        ITimingConstraint timingConstraint =  timingConstraintEditorPanel.getTimingConstraint();
        if (timingConstraint instanceof XFixedTimingConstraint) {
            //it's a fixed timing constraint, iterate through the observing constraints to check for disallowed ones
            Iterator i = observingConstraintsEditorPanel.getObservingConstraints().iterator();
            while (i.hasNext()) {
                IObservingConstraint observingConstraint = (IObservingConstraint) i.next();
                //System.err.println(observingConstraint.getClass().getName());
                if (observingConstraint instanceof XSeeingConstraint) {
                    //ok
                } else if (observingConstraint instanceof XPhotometricityConstraint) {
                    //that's ok too
                } else {
                    return false;
                }
            }
            return true; //no constraints other than Seeing and Photometricity have been found
        } else {
          //it's not a fixed timing constraint
          return true;
        }
    }
    
private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed

    XGroup xGroup = new XGroup();
    
    //required fields: name, priority, active, timingConstraint, observingConstraints
    String name;
    int priority;
    boolean groupIsEnabled;
    ITimingConstraint timingConstraint;
    List observingConstraints;
        
    name = jtfName.getText().trim();
    
    if (name.length() == 0) {
        JOptionPane.showMessageDialog(this, "Please set a name for the group.", "Submission failed", JOptionPane.OK_OPTION );
        return;
    }

    Phase2ModelClient phase2ModelClient = Phase2ModelClient.getInstance();
    try {
        if (phase2ModelClient.findIdOfGroupInProposal(name, proposal.getID()) != -1) {
            JOptionPane.showMessageDialog(this, "Another group exist with this name in this proposal, please enter a different name.");
           return;
        }
    } catch (Phase2Exception ex) {
        ex.printStackTrace();
        logger.error(ex);
        JOptionPane.showMessageDialog(this, ex.getMessage());
        JOptionPane.showMessageDialog(this, "The group was NOT added");
        return;
    }

    try {
        if (groupExists(name, proposal.getID())) {
            JOptionPane.showMessageDialog(this, "A group with that name already exists on this proposal, please enter a different name.");
            return;
        }

        //clear out the obs constraints panels that are no longer needed
        observingConstraintsEditorPanel.deleteSelectedObservingConstraints();

        if (!isValidTimingConstraintVersusObsConstraints()) {
            JOptionPane.showMessageDialog(this, "The submission was not successful. \n\nA Fixed Timing Constraint has been requested, however Observing Constraints other than 'Seeing' and 'Photometricity' have also been specified.\n\nIf you wish to use a Fixed Timing Constraint then delete the invalid Observing Constraints and click Submit again.");
            return;
        }

        //set priority to 1. unused feature atm.
        priority = 1;
        groupIsEnabled = jcbEnabled.isSelected();
        timingConstraint = timingConstraintEditorPanel.getTimingConstraint();

        observingConstraints = observingConstraintsEditorPanel.getObservingConstraints();

        boolean urgent = false;
        if (proposal.allowsUrgentGroups()) {
            urgent = jcbUrgent.isSelected();
        }

        xGroup.setName(name);
        xGroup.setPriority(priority);
        xGroup.setActive(groupIsEnabled);
        xGroup.setTimingConstraint(timingConstraint);
        xGroup.setObservingConstraints(observingConstraints);
        xGroup.setUrgent(urgent);
        
        long gid = Phase2ModelClient.getInstance().addGroup(proposal.getID(), xGroup);
        xGroup.setID(gid);
    } catch (Exception ex) {
        ex.printStackTrace();
        logger.error(ex);
        JOptionPane.showMessageDialog(this, ex.getMessage());
        JOptionPane.showMessageDialog(this, "creating new group failed");
        return;
    }     
    
    this.setVisible(false);
    this.dispose();

    MainFrame.getInstance().receiveNewTreeObject(xGroup);
}//GEN-LAST:event_jbtnCreateActionPerformed

private boolean groupExists(String groupName, long proposalId) throws Phase2Exception {
    boolean groupExists = Phase2ModelClient.getInstance().groupExists(groupName, proposalId);
    return groupExists;
}

private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    this.setVisible(false);
    this.dispose();

}//GEN-LAST:event_jbtnCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JCheckBox jcbEnabled;
    private javax.swing.JCheckBox jcbUrgent;
    private javax.swing.JTextField jtfName;
    private ngat.beans.guibeans.ObservingConstraintsEditorPanel observingConstraintsEditorPanel;
    private ngat.beans.guibeans.TimingConstraintEditorPanel timingConstraintEditorPanel;
    // End of variables declaration//GEN-END:variables
}
