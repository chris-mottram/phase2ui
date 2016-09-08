/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MultipleExposurePanel.java
 *
 * Created on Sep 29, 2010, 11:15:04 AM
 */

package ngat.oss.client.gui.panel.sequencepanels.sub;

import javax.swing.JOptionPane;
import ngat.oss.client.gui.reference.Session;
import ngat.phase2.IExposure;
import ngat.phase2.XPeriodExposure;

/**
 *
 * @author nrc
 */
public class PeriodExposurePanel extends javax.swing.JPanel implements IExposurePanel {

    XPeriodExposure periodExposure;

    /** Creates new form MultipleExposurePanel */
    public PeriodExposurePanel(XPeriodExposure periodExposure) {
        initComponents();
        this.periodExposure = periodExposure;
        populateComponents();
    }

    private void populateComponents() {
        /*
        double exposureTime = periodExposure.getExposureTime();

        jrbDuration.setSelected(true);
        lblRepeats.setVisible(false);
        jtfExposureCount.setVisible(false);

        jtfExposureTime.setText(String.valueOf(exposureTime / 1000));

        */

        boolean isStandard = periodExposure.isStandard();
        double exposureTime = periodExposure.getExposureTime();

        jcbIsStandard.setSelected(isStandard);
        jtfExposureTime.setText(String.valueOf(exposureTime / 1000));

        jcbIsStandard.setVisible(Session.getInstance().getUser().isSuperUser());
    }

    public IExposure getExposure() {

        XPeriodExposure periodExposure = new XPeriodExposure();
        double exposureTime = Double.parseDouble(jtfExposureTime.getText());
        boolean isStandard = jcbIsStandard.isSelected();

        periodExposure.setExposureTime(exposureTime * 1000); //convert to mS
        periodExposure.setStandard(isStandard);

        return periodExposure;
    }

    public boolean containsValidData() {
        try {
            Double.parseDouble(jtfExposureTime.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a numeric value for exposure time");
            return false;
        }
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

        jtfExposureTime = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcbIsStandard = new javax.swing.JCheckBox();

        jtfExposureTime.setText("1.0");

        jLabel16.setText("exposure time:");

        jLabel14.setText("seconds");

        jcbIsStandard.setText("is standard");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel16)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jtfExposureTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel14)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 195, Short.MAX_VALUE)
                .add(jcbIsStandard))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel14)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jtfExposureTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel16)))
                    .add(jcbIsStandard))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JCheckBox jcbIsStandard;
    private javax.swing.JTextField jtfExposureTime;
    // End of variables declaration//GEN-END:variables

}