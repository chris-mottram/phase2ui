/*
 * DecSpinner.java
 *
 * Created on 14 December 2007, 11:11
 */
package ngat.beans.guibeans;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import ngat.astrometry.Position;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 */
public class DecEditorPanel extends javax.swing.JPanel {

    static Logger logger = Logger.getLogger(DecEditorPanel.class);

    private boolean enabled;

    /** Creates new form DecSpinner */
    public DecEditorPanel() {
        initComponents();
        jtfDec.setText("");
    }

    public double getDec() throws ParseException {

        String decStr = jtfDec.getText().trim();
        double dec = Position.parseDMS(decStr);
        return dec;
    }

    public void setDec(double dec) {
        String decString = Position.formatDMSString(dec, ":");
        jtfDec.setText(decString);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;

        jtfDec.setEnabled(enabled);
    }
    
    public static void main(String[] a) {
        final DecEditorPanel decSpinner = new DecEditorPanel();
        decSpinner.setDec(-0.138);
        final JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(decSpinner, BorderLayout.WEST);
        JButton jb = new JButton("getVal");

        jb.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            JOptionPane.showMessageDialog(frame, decSpinner.getDec());
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                            logger.error(ex);
                        }
                    }
                });

        frame.getContentPane().add(jb, BorderLayout.EAST);
        frame.show();
        frame.setSize(new Dimension(200, 200));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfDec = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DEC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N
        setPreferredSize(new java.awt.Dimension(155, 95));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel2.setText("+/-DD:MM:SS.ss");

        jtfDec.setColumns(1);
        jtfDec.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jtfDec.setText("+DD:MM:SS.ss");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .add(jLabel5))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jtfDec, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jtfDec, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(43, 43, 43)
                .add(jLabel5)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jtfDec;
    // End of variables declaration//GEN-END:variables
    
    
}
