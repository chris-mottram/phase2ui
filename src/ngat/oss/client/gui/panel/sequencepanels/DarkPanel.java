/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RotatorPanel.java
 *
 * Created on Sep 9, 2009, 10:19:07 AM
 */

package ngat.oss.client.gui.panel.sequencepanels;


import ngat.oss.client.gui.panel.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import ngat.phase2.IExecutiveAction;
import ngat.phase2.ISequenceComponent;
import ngat.phase2.XDark;
import ngat.phase2.XExecutiveComponent;

/**
 *
 * @author nrc
 */
public class DarkPanel extends javax.swing.JPanel implements SequenceComponentPanel {

    /** Creates new form RotatorPanel */
    public DarkPanel() {
        initComponents();
    }

    public DarkPanel(XDark dark) {
        this();

        jtfExpTime.setText(String.valueOf(dark.getExposureTime()));
    }

    public ISequenceComponent getSequenceComponent() {

        String expTimeStr = jtfExpTime.getText();

        try {
            double expTime = Double.parseDouble(expTimeStr);

            XDark dark = new XDark();
            dark.setExposureTime(expTime);

            return new XExecutiveComponent("DARK",(IExecutiveAction) dark);

        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    public boolean isValidData() {
        String expTimeStr = jtfExpTime.getText();
        
        try {
            Double.parseDouble(expTimeStr);
        } catch (NumberFormatException nfe) {
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

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfExpTime = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setText("Dark");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Exposure Time:");

        jLabel6.setText("mS");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .add(31, 31, 31)
                .add(jLabel5)
                .add(1, 1, 1)
                .add(jtfExpTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(jLabel6)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jLabel5)
                    .add(jtfExpTime, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
            JFrame j = new JFrame();
            j.getContentPane().setLayout(new BorderLayout());
            j.getContentPane().add(new DarkPanel(), BorderLayout.CENTER);
            j.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jtfExpTime;
    // End of variables declaration//GEN-END:variables

}
