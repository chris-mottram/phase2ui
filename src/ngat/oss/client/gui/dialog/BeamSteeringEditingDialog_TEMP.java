
package ngat.oss.client.gui.dialog;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import ngat.oss.client.gui.reference.CONST;
import ngat.oss.client.gui.reference.DefaultObjectFactory;
import ngat.phase2.IBeamSteeringConfig;
import ngat.phase2.IOpticalSlideConfig;
import ngat.phase2.XBeamSteeringConfig;
import ngat.phase2.XOpticalSlideConfig;

/**
 *
 * @author  nrc
 */
public class BeamSteeringEditingDialog_TEMP extends javax.swing.JDialog {

    IBeamSteeringConfig beamSteeringConfig;

    private ButtonGroup agButtonGroup, bottomOpticalSlideButtonGroup, topOpticalSlideButtonGroup;

    public BeamSteeringEditingDialog_TEMP(boolean modal) {
        this(modal, null);
    }

    public BeamSteeringEditingDialog_TEMP(boolean modal, IBeamSteeringConfig beamSteeringConfig) {
        this.setModal(modal);
        
        initComponents();
        initControls();

        if (beamSteeringConfig == null) {
            beamSteeringConfig = DefaultObjectFactory.getDefaultBeamSteeringConfig();
        }
        setBeamSteeringConfig(beamSteeringConfig, true);

        centerFrame();
        addListeners();
    }

    private void initControls() {

        topOpticalSlideButtonGroup = new ButtonGroup();

        jrbTOPDichroic_DICHROIC.setActionCommand(CONST.DICHROIC);
        jrbTOPDichroic_MIRROR.setActionCommand(CONST.MIRROR);
        jrbTOPDichroic_CLEAR.setActionCommand(CONST.IO_CLEAR);

        topOpticalSlideButtonGroup.add(jrbTOPDichroic_DICHROIC);
        topOpticalSlideButtonGroup.add(jrbTOPDichroic_MIRROR);
        topOpticalSlideButtonGroup.add(jrbTOPDichroic_CLEAR);

        //oDichroicButtonGroup
        bottomOpticalSlideButtonGroup = new ButtonGroup();

        jrbBOTTOMDichroic_CLEAR.setActionCommand(CONST.IO_CLEAR);
        jrbBOTTOMDichroic_MIRROR.setActionCommand(CONST.MIRROR);
        jrbBOTTOMDichroic_REDBLUE.setActionCommand(CONST.RED_BLUE_DICHROIC);

        bottomOpticalSlideButtonGroup.add(jrbBOTTOMDichroic_CLEAR);
        bottomOpticalSlideButtonGroup.add(jrbBOTTOMDichroic_MIRROR);
        bottomOpticalSlideButtonGroup.add(jrbBOTTOMDichroic_REDBLUE);

        //deactivate top slide
        jrbTOPDichroic_DICHROIC.setEnabled(false);
        jrbTOPDichroic_MIRROR.setEnabled(false);
        jrbTOPDichroic_CLEAR.setEnabled(false);
    }

    public void setBeamSteeringConfig(IBeamSteeringConfig beamSteeringConfig, boolean setControls) {
        this.beamSteeringConfig = beamSteeringConfig;
        
        if (setControls) {
            setControls(beamSteeringConfig);
        }
        beamSteeringStatusPanel.setBeamStearingGUIState(beamSteeringConfig);
    }

    public void setControls(IBeamSteeringConfig beamSteeringConfig) {
/*
        if (beamSteeringConfig.getUpperSlideConfig().getPosition() == IOpticalSlideConfig.POSITION_CLEAR) {
            jrbTOPDichroic_CLEAR.setSelected(true);
        } else if (beamSteeringConfig.getUpperSlideConfig().getPosition() == IOpticalSlideConfig.POSITION_AL_MIRROR) {
            jrbTOPDichroic_MIRROR.setSelected(true);
        } else if (beamSteeringConfig.getUpperSlideConfig().getPosition() == IOpticalSlideConfig.POSITION_DI_RB) {
            jrbTOPDichroic_DICHROIC.setSelected(true);
        }

        if (beamSteeringConfig.getLowerSlideConfig().getPosition() == IOpticalSlideConfig.POSITION_CLEAR) {
            jrbBOTTOMDichroic_CLEAR.setSelected(true);
        } else if (beamSteeringConfig.getLowerSlideConfig().getPosition() == IOpticalSlideConfig.POSITION_DI_RB) {
            jrbBOTTOMDichroic_REDBLUE.setSelected(true);
        } else if (beamSteeringConfig.getLowerSlideConfig().getPosition() == IOpticalSlideConfig.POSITION_AL_MIRROR) {
            jrbBOTTOMDichroic_MIRROR.setSelected(true);
        }
 * */
    }

