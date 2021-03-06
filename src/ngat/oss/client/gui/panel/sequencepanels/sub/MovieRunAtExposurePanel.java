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

import java.text.ParseException;
import javax.swing.JOptionPane;
import ngat.oss.client.gui.reference.Session;
import ngat.phase2.IExposure;
import ngat.phase2.XPeriodRunAtExposure;
import org.apache.log4j.Logger;

/**
 *
 * @author nrc
 */
public class MovieRunAtExposurePanel extends javax.swing.JPanel implements IExposurePanel {

    static Logger logger = Logger.getLogger(MovieRunAtExposurePanel.class);

    XPeriodRunAtExposure periodRunAtExposure;
    
    /** Creates new form MultipleExposurePanel */
    public MovieRunAtExposurePanel(XPeriodRunAtExposure periodRunAtExposure) {
        //System.err.println("PeriodRunAtExposurePanel(" + periodRunAtExposure + ")");
        initComponents();
        this.periodRunAtExposure = periodRunAtExposure;
        populateComponents();
    }

    private void populateComponents() {

        jcbIsStandard.setSelected(periodRunAtExposure.isStandard());
        jtfExposureLength.setText(String.valueOf(periodRunAtExposure.getExposureLength() / 1000));
        jtfExposureDuration.setText(String.valueOf(periodRunAtExposure.getTotalExposureDuration() / 1000));
        dteRunAtTime.setTime(periodRunAtExposure.getRunAtTime(), false);
        
        jcbIsStandard.setVisible(Session.getInstance().getUser().isSuperUser());
    }

    public IExposure getExposure() {
        try {
            XPeriodRunAtExposure periodRunAtExposure = new XPeriodRunAtExposure();
            double exposureLength = Double.parseDouble(jtfExposureLength.getText());
            double totalExposureDuration = Double.parseDouble(jtfExposureDuration.getText());
            boolean isStandard = jcbIsStandard.isSelected();
            
            periodRunAtExposure.setExposureLength(exposureLength * 1000); //convert to mS
            periodRunAtExposure.setTotalExposureDuration(totalExposureDuration * 1000); //convert to mS
            periodRunAtExposure.setRunAtTime(dteRunAtTime.getTime());
            periodRunAtExposure.setStandard(isStandard);

            //System.err.println("getExposure() returns(" + periodRunAtExposure + ")");
            
            return periodRunAtExposure;
        } catch (ParseException ex) {
            ex.printStackTrace();
            logger.error(ex);
            return null;
        }
       
    }

    public boolean containsValidData() {
        try {
            dteRunAtTime.getTime();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date");
            return false;
        }

        try {
            Double.parseDouble(jtfExposureLength.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a numeric value for exposure length");
            return false;
        }

        try {
            Double.parseDouble(jtfExposureDuration.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a numeric value for exposure duration");
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

        jtfExposureLength = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jcbIsStandard = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        jtfExposureDuration = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        dteRunAtTime = new ngat.beans.guibeans.DateTimeEditorPanel();

        jtfExposureLength.setText("1.0");

        jLabel16.setText("Exposure Length:");

        jLabel14.setText("seconds");

        jcbIsStandard.setText("is standard");

        jLabel17.setText("Total Exposure Duration:");

        jtfExposureDuration.setText("1.0");

        jLabel15.setText("seconds");

        dteRunAtTime.setTitle("Run-at Time:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel17)
                    .add(jLabel16))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jtfExposureDuration, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel15))
                    .add(layout.createSequentialGroup()
                        .add(jtfExposureLength, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel14)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 48, Short.MAX_VALUE)
                        .add(jcbIsStandard)))
                .addContainerGap())
            .add(dteRunAtTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 446, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel14)
                        .add(jcbIsStandard))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jtfExposureLength, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel16)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel15)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jtfExposureDuration, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel17)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(dteRunAtTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ngat.beans.guibeans.DateTimeEditorPanel dteRunAtTime;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JCheckBox jcbIsStandard;
    private javax.swing.JTextField jtfExposureDuration;
    private javax.swing.JTextField jtfExposureLength;
    // End of variables declaration//GEN-END:variables

}
