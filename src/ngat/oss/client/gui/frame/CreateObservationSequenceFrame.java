/*
 * CreateObservationSequenceFrame.java
 *
 * Created on June 11, 2009, 10:35 AM
 */

package ngat.oss.client.gui.frame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ngat.oss.client.Phase2ModelClient;
import ngat.oss.client.gui.panel.wizards.WizardPanelDualBeamSpectrographSequence;
import ngat.oss.client.gui.panel.ObservationSequenceEditorPanel;
import ngat.oss.client.gui.panel.wizards.WizardPanelPhotometryPolarimetrySequence;
import ngat.oss.client.gui.panel.SelectSequenceTypePanel;
import ngat.oss.client.gui.panel.ShowObservationSequencePanel;
import ngat.oss.client.gui.listeners.ObservationSequenceAddedListener;
import ngat.oss.client.gui.panel.wizards.WizardPanelImagingSpectrographSequence;
import ngat.oss.client.gui.panel.wizards.WizardPanelTwoSlitSpectrographSequence;
import ngat.oss.client.gui.panel.wizards.WizardPanelUpdateSequenceRotator;
import ngat.oss.client.gui.reference.CONST;
import ngat.oss.exception.Phase2Exception;
import ngat.phase2.IGroup;
import ngat.phase2.IProgram;
import ngat.phase2.ISequenceComponent;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 */
public class CreateObservationSequenceFrame extends javax.swing.JFrame {

    static Logger logger = Logger.getLogger(CreateObservationSequenceFrame.class);
    
    private IGroup group;
    private IProgram program;
    private ArrayList observationSequenceAddedListeners = new ArrayList();

    /** Creates new form CreateObservationSequenceFrame */
    public CreateObservationSequenceFrame(IGroup group) throws Phase2Exception {
        this.group = group;
        
        this.program = getProgrammeOfGroup(group); //throws Exception
        
        initComponents();
        jpContainerPanel.setLayout(new BorderLayout());
        showHeaderPanel(new SelectSequenceTypePanel());
        setSize(CONST.MAIN_FRAME_SIZE);
        centerFrame();
    }
    
    public void showHeaderPanel(final JPanel displayPanel) {
        
        final JPanel containerPanel = jpContainerPanel;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                containerPanel.removeAll();
                containerPanel.add(displayPanel, BorderLayout.CENTER);
                containerPanel.validate();
                containerPanel.repaint();
            }
        });
    }

    private IProgram getProgrammeOfGroup(IGroup group) throws Phase2Exception {
        IProgram programme = Phase2ModelClient.getInstance().getProgrammeOfGroup(group.getID());
        return programme;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnForward = new javax.swing.JButton();
        jpContainerPanel = new javax.swing.JPanel();
        jbtnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jbtnForward.setText("Continue");
        jbtnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnForwardActionPerformed(evt);
            }
        });

        jpContainerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.jdesktop.layout.GroupLayout jpContainerPanelLayout = new org.jdesktop.layout.GroupLayout(jpContainerPanel);
        jpContainerPanel.setLayout(jpContainerPanelLayout);
        jpContainerPanelLayout.setHorizontalGroup(
            jpContainerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 812, Short.MAX_VALUE)
        );
        jpContainerPanelLayout.setVerticalGroup(
            jpContainerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 627, Short.MAX_VALUE)
        );

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(7, 7, 7)
                .add(jbtnForward)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 599, Short.MAX_VALUE)
                .add(jbtnCancel)
                .addContainerGap())
            .add(jpContainerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(new java.awt.Component[] {jbtnCancel, jbtnForward}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jpContainerPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jbtnForward)
                    .add(jbtnCancel))
                .add(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnForwardActionPerformed

    Component containedComponent = jpContainerPanel.getComponents()[0];

    //SelectSequenceTypePanel
    if (containedComponent instanceof SelectSequenceTypePanel) {
        SelectSequenceTypePanel selectSequenceTypePanel = (SelectSequenceTypePanel)containedComponent;
        
        String actionCommand = selectSequenceTypePanel.getActionCommand();
        if (actionCommand.equals(SelectSequenceTypePanel.MULTI_COLOUR_PHOTOMETRY_WIZARD)) {
            showHeaderPanel(new WizardPanelPhotometryPolarimetrySequence(program, actionCommand));
            this.setTitle("(Create) Photometric sequence wizard");
            
        } else if (actionCommand.equals(SelectSequenceTypePanel.POLARIMETRY_WIZARD)) {
            showHeaderPanel(new WizardPanelPhotometryPolarimetrySequence(program, actionCommand));
            this.setTitle("(Create) Polarimetry sequence editor");
            
        } else if (actionCommand.equals(SelectSequenceTypePanel.FRODO_WIZARD)) {
            showHeaderPanel(new WizardPanelDualBeamSpectrographSequence(program));
            this.setTitle("(Create) Dual-beam spectrograph sequence wizard");
            
        } else if (actionCommand.equals(SelectSequenceTypePanel.MANUAL_SEQUENCE_EDITOR)) {
            showHeaderPanel(new ObservationSequenceEditorPanel(group, program, true));
            this.setTitle("(Create) Photometric sequence editor");
            
        } else if (actionCommand.equals(SelectSequenceTypePanel.SPRAT_WIZARD)) {
            showHeaderPanel(new WizardPanelImagingSpectrographSequence(group, program));
            this.setTitle("(Create) Imaging spectrograph sequence wizard");
        
        } else if (actionCommand.equals(SelectSequenceTypePanel.LOTUS_WIZARD)) {
            showHeaderPanel(new WizardPanelTwoSlitSpectrographSequence(group, program));
            this.setTitle("(Create) Two slit spectrograph sequence wizard");
        }

    //PhotometricSequenceWizardPanel
    } else if (containedComponent instanceof WizardPanelPhotometryPolarimetrySequence) {
        WizardPanelPhotometryPolarimetrySequence multiColourPhotomSequencePanel = (WizardPanelPhotometryPolarimetrySequence) containedComponent;
        ISequenceComponent observationSequence = multiColourPhotomSequencePanel.getObservationSequence();
        if (multiColourPhotomSequencePanel.rotatorValueNeedsSetting()) {
            showHeaderPanel(new WizardPanelUpdateSequenceRotator(observationSequence));
            this.setTitle("Manual Rotator Setting");
            return;
        }
        if (observationSequence != null) {
            submitObservationSequence(observationSequence, group);
        } else {
            //observationSequence == null, leave the panel in place
            return;
        }
/*
    //WizardPanelIOOPhotometrySequence
    } else if (containedComponent instanceof WizardPanelIOOPhotometrySequence) {
        WizardPanelIOOPhotometrySequence multiColourPhotomSequencePanel = (WizardPanelIOOPhotometrySequence) containedComponent;
        ISequenceComponent observationSequence = multiColourPhotomSequencePanel.getObservationSequence();
        if (multiColourPhotomSequencePanel.rotatorValueNeedsSetting()) {
            showHeaderPanel(new WizardPanelUpdateSequenceRotator(observationSequence));
            this.setTitle("Manual Rotator Setting");
            return;
        }
        if (observationSequence != null) {
            submitObservationSequence(observationSequence, group);
        } else {
            //observationSequence == null, leave the panel in place
            return;
        }
*/
   //UpdateSequenceRotatorWizardPanel
   } else if (containedComponent instanceof WizardPanelUpdateSequenceRotator) {
        WizardPanelUpdateSequenceRotator updateSequenceRotatorWizardPanel = (WizardPanelUpdateSequenceRotator) containedComponent;
        int rotValidationResult = updateSequenceRotatorWizardPanel.validateRotatorValue();

        if (rotValidationResult == WizardPanelUpdateSequenceRotator.ANGLE_NOT_A_NUMBER) {
            JOptionPane.showMessageDialog(this, "Please enter a numerical value for the rotator angle.");
            return;
        } else if (rotValidationResult == WizardPanelUpdateSequenceRotator.MOUNT_OUT_OF_BOUNDS) {
            JOptionPane.showMessageDialog(this, "Please make sure the mount angle is between +90 and -90 degrees.");
            return;
        } else if (rotValidationResult == WizardPanelUpdateSequenceRotator.SKY_OUT_OF_BOUNDS) {
            JOptionPane.showMessageDialog(this, "Please make sure the sky angle is between 0 and 360 degrees.");
            return;
        }

        ISequenceComponent observationSequence = updateSequenceRotatorWizardPanel.getObservationSequence();
        if (observationSequence != null) {
            submitObservationSequence(observationSequence, group);
        } else {
            //observationSequence == null, leave the panel in place
            return;
        }
        
    //ObservationSequenceEditorPanel
    } else if (containedComponent instanceof ObservationSequenceEditorPanel) {
        ObservationSequenceEditorPanel photomSequenceEditorPanel = (ObservationSequenceEditorPanel) containedComponent;
        String errorMessage = photomSequenceEditorPanel.validateObservationSequence();
        if (errorMessage != null) {
            JOptionPane.showMessageDialog(this, errorMessage);
            return;
        }
        ISequenceComponent observationSequence = photomSequenceEditorPanel.getObservationSequence();
        if (observationSequence != null) {
            submitObservationSequence(observationSequence, group);
        } else {
            //observationSequence == null, leave the panel in place
            return;
        }

    //DualBeamSpectrographSequenceWizardPanel
    } else if (containedComponent instanceof WizardPanelDualBeamSpectrographSequence) {
        
        WizardPanelDualBeamSpectrographSequence dualBeamSpectrographSequencePanel = (WizardPanelDualBeamSpectrographSequence) containedComponent;
        ISequenceComponent observationSequence = dualBeamSpectrographSequencePanel.getObservationSequence();
        if (dualBeamSpectrographSequencePanel.rotatorValueNeedsSetting()) {
            showHeaderPanel(new WizardPanelUpdateSequenceRotator(observationSequence));
            this.setTitle("Manual Rotator Setting");
            return;
        }
        if (observationSequence != null) {
            submitObservationSequence(observationSequence, group);
        } else {
            JOptionPane.showMessageDialog(this, "Observation sequence was null");
            this.dispose();
            this.setVisible(false);
            return;
        }
    
    } else if (containedComponent instanceof WizardPanelImagingSpectrographSequence) {
        
        WizardPanelImagingSpectrographSequence wizardPanelImagingSpectrographSequence = (WizardPanelImagingSpectrographSequence) containedComponent;
        ISequenceComponent observationSequence = wizardPanelImagingSpectrographSequence.getObservationSequence();
        /*
        if (wizardPanelImagingSpectrographSequence.rotatorValueNeedsSetting()) {
            showHeaderPanel(new WizardPanelUpdateSequenceRotator(observationSequence));
            this.setTitle("Manual Rotator Setting");
            return;
        }
        */
        if (observationSequence != null) {
            submitObservationSequence(observationSequence, group);
        } else {
            JOptionPane.showMessageDialog(this, "Observation sequence was null");
            this.dispose();
            this.setVisible(false);
            return;
        }
    } else if (containedComponent instanceof WizardPanelTwoSlitSpectrographSequence) {
        
        WizardPanelTwoSlitSpectrographSequence wizardPanelLowResolutionSpectrographSequence = (WizardPanelTwoSlitSpectrographSequence) containedComponent;
        ISequenceComponent observationSequence = wizardPanelLowResolutionSpectrographSequence.getObservationSequence();
        
        if (observationSequence != null) {
            submitObservationSequence(observationSequence, group);
        } else {
            JOptionPane.showMessageDialog(this, "Observation sequence was null");
            this.dispose();
            this.setVisible(false);
            return;
        }
                
    } else if (containedComponent instanceof ShowObservationSequencePanel) {
        this.setVisible(false);
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Unknown panel: " + containedComponent.getClass().getName());
    }
}//GEN-LAST:event_jbtnForwardActionPerformed

private void submitObservationSequence(ISequenceComponent observationSequence, IGroup group) {
    try {
        logger.info("invoking Phase2ModelClient.getInstance().addObservationSequence(" + group.getID() + ", " + observationSequence + ")");
        Phase2ModelClient.getInstance().addObservationSequence(group.getID(), observationSequence);
        sendObservationSequenceAddedEvent();
        JOptionPane.showMessageDialog(this, "Observation sequence added");
        showHeaderPanel(new ShowObservationSequencePanel(group));
        this.setTitle("Displaying Observation Sequence of " + group.getName());
        jbtnCancel.setVisible(false);
    } catch (RemoteException ex) {
        ex.printStackTrace();
        logger.error(ex);
        JOptionPane.showMessageDialog(this, ex);
        this.dispose();
        this.setVisible(false);
        return;
    }
}

private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_jbtnCancelActionPerformed

public void addObservationSequenceAddedListener(ObservationSequenceAddedListener obsSeqAddedListener) {
    observationSequenceAddedListeners.add(obsSeqAddedListener);
}

//send to listening components an event indicating that a sequence has been added
private void sendObservationSequenceAddedEvent() {
    Iterator i = observationSequenceAddedListeners.iterator();
    while (i.hasNext()) {
        ObservationSequenceAddedListener observationSequenceAddedListener
                = (ObservationSequenceAddedListener)i.next();
        System.out.println(observationSequenceAddedListener);
        observationSequenceAddedListener.receiveObservationSequenceAdded();
    }
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
                        CreateObservationSequenceFrame.this.setLocation(x, y);
                    }
                });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnForward;
    private javax.swing.JPanel jpContainerPanel;
    // End of variables declaration//GEN-END:variables

}