    public IBeamSteeringConfig getBeamStearingConfigFromControls() {

        XBeamSteeringConfig beamSteeringConfig = new XBeamSteeringConfig();
        /*
        
        int upperPosition, lowerPosition;

        if(topOpticalSlideButtonGroup.getSelection().getActionCommand().equals(CONST.DICHROIC)) {
            upperPosition = IOpticalSlideConfig.POSITION_DI_RB;
        } else if(topOpticalSlideButtonGroup.getSelection().getActionCommand().equals(CONST.MIRROR)) {
            upperPosition = IOpticalSlideConfig.POSITION_AL_MIRROR;
        } else if(topOpticalSlideButtonGroup.getSelection().getActionCommand().equals(CONST.CLEAR)) {
            upperPosition = IOpticalSlideConfig.POSITION_CLEAR;
        } else {
            upperPosition = -1;
        }
        XOpticalSlideConfig upperOpticalSlideConfig = new XOpticalSlideConfig(IOpticalSlideConfig.SLIDE_UPPER, upperPosition);

        if(bottomOpticalSlideButtonGroup.getSelection().getActionCommand().equals(CONST.CLEAR)) {
            lowerPosition = IOpticalSlideConfig.POSITION_CLEAR;
        } else if(bottomOpticalSlideButtonGroup.getSelection().getActionCommand().equals(CONST.MIRROR)) {
            lowerPosition = IOpticalSlideConfig.POSITION_AL_MIRROR;
        } else if(bottomOpticalSlideButtonGroup.getSelection().getActionCommand().equals(CONST.RED_BLUE_DICHROIC)) {
            lowerPosition = IOpticalSlideConfig.POSITION_DI_RB;
        } else {
            lowerPosition = -1;
        }

        XOpticalSlideConfig lowerOpticalSlideConfig = new XOpticalSlideConfig(IOpticalSlideConfig.SLIDE_LOWER, lowerPosition);

        beamSteeringConfig.setUpperSlideConfig(upperOpticalSlideConfig);
        beamSteeringConfig.setLowerSlideConfig(lowerOpticalSlideConfig);
        */
        return beamSteeringConfig;
         
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
                        BeamSteeringEditingDialog_TEMP.this.setLocation(x, y);
                    }
                });
    }

    private void addListeners() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                BeamSteeringEditingDialog_TEMP.this.setVisible(false);
                BeamSteeringEditingDialog_TEMP.this.dispose();
            }
        });
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
        jPanel4 = new javax.swing.JPanel();
        jrbTOPDichroic_CLEAR = new javax.swing.JRadioButton();
        jrbTOPDichroic_MIRROR = new javax.swing.JRadioButton();
        jrbTOPDichroic_DICHROIC = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jrbBOTTOMDichroic_CLEAR = new javax.swing.JRadioButton();
        jrbBOTTOMDichroic_MIRROR = new javax.swing.JRadioButton();
        jrbBOTTOMDichroic_REDBLUE = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpHelpPane = new javax.swing.JTextPane();
        beamSteeringStatusPanel = new ngat.beans.guibeans.BeamSteeringStatusPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Beam Steering Configuration");

        jbtnCreate.setForeground(new java.awt.Color(255, 0, 0));
        jbtnCreate.setText("Submit");
        jbtnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCreateActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Upper Slide"));
        jPanel4.setEnabled(false);

        jrbTOPDichroic_CLEAR.setText("CLEAR");
        jrbTOPDichroic_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTOPDichroic_CLEARActionPerformed(evt);
            }
        });

        jrbTOPDichroic_MIRROR.setText("MIRROR");
        jrbTOPDichroic_MIRROR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTOPDichroic_MIRRORActionPerformed(evt);
            }
        });

        jrbTOPDichroic_DICHROIC.setText("RED-BLUE DICHROIC");
        jrbTOPDichroic_DICHROIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTOPDichroic_DICHROICActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jrbTOPDichroic_DICHROIC)
                    .add(jrbTOPDichroic_MIRROR)
                    .add(jrbTOPDichroic_CLEAR))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jrbTOPDichroic_CLEAR)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jrbTOPDichroic_MIRROR)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jrbTOPDichroic_DICHROIC))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Lower Slide"));

        jrbBOTTOMDichroic_CLEAR.setText("CLEAR");
        jrbBOTTOMDichroic_CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBOTTOMDichroic_CLEARActionPerformed(evt);
            }
        });

        jrbBOTTOMDichroic_MIRROR.setText("MIRROR");
        jrbBOTTOMDichroic_MIRROR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBOTTOMDichroic_MIRRORActionPerformed(evt);
            }
        });

        jrbBOTTOMDichroic_REDBLUE.setText("RED-BLUE DICHROIC");
        jrbBOTTOMDichroic_REDBLUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBOTTOMDichroic_REDBLUEActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .add(jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jrbBOTTOMDichroic_CLEAR)
                    .add(jrbBOTTOMDichroic_MIRROR)
                    .add(jrbBOTTOMDichroic_REDBLUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jrbBOTTOMDichroic_REDBLUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jrbBOTTOMDichroic_MIRROR)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jrbBOTTOMDichroic_CLEAR)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jtpHelpPane.setEditable(false);
        jtpHelpPane.setText("In the above dichroic names, the first wavelength is reflected, the second is transmitted.");
        jScrollPane1.setViewportView(jtpHelpPane);

        org.jdesktop.layout.GroupLayout beamSteeringStatusPanelLayout = new org.jdesktop.layout.GroupLayout(beamSteeringStatusPanel);
        beamSteeringStatusPanel.setLayout(beamSteeringStatusPanelLayout);
        beamSteeringStatusPanelLayout.setHorizontalGroup(
            beamSteeringStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 577, Short.MAX_VALUE)
        );
        beamSteeringStatusPanelLayout.setVerticalGroup(
            beamSteeringStatusPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 451, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(beamSteeringStatusPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane1, 0, 0, Short.MAX_VALUE)))
                    .add(jbtnCreate))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {jPanel4, jPanel7}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(beamSteeringStatusPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jbtnCreate))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(new java.awt.Component[] {jPanel4, jPanel7}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed

    //beamSteeringConfig has been set, it will be grabbed by the client window

    //get beamSteeringConfig from control, set the variable beamSteeringConfig with it, then ...

    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_jbtnCreateActionPerformed

private void jrbTOPDichroic_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTOPDichroic_CLEARActionPerformed
    setBeamSteeringConfig(getBeamStearingConfigFromControls(), false);
}//GEN-LAST:event_jrbTOPDichroic_CLEARActionPerformed

