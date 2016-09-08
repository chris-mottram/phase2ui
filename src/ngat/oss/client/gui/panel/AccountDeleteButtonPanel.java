/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * IncDecPanel.java
 *
 * Created on Nov 30, 2010, 3:40:04 PM
 */

package ngat.oss.client.gui.panel;

import javax.swing.JOptionPane;
import ngat.oss.client.AccountModelClient;
import ngat.oss.client.gui.dialog.AccountsDialog;
import ngat.oss.client.gui.reference.Session;
import ngat.oss.client.gui.wrapper.SemesterAccountWrapper;
import org.apache.log4j.Logger;

/**
 *
 * @author nrc
 */
public class AccountDeleteButtonPanel extends javax.swing.JPanel {

    static Logger logger = Logger.getLogger(AccountDeleteButtonPanel.class);

    private AccountModelClient accountModelClient;
    private SemesterAccountWrapper semesterAccountWrapper;

    private AccountsDialog accountsDialog;

    /** Creates new form IncDecPanel */
    public AccountDeleteButtonPanel(AccountModelClient accountModelClient, Object value, AccountsDialog accountsDialog) {
        this.accountModelClient = accountModelClient;
        this.semesterAccountWrapper = (SemesterAccountWrapper)value;
        this.accountsDialog = accountsDialog;
        
        initComponents();
        populateComponents();
    }

    private void populateComponents() {
        jbtnDelete.setEnabled(Session.getInstance().getUser().isSuperUser());

        //this is a bit of code yjay
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnDelete = new javax.swing.JButton();

        jbtnDelete.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jbtnDelete)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jbtnDelete)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        int n = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete the account called " + semesterAccountWrapper.getAccount().getName() + " on semester " + semesterAccountWrapper.getSemester().getName() + "? (the account has ID=" + semesterAccountWrapper.getAccount().getID()+")",
            "Delete account?",
            JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            try {
                long accountId = semesterAccountWrapper.getAccount().getID();
                //System.err.println("accountModelClient.deleteAccount(" + accountId + ");");
                accountModelClient.deleteAccount(accountId);
                updateView();
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error(ex);
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else if (n == 1) {
            //no
            return;
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void updateView() {
        accountsDialog.reloadTable();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnDelete;
    // End of variables declaration//GEN-END:variables
   
}
