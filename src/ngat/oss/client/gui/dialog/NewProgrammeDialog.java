package ngat.oss.client.gui.dialog;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ngat.oss.client.Phase2ModelClient;
import ngat.oss.client.gui.frame.MainFrame;
import ngat.oss.client.gui.util.LimitedCharactersDocument;
import ngat.oss.exception.Phase2Exception;
import ngat.phase2.XProgram;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 */
public class NewProgrammeDialog extends javax.swing.JDialog implements ActionListener {

    static Logger logger = Logger.getLogger(NewProgrammeDialog.class);

    public NewProgrammeDialog(boolean modal) {
        this.setModal(modal);
        initComponents();

        jtfName.setDocument(new LimitedCharactersDocument(LimitedCharactersDocument.STRICT_LIMITATION));

        centerFrame();
        addListeners();
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
                        NewProgrammeDialog.this.setLocation(x, y);
                    }
                });
    }

    private void addListeners() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                NewProgrammeDialog.this.setVisible(false);
                NewProgrammeDialog.this.dispose();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New Programme");

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

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 10));
        jLabel1.setText("PROGRAMME");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel3.setText("Description");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel2.setText("Name");

        jtfName.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfDescription.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jbtnCreate)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jbtnCancel))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jLabel1)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel3)
                                .add(jLabel2))
                            .add(29, 29, 29)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jtfName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                                .add(jtfDescription, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(26, 26, 26)
                        .add(jLabel2))
                    .add(jtfName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jtfDescription, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 373, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnCreate)
                    .add(jbtnCancel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed

    String name = jtfName.getText().trim();
    String description = jtfDescription.getText().trim();

    if (name.length() < 1) {
        JOptionPane.showMessageDialog(this, "Please enter a name.");
        return;
    }
    
    if (description.length() < 1) {
        JOptionPane.showMessageDialog(this, "Please enter a description.");
        return;
    }

    Phase2ModelClient phase2ModelClient = Phase2ModelClient.getInstance();

    try {
        if (phase2ModelClient.findProgram(name) != null) {
            JOptionPane.showMessageDialog(this, "Another programme exists with this name, please enter a different name.");
           return;
        }
    } catch (Phase2Exception ex) {
        ex.printStackTrace();
        logger.error(ex);
        JOptionPane.showMessageDialog(this, ex.getMessage());
        JOptionPane.showMessageDialog(this, "The programme was NOT added");
        return;
    }

    XProgram xProgram = new XProgram();
    xProgram.setName(name);
    xProgram.setDescription(description);
    
    try {
        long pid = phase2ModelClient.addProgramme(xProgram);
        xProgram.setID(pid);
    } catch (Phase2Exception ex) {
        ex.printStackTrace();
        logger.error(ex);
        JOptionPane.showMessageDialog(this, ex.getMessage());
        JOptionPane.showMessageDialog(this, "The programme was NOT added");
        return;
    }
    JOptionPane.showMessageDialog(this, "The programme has been successfully added");

    this.setVisible(false);
    this.dispose();

    MainFrame.getInstance().receiveNewTreeObject(xProgram);
}//GEN-LAST:event_jbtnCreateActionPerformed

private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    this.setVisible(false);
    this.dispose();

}//GEN-LAST:event_jbtnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JTextField jtfDescription;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
}