/*
 * NewTimingConstraintDialog.java
 *
 * Created on April 30, 2009, 10:38 AM
 */
package ngat.oss.client.gui.dialog;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import ngat.oss.client.AccessModelClient;
import ngat.oss.client.gui.frame.MainFrame;
import ngat.oss.client.gui.util.LimitedCharactersDocument;
import ngat.oss.exception.Phase2Exception;
import ngat.phase2.XUser;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 */
public class NewUserDialog extends javax.swing.JDialog implements ActionListener {

    static Logger logger = Logger.getLogger(NewUserDialog.class);

    //private ITimingConstraint timingConstraint;
    /** Creates new form NewTimingConstraintDialog */
    public NewUserDialog(boolean modal) {
        this.setModal(modal);
        initComponents();
        centerFrame();
        addListeners();

        jtfUserName.setDocument(new LimitedCharactersDocument(LimitedCharactersDocument.STRICT_LIMITATION));
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
                        NewUserDialog.this.setLocation(x, y);
                    }
                });
    }

    private void addListeners() {
        this.addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                NewUserDialog.this.setVisible(false);
                NewUserDialog.this.dispose();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jpfPassword = new javax.swing.JPasswordField();
        jtfUserName = new javax.swing.JTextField();
        jtfCity = new javax.swing.JTextField();
        jtfAddress = new javax.swing.JTextField();
        jtfOrganisation = new javax.swing.JTextField();
        jtfDepartment = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfFirstName = new javax.swing.JTextField();
        jtfFax = new javax.swing.JTextField();
        jtfTelephone = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jtfPostcode = new javax.swing.JTextField();
        jtfCountry = new javax.swing.JTextField();
        jtfRegion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create New User");

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

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel5.setText("Last Name");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel4.setText("First Name");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel2.setText("User Name");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel3.setText("Password");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel15.setText("Fax");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel14.setText("Telephone");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel13.setText("Email");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel12.setText("Postcode");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel11.setText("Country");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel10.setText("Region");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel9.setText("City");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel8.setText("Address");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel7.setText("Organization");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jLabel6.setText("Department");

        jtfUserName.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfCity.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfAddress.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfOrganisation.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfDepartment.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfLastName.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfFirstName.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfFax.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfTelephone.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfEmail.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfPostcode.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfCountry.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jtfRegion.setFont(new java.awt.Font("Lucida Grande", 0, 10));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 10));
        jLabel1.setText("USER");

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
                        .add(jbtnCancel)
                        .addContainerGap(388, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel5)
                                    .add(jLabel4)
                                    .add(jLabel2)
                                    .add(jLabel3)
                                    .add(jLabel15)
                                    .add(jLabel14)
                                    .add(jLabel13)
                                    .add(jLabel12)
                                    .add(jLabel11)
                                    .add(jLabel10)
                                    .add(jLabel9)
                                    .add(jLabel8)
                                    .add(jLabel7)
                                    .add(jLabel6))
                                .add(12, 12, 12)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jpfPassword)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, jtfUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 182, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jtfCity, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .add(jtfAddress, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .add(jtfOrganisation, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .add(jtfDepartment, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .add(jtfLastName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .add(jtfFirstName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtfFax)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtfTelephone)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtfEmail)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtfPostcode)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtfCountry)
                                            .add(org.jdesktop.layout.GroupLayout.LEADING, jtfRegion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 178, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                            .add(jLabel1))
                        .add(279, 279, 279))))
        );

        layout.linkSize(new java.awt.Component[] {jpfPassword, jtfAddress, jtfCity, jtfCountry, jtfDepartment, jtfEmail, jtfFax, jtfFirstName, jtfLastName, jtfOrganisation, jtfPostcode, jtfRegion, jtfTelephone, jtfUserName}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jtfUserName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jpfPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jtfFirstName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(jtfLastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jtfDepartment, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jtfOrganisation, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(jtfAddress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(jtfCity, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jtfRegion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jtfCountry, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel12)
                    .add(jtfPostcode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(jtfEmail, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel14)
                    .add(jtfTelephone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel15)
                    .add(jtfFax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnCreate)
                    .add(jbtnCancel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCreateActionPerformed


    //validate the fields before allowing submission
    /*
    if (jpfPassword.getPassword().length < 8) {
        JOptionPane.showMessageDialog(this, "Please enter a password at least 8 characters long, ");
        return;
    }
    */
    String userName = jtfUserName.getText().trim();
    /*
    if (userName.length() < 8) {
        JOptionPane.showMessageDialog(this, "Please enter a username at least 8 characters long,");
        return;
    }
    */

    final AccessModelClient accessModelClient = AccessModelClient.getInstance();
    boolean userExists;
    try {
        userExists = accessModelClient.userExists(userName);
        if (userExists) {
            JOptionPane.showMessageDialog(this, "A user with that name already exists, please try a different username.");
            return;
        }
    } catch (Phase2Exception ex) {
        ex.printStackTrace();
        logger.error(ex);
        JOptionPane.showMessageDialog(this, ex.getMessage());
        JOptionPane.showMessageDialog(this, "The user was NOT added");
        return;
    }
    
    String formPassword = new String(jpfPassword.getPassword());
    formPassword.trim();
    String address = jtfAddress.getText().trim();
    String city = jtfCity.getText().trim();
    String country = jtfCountry.getText().trim();
    String department = jtfDepartment.getText().trim();
    String email = jtfEmail.getText().trim();
    String fax = jtfFax.getText().trim();
    String firstName = jtfFirstName.getText().trim();
    String lastName = jtfLastName.getText().trim();
    String org = jtfOrganisation.getText().trim();
    String postcode = jtfPostcode.getText().trim();
    String region = jtfRegion.getText().trim();
    String phone = jtfTelephone.getText().trim();

    XUser xUser = new XUser();

    JPasswordField jPasswordField = new JPasswordField();
    Object[] message = {"Please re-enter the new password.", jPasswordField};
    int response = JOptionPane.showConfirmDialog(null, message, "Confirm Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    String passwordSupplied = "";
    if (response == JOptionPane.OK_OPTION) {
        passwordSupplied = new String(jPasswordField.getPassword());
    } else {
        return;
    }
    if (!passwordSupplied.equals(formPassword)) {
        JOptionPane.showMessageDialog(this, "Passwords do not match, update failed.");
        return;
    }

    xUser.setName(userName);
    xUser.setPassword(formPassword);
    xUser.setAddress(address);
    xUser.setCity(city);
    xUser.setCountry(country);
    xUser.setDepartment(department);
    xUser.setEmail(email);
    xUser.setFax(fax);
    xUser.setFirstName(firstName);
    xUser.setLastName(lastName);
    xUser.setOrganization(org);
    xUser.setPostalCode(postcode);
    xUser.setRegion(region);
    xUser.setTelephone(phone);

    final XUser user = xUser;

    new Thread(new Runnable() {
        public void run() {
            try {
                long uid = accessModelClient.addUser(user);
                user.setID(uid);
                
                JOptionPane.showMessageDialog(NewUserDialog.this, "The user data has been successfully added");
                MainFrame.getInstance().receiveNewTreeObject(user);
                
            } catch (final Phase2Exception ex) {
                ex.printStackTrace();
                logger.error(ex);

                JOptionPane.showMessageDialog(NewUserDialog.this, ex.getMessage());
                JOptionPane.showMessageDialog(NewUserDialog.this, "The user was NOT added");
                  
                return;
            }
        }
    }).start();

    this.setVisible(false);
    this.dispose();

}//GEN-LAST:event_jbtnCreateActionPerformed

private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    this.setVisible(false);
    this.dispose();
}//GEN-LAST:event_jbtnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnCreate;
    private javax.swing.JPasswordField jpfPassword;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JTextField jtfCountry;
    private javax.swing.JTextField jtfDepartment;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfFax;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfOrganisation;
    private javax.swing.JTextField jtfPostcode;
    private javax.swing.JTextField jtfRegion;
    private javax.swing.JTextField jtfTelephone;
    private javax.swing.JTextField jtfUserName;
    // End of variables declaration//GEN-END:variables
}
