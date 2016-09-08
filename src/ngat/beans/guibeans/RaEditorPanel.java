/*
 * RaEditorPanel.java
 *
 * Created on 14 January 2008, 10:18
 */
package ngat.beans.guibeans;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ngat.astrometry.Position;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 * testing svn
 */
public class RaEditorPanel extends javax.swing.JPanel {

    static Logger logger = Logger.getLogger(RaEditorPanel.class);

    private boolean enabled;

    /** Creates new form RaEditorPanel */
    public RaEditorPanel() {
        initComponents();
        jtfRa.setText("");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtfRa = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 10))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel2.setText(" HH MM SS.sss");

        jtfRa.setColumns(2);
        jtfRa.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jtfRa.setText("HH:MM:SS.ss");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel2)
                    .add(jtfRa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jtfRa, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    public double getRa() throws ParseException {
        
        String raStr = jtfRa.getText().trim();
        return ngat.astrometry.Position.parseGenericHMS(raStr);
    }
    
    public void setRa(double ra) {  
        jtfRa.setText(Position.formatHMSString(ra, ":"));
    }
    
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        jtfRa.setEnabled(enabled);
    }
    
    public static void main(String[] a) {
        final RaEditorPanel raSpinner = new RaEditorPanel();
        raSpinner.setRa(0.138);
        final JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.getContentPane().add(raSpinner, BorderLayout.WEST);
        JButton jb = new JButton("getVal");
        
        jb.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            JOptionPane.showMessageDialog(frame, raSpinner.getRa());
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
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jtfRa;
    // End of variables declaration//GEN-END:variables
    
}