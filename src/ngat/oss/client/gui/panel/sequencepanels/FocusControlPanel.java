/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ExposurePanel.java
 *
 * Created on Sep 9, 2009, 12:08:25 PM
 */

package ngat.oss.client.gui.panel.sequencepanels;

import ngat.oss.client.gui.panel.*;
import ngat.oss.client.gui.reference.CONST;
import ngat.phase2.IAcquisitionConfig;
import ngat.phase2.IExecutiveAction;
import ngat.phase2.ISequenceComponent;
import ngat.phase2.XAcquisitionConfig;
import ngat.phase2.XExecutiveComponent;
import ngat.phase2.XFocusControl;

/**
 *
 * @author nrc
 */
public class FocusControlPanel extends javax.swing.JPanel implements SequenceComponentPanel {

    public FocusControlPanel() {
        initComponents();
    }

    public FocusControlPanel(XFocusControl focusControl) {
        initComponents();
        populateComponents(focusControl);
    }
    
    private void populateComponents(XFocusControl focusControl) {
       
        String instrumentName = focusControl.getInstrumentName();
        jcbInstrument.setSelectedItem(instrumentName);
    }

    public ISequenceComponent getSequenceComponent() {

        //currently assumes that the exposure type is a XMultipleExposure
        XFocusControl focusControl = new XFocusControl();
        String instrumentName = (String) jcbInstrument.getSelectedItem();
        focusControl.setInstrumentName(instrumentName);

        XExecutiveComponent executiveComponent = new XExecutiveComponent("FOCUS_CONTROL",(IExecutiveAction) focusControl);

        return executiveComponent;
    }
    
    public boolean isValidData() {
        return true;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jcbInstrument = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpHelpPane = new javax.swing.JTextPane();

        jLabel13.setText("Focus Control");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Target Instrument:");

        jcbInstrument.setModel(new javax.swing.DefaultComboBoxModel(CONST.BEAM_STEERING_INSTRUMENTS));

        jtpHelpPane.setEditable(false);
        jtpHelpPane.setText("Select the detector array for which to set optimal focus. During simultaneous multi-band imaging, other detectors may be slightly defocussed.");
        jScrollPane1.setViewportView(jtpHelpPane);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(jLabel1)
                        .add(5, 5, 5)
                        .add(jcbInstrument, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 152, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jLabel13))
                .addContainerGap(348, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .add(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel13)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jcbInstrument, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 152, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbInstrument;
    private javax.swing.JTextPane jtpHelpPane;
    // End of variables declaration//GEN-END:variables

}