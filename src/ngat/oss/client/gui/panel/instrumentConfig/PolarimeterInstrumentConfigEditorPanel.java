/*
 *
 * Created on April 17, 2009, 2:07 PM
 */

package ngat.oss.client.gui.panel.instrumentConfig;

import ngat.oss.client.gui.panel.interfaces.IInstrumentConfigPanel;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import ngat.oss.client.gui.reference.CONST;
import ngat.phase2.IDetectorConfig;
import ngat.phase2.IInstrumentConfig;
import ngat.phase2.XDetectorConfig;
import ngat.phase2.XFilterDef;
import ngat.phase2.XFilterSpec;
import ngat.phase2.XImagerInstrumentConfig;
import ngat.phase2.XPolarimeterInstrumentConfig;

/**
 *
 * @author  nrc
 */
public class PolarimeterInstrumentConfigEditorPanel extends javax.swing.JPanel implements IInstrumentConfigPanel {

    private boolean enabled;
    private XPolarimeterInstrumentConfig originalPolarimeterInstrumentConfig;

    public PolarimeterInstrumentConfigEditorPanel(XPolarimeterInstrumentConfig polarimeterInstrumentConfig, boolean isNewInstrumentConfig) {
        
        this.originalPolarimeterInstrumentConfig = polarimeterInstrumentConfig;
        initComponents();
        populateComponents(polarimeterInstrumentConfig, isNewInstrumentConfig);
    }

    private void populateComponents(XPolarimeterInstrumentConfig polarimeterInstrumentConfig, boolean isNewInstrumentConfig) {

        if (polarimeterInstrumentConfig == null) {
            return;
        }

            //deleted 12/11/12:
            /*
            if (isNewInstrumentConfig) {
                jtfInstrumentName.setText(CONST.RINGO2);
                JOptionPane.showMessageDialog(this, "DEFAULTING TO RINGO2");
            } else {
            */

            //not new, get values from polarimeterInstrumentConfig
            jtfInstrumentConfigName.setText(polarimeterInstrumentConfig.getName());
            
            //added 12/11/12 :
        
            if (polarimeterInstrumentConfig.getInstrumentName() == null) {
                //default to RINGO 3
                jcbInstrumentName.setSelectedItem(CONST.RINGO3);
            } else {
                jcbInstrumentName.setSelectedItem(polarimeterInstrumentConfig.getInstrumentName());
            }
            
            int gain = polarimeterInstrumentConfig.getGain();
            String gainStr = String.valueOf(gain);
            jcbGain.setSelectedItem(gainStr);
        //}
    }

    public IInstrumentConfig getInstrumentConfig() throws Exception {
        
        XPolarimeterInstrumentConfig polarimeterInstrumentConfig = new XPolarimeterInstrumentConfig();
        
        polarimeterInstrumentConfig.setID(originalPolarimeterInstrumentConfig.getID());
        String name = jtfInstrumentConfigName.getText();
        
        //deleted 12/11/12:
        //String instrumentName = jtfInstrumentName.getText();
        //added: 12/11/12
        String instrumentName = (String)jcbInstrumentName.getSelectedItem();
        
        int gain = Integer.parseInt((String)jcbGain.getSelectedItem());

        polarimeterInstrumentConfig.setGain(gain);

        XDetectorConfig detectorConfig = new XDetectorConfig();
        detectorConfig.setXBin(1);  //default
        detectorConfig.setYBin(1);  //default
        polarimeterInstrumentConfig.setDetectorConfig(detectorConfig);
        polarimeterInstrumentConfig.setName(name);
        polarimeterInstrumentConfig.setInstrumentName(instrumentName);
       
        return polarimeterInstrumentConfig;
    }
    
    public boolean containsValidInstrumentConfig() {

        return true;
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        jcbGain.setEnabled(enabled);
        //deleted 12/11/12:
        //jtfInstrumentName.setEnabled(enabled);
        //added 12/11/12:
        jcbInstrumentName.setEnabled(enabled);
        jtfInstrumentConfigName.setEnabled(enabled);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jcbInstrumentName = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jtfInstrumentConfigName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jcbGain = new javax.swing.JComboBox();

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Instrument Name"));

        jcbInstrumentName.setModel(new javax.swing.DefaultComboBoxModel(CONST.POLARIMETER_INSTRUMENTS));
        jcbInstrumentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbInstrumentNameActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .add(jcbInstrumentName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 241, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jcbInstrumentName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Instrument Config Name"));

        jLabel3.setText("(no spaces please)");

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jtfInstrumentConfigName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 362, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jtfInstrumentConfigName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Gain"));

        jcbGain.setModel(new javax.swing.DefaultComboBoxModel(CONST.RINGO_GAINS));
        jcbGain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGainActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .add(jcbGain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(387, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jcbGain, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jcbGainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGainActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jcbGainActionPerformed

    private void jcbInstrumentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbInstrumentNameActionPerformed

    }//GEN-LAST:event_jcbInstrumentNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JComboBox jcbGain;
    private javax.swing.JComboBox jcbInstrumentName;
    private javax.swing.JTextField jtfInstrumentConfigName;
    // End of variables declaration//GEN-END:variables

}