private void jrbTOPDichroic_MIRRORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTOPDichroic_MIRRORActionPerformed
    setBeamSteeringConfig(getBeamStearingConfigFromControls(), false);
}//GEN-LAST:event_jrbTOPDichroic_MIRRORActionPerformed

private void jrbTOPDichroic_DICHROICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTOPDichroic_DICHROICActionPerformed
    setBeamSteeringConfig(getBeamStearingConfigFromControls(), false);
}//GEN-LAST:event_jrbTOPDichroic_DICHROICActionPerformed

private void jrbBOTTOMDichroic_CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBOTTOMDichroic_CLEARActionPerformed
    setBeamSteeringConfig(getBeamStearingConfigFromControls(), false);
}//GEN-LAST:event_jrbBOTTOMDichroic_CLEARActionPerformed

private void jrbBOTTOMDichroic_MIRRORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBOTTOMDichroic_MIRRORActionPerformed
    setBeamSteeringConfig(getBeamStearingConfigFromControls(), false);
}//GEN-LAST:event_jrbBOTTOMDichroic_MIRRORActionPerformed

private void jrbBOTTOMDichroic_REDBLUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBOTTOMDichroic_REDBLUEActionPerformed
    setBeamSteeringConfig(getBeamStearingConfigFromControls(), false);
}//GEN-LAST:event_jrbBOTTOMDichroic_REDBLUEActionPerformed

public IBeamSteeringConfig getBeamSteeringConfig() {
    return beamSteeringConfig;
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ngat.beans.guibeans.BeamSteeringStatusPanel beamSteeringStatusPanel;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JRadioButton jrbBOTTOMDichroic_CLEAR;
    private javax.swing.JRadioButton jrbBOTTOMDichroic_MIRROR;
    private javax.swing.JRadioButton jrbBOTTOMDichroic_REDBLUE;
    private javax.swing.JRadioButton jrbTOPDichroic_CLEAR;
    private javax.swing.JRadioButton jrbTOPDichroic_DICHROIC;
    private javax.swing.JRadioButton jrbTOPDichroic_MIRROR;
    private javax.swing.JTextPane jtpHelpPane;
    // End of variables declaration//GEN-END:variables
}
