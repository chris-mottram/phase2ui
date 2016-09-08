/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DefocusPanel.java
 *
 * Created on Sep 9, 2009, 11:04:38 AM
 */

package ngat.oss.client.gui.panel.sequencepanels;

import ngat.oss.client.gui.panel.*;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

import ngat.phase2.IExecutiveAction;
import ngat.phase2.IFocusOffset;
import ngat.phase2.ISequenceComponent;
import ngat.phase2.XExecutiveComponent;
import ngat.phase2.XFocusOffset;
import ngat.phase2.util.Rounder;

/**
 *
 * @author nrc
 */
public class DefocusPanel extends javax.swing.JPanel implements SequenceComponentPanel {

    private static final String NON_CUMULATIVE = "NON_CUMULATIVE";
    private static final String CUMULATIVE = "CUMULATIVE";

    ButtonGroup buttonGroup;

    /** Creates new form DefocusPanel */
    public DefocusPanel() {
        initComponents();
        initComponents2();
        populateComponents(null);
    }

    public DefocusPanel(XFocusOffset focusOffset) {
        initComponents();
        initComponents2();
        populateComponents(focusOffset);
    }

    private void initComponents2() {

        jrbCumulative.getModel().setActionCommand(CUMULATIVE);
        jrbNoncumulative.getModel().setActionCommand(NON_CUMULATIVE);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(jrbNoncumulative);
        buttonGroup.add(jrbCumulative);
    }

    private void populateComponents(XFocusOffset focusOffset) {
        
        if (focusOffset == null) {
            setButtons(false);
            return;
        }
        
        double offset = focusOffset.getOffset();
        boolean relative = focusOffset.isRelative();

        setButtons(relative);
        
        jtfDefocusAmount.setText(String.valueOf(offset));
    }

    private void setButtons(boolean cumulative) {
        jrbCumulative.getModel().setSelected(cumulative);
        jrbNoncumulative.getModel().setSelected(!cumulative);
    }

    //return XExecutiveComponent
    public ISequenceComponent getSequenceComponent() {

        boolean cumulative = buttonGroup.getSelection().getActionCommand().equals(CUMULATIVE);
        String name = "UNKNOWN_OFFSET_TYPE";
        if (cumulative) {
            name = "CUMULATIVE_FOCUS_OFFSET";
        } else {
            name = "NON_CUMULATIVE_FOCUS_OFFSET";
        }
        double offset = Double.parseDouble(jtfDefocusAmount.getText());

        XFocusOffset focusOffset = new XFocusOffset(cumulative, offset);
        return new XExecutiveComponent(name,(IExecutiveAction) focusOffset);
    }

    public boolean isValidData() {
        try {
            double defocusAmount = Double.parseDouble(jtfDefocusAmount.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a numeric value for defocus");
            return false;
        }

        try {
            double defocusAmount = Double.parseDouble(jtfDefocusAmount.getText());
            if ((defocusAmount > 10) || (defocusAmount < -10)) {
                throw new Exception("defocusAmount entered is outside legal range");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a value for defocus between +10 and -10 mm");
            return false;
        }
        return true;
    }

    public IFocusOffset getFocusOffset() {
        double defocusAmount = Double.parseDouble(jtfDefocusAmount.getText());
        defocusAmount = Rounder.round(defocusAmount, 3); //round to 3 decimal places
        return new XFocusOffset(false, defocusAmount);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jtfDefocusAmount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jrbNoncumulative = new javax.swing.JRadioButton();
        jrbCumulative = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpHelpPane = new javax.swing.JTextPane();

        jLabel9.setText("Defocus");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtfDefocusAmount.setText("0.0");

        jLabel10.setText("mm");

        jrbNoncumulative.setText("Non-Cumulative");

        jrbCumulative.setText("Cumulative");

        jtpHelpPane.setEditable(false);
        jtpHelpPane.setText("This allows deliberate defocusing (e.g. for bright targets). Corrections for optical path differences (e.g. filter changes) are applied automatically and should not be specified here.");
        jScrollPane1.setViewportView(jtpHelpPane);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(78, 78, 78)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jrbCumulative)
                            .add(jrbNoncumulative)
                            .add(layout.createSequentialGroup()
                                .add(jtfDefocusAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 67, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel10))))
                    .add(layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(jLabel9))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel9)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jtfDefocusAmount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jrbNoncumulative)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jrbCumulative)
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrbCumulative;
    private javax.swing.JRadioButton jrbNoncumulative;
    private javax.swing.JTextField jtfDefocusAmount;
    private javax.swing.JTextPane jtpHelpPane;
    // End of variables declaration//GEN-END:variables

}