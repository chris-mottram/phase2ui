/*
 * EphemerisTimingConstraintEditorPanel.java
 *
 * Created on April 17, 2009, 2:07 PM
 */

package ngat.oss.client.gui.panel.timingConstraint;

import ngat.oss.client.gui.panel.interfaces.ITimingConstraintPanel;
import ngat.phase2.ITimingConstraint;
import ngat.phase2.XEphemerisTimingConstraint;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 */
public class PhasedTimingConstraintEditorPanel extends javax.swing.JPanel implements ITimingConstraintPanel {

    static Logger logger = Logger.getLogger(PhasedTimingConstraintEditorPanel.class);

    private XEphemerisTimingConstraint ephemerisTimingConstraint;
    private boolean enabled;
    private boolean isNewTimingConstraint;

    /** Creates new form EphemerisTimingConstraintEditorPanel */
    public PhasedTimingConstraintEditorPanel(XEphemerisTimingConstraint ephemerisTimingConstraint, boolean isNewTimingConstraint) {
        this.ephemerisTimingConstraint = ephemerisTimingConstraint;
        this.isNewTimingConstraint = isNewTimingConstraint;
        initComponents();
        populateComponents();
    }

    private void populateComponents() {
        dteEndDate.setTime(ephemerisTimingConstraint.getEnd(), isNewTimingConstraint);
        dteStartDate.setTime(ephemerisTimingConstraint.getStart(), isNewTimingConstraint);
        msepCyclePeriod.setTime(ephemerisTimingConstraint.getCyclePeriod());
        msepWindow.setTime(ephemerisTimingConstraint.getWindow());
        jtfPhase.setText(String.valueOf(ephemerisTimingConstraint.getPhase()));
    }
    
    public ITimingConstraint getTimingConstraint() {

        try {
            long endDate = dteEndDate.getTime();
            long startDate = dteStartDate.getTime();
            long cycle = msepCyclePeriod.getTime();
            long window = msepWindow.getTime();
            double phase = Double.parseDouble(jtfPhase.getText());

            ephemerisTimingConstraint.setEnd(endDate);
            ephemerisTimingConstraint.setStart(startDate);
            ephemerisTimingConstraint.setCyclePeriod(cycle);
            ephemerisTimingConstraint.setWindow(window);
            ephemerisTimingConstraint.setPhase(phase);

            return ephemerisTimingConstraint;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
            return null;
        }
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        
        dteEndDate.setEnabled(enabled);
        dteStartDate.setEnabled(enabled);
        msepCyclePeriod.setEnabled(enabled);
        msepWindow.setEnabled(enabled);
        jtfPhase.setEnabled(enabled);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dteStartDate = new ngat.beans.guibeans.DateTimeEditorPanel();
        dteEndDate = new ngat.beans.guibeans.DateTimeEditorPanel();
        msepCyclePeriod = new ngat.beans.guibeans.MillisecondEditorPanel();
        msepWindow = new ngat.beans.guibeans.MillisecondEditorPanel();
        jPanel2 = new javax.swing.JPanel();
        jtfPhase = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpHelpPane = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));

        dteStartDate.setBorder(javax.swing.BorderFactory.createTitledBorder("Start Date (YYYY/MM/DD HH:MM:SS)"));
        dteStartDate.setTitle("Start Date");

        dteEndDate.setBorder(javax.swing.BorderFactory.createTitledBorder("End Date (YYYY/MM/DD HH:MM:SS)"));
        dteEndDate.setTitle("End Date");

        msepCyclePeriod.setTitle("Cycle Period");

        msepWindow.setTitle("Window");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Phase"));

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jtfPhase, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(412, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jtfPhase, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        jtpHelpPane.setBorder(null);
        jtpHelpPane.setEditable(false);
        jtpHelpPane.setText("The Window defines the total time interval (split half before, and half after) that the group may start in.  \n\nFor example, a Start Date (i.e. a phase 0) with a time set to 22:00 with a Period of 2 hours, a Phase of 0.5 and a Window of 10 minutes would first be available to start observations between 22:55 and 23:05 and then subsequently between 00:55 and 01:05 etc.");
        jScrollPane1.setViewportView(jtpHelpPane);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 12));
        jLabel1.setText("Phased Timing Constraint");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(msepWindow, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .add(dteEndDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .add(msepCyclePeriod, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .add(dteStartDate, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(dteStartDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(dteEndDate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(msepCyclePeriod, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(msepWindow, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ngat.beans.guibeans.DateTimeEditorPanel dteEndDate;
    private ngat.beans.guibeans.DateTimeEditorPanel dteStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfPhase;
    private javax.swing.JTextPane jtpHelpPane;
    private ngat.beans.guibeans.MillisecondEditorPanel msepCyclePeriod;
    private ngat.beans.guibeans.MillisecondEditorPanel msepWindow;
    // End of variables declaration//GEN-END:variables


    public boolean isSelected() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean containsValidTimingConstraint() {
        try {
            long endDate = dteEndDate.getTime();
            long startDate = dteStartDate.getTime();
            long cycle = msepCyclePeriod.getTime();
            long window = msepWindow.getTime();
            double phase = Double.parseDouble(jtfPhase.getText());

            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
