/*
 * LoginFrame.java
 *
 * Created on 19 November 2007, 12:26
 */
package ngat.oss.client.gui.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import ngat.oss.client.AccessModelClient;
import ngat.oss.client.AccountModelClient;
import ngat.oss.client.HistoryModelClient;
import ngat.oss.client.Phase2ModelClient;
import ngat.oss.client.gui.reference.CONST;
import ngat.oss.exception.Phase2Exception;
import ngat.oss.reference.Const;
import ngat.phase2.IUser;
import ngat.oss.client.gui.reference.Session;
import ngat.oss.client.gui.reference.TelescopeConfiguration;
import ngat.oss.client.gui.util.FrameCenterer;
import ngat.oss.client.gui.util.SystemDescriber;
import ngat.oss.client.reports.FilterReportRunner;
import ngat.phase2.XLoginRecord;
import ngat.phase2.XSemesterPeriod;
import ngat.phase2.XVersion;
import ngat.phase2.util.TextUtil;
import org.apache.log4j.Logger;

/**
 *
 * @author  nrc
 */
public class LoginFrame extends javax.swing.JFrame {

    static Logger logger = Logger.getLogger(LoginFrame.class);
    
    public static final int ERROR_MSG = 0;
    public static final int INFO_MSG = 1;
    public static final int SUCCESS_MSG = 2;
    
    private static LoginFrame instance;

    /** Creates new form LoginFrame */
    private LoginFrame() {
        initComponents();
        addListeners();
        setFocus();
        new FrameCenterer(this).start();
        // new
        String host;
        try {
            Session.getInstance().setServiceURL(new URL(AccessModelClient.getInstance().getURLOfService()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // /new
        this.setTitle(CONST.APP_NAME + " (" + CONST.CURRENT_VERSION_NUMBER.getDisplayName() + CONST.CURRENT_REVISION_LETTER + ")");
    }

    public static LoginFrame getInstance() {
        if (instance == null) {
            instance = new LoginFrame();
        }
        return instance;
    }

    public static void resetInstance() {
        instance = new LoginFrame();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtUsername = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jbtnLogin = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpMessages = new javax.swing.JTextPane();
        jpbLoadProgress = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liverpool Telescope Phase2");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                WindowClosing(evt);
            }
        });

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jbtnLogin.setText("Login");
        jbtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLoginActionPerformed(evt);
            }
        });

        jbtnCancel.setText("Cancel");
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jtpMessages.setEditable(false);
        jtpMessages.setText("Ready...");
        jScrollPane1.setViewportView(jtpMessages);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jpbLoadProgress, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(2, 2, 2)
                                .add(jLabel3))
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jPassword, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                            .add(jtUsername, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(jbtnLogin)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 200, Short.MAX_VALUE)
                        .add(jbtnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jtUsername, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(jPassword, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnLogin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jbtnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jpbLoadProgress, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
// TODO add your handling code here:
        System.exit(-1);
    }//GEN-LAST:event_jbtnCancelActionPerformed

    private void WindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_WindowClosing
        // TODO add your handling code here:
        System.exit(-1);
    }//GEN-LAST:event_WindowClosing

    private void addListeners() {
        KeyListener returnListener = new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    jbtnLogin.doClick();
                }
            }
        };
        jtUsername.addKeyListener(returnListener);
        jPassword.addKeyListener(returnListener);
        Style errorStyle;

        //jtpMessages.addStyle("error", errorStyle);

        StyledDocument doc = jtpMessages.getStyledDocument();

        // Makes text red
        Style style = jtpMessages.addStyle("Red", null);
        StyleConstants.setForeground(style, Color.red);

        style = jtpMessages.addStyle("Green", null);
        StyleConstants.setForeground(style, Color.GREEN);

        style = jtpMessages.addStyle("Blue", null);
        StyleConstants.setForeground(style, Color.BLUE);
    }

    private void setFocus() {
        jtUsername.requestFocus();
    }

    private void pingModels() {

        AccessModelClient accessModelClient = AccessModelClient.getInstance();
        AccountModelClient accountModelClient = new AccountModelClient(Const.PROPOSAL_ACCOUNT_SERVICE);
        HistoryModelClient historyModelClient = HistoryModelClient.getInstance();
        //LockingModelClient lockingModelClient = LockingModelClient.getInstance();
        Phase2ModelClient phase2ModelClient = Phase2ModelClient.getInstance();

        try {
            displayMessage("Pinging: " + accessModelClient.getURLOfService(), INFO_MSG);
            accessModelClient.ping();
            displayMessage("... success", INFO_MSG);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
            displayMessage("... the ping failed with message: " + ex, ERROR_MSG);
            return;
        }

        try {
            displayMessage("Pinging: " + accountModelClient.getURLOfService(), INFO_MSG);
            accountModelClient.ping();
            displayMessage("... success", INFO_MSG);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
            displayMessage("... the ping failed with message: " + ex, ERROR_MSG);
            return;
        }

        try {
            displayMessage("Pinging: " + historyModelClient.getURLOfService(), INFO_MSG);
            historyModelClient.ping();
            displayMessage("... success", INFO_MSG);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
            displayMessage("... the ping failed with message: " + ex, ERROR_MSG);
            return;
        }

        try {
            displayMessage("Pinging: " + phase2ModelClient.getURLOfService(), INFO_MSG);
            phase2ModelClient.ping();
            displayMessage("... success", INFO_MSG);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex);
            displayMessage("... the ping failed with message: " + ex, ERROR_MSG);
            return;
        }
        displayMessage("All pings successful", INFO_MSG);

    }

    private void jbtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLoginActionPerformed

        int modifier = evt.getModifiers();

        if ((modifier & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
            pingModels();
            return;
        }

        // TODO add your handling code here:
        final String username = jtUsername.getText();
        final char[] password = jPassword.getPassword();

        jbtnLogin.setEnabled(false);
        jbtnCancel.setEnabled(false);

        new Thread(new Runnable() {

            public void run() {
                String passwordString = TextUtil.convertToString(password);
                displayMessage("Attempting login with username: " + username, INFO_MSG);
                AccessModelClient accessModelClient = AccessModelClient.getInstance();

                try {
                    if (accessModelClient == null) {
                        throw new Phase2Exception("AccessModelClient is null");
                    }

                    final IUser user = accessModelClient.authenticate(username, passwordString, "RPC_V2");
                    logger.info("user=" + user);

                    if (user.getID() == Const.ERROR_ID) {
                        displayMessage("Login attempt failed, the credentials supplied were not authenticated", ERROR_MSG);
                        displayMessage("Please try again", ERROR_MSG);
                        jbtnLogin.setEnabled(true);
                        jbtnCancel.setEnabled(true);
                    } else {
                        displayMessage("Login successful", SUCCESS_MSG);
                        
                        doLoginRecordSend(user, accessModelClient);
                        
                        //check version is usable
                        XVersion minimumClientVersion =  (XVersion) accessModelClient.getMinimumClientVersionNumber();
                        displayMessage("Minimum client version is currently: " + minimumClientVersion.getDisplayName(), INFO_MSG);

                        if (!clientIsUsable(minimumClientVersion)) {
                            displayMessage("Unusable client", INFO_MSG);
                            JOptionPane.showMessageDialog(LoginFrame.this, "Please uninstall this version of the Phase2 UI and replace it with version " + minimumClientVersion.getDisplayName() + " which is available for download.");
                            System.exit(0);
                        }
                        
                        displayMessage("Please wait while your Phase2 data is loaded", INFO_MSG);

                        
                        //show MainFrame and hand it user
                        java.awt.EventQueue.invokeLater(new Runnable() {

                            public void run() {
                                //download telescope configurations from the web-server
                                TelescopeConfiguration.getInstance(); //just run the getInstance
                                
                                jpbLoadProgress.setIndeterminate(true);
                                //store the authenticated user in the session storage
                                Session.getInstance().setUser(user);
                                //thread off from the EventQueue, else we get a locked jpbLoadProgress bar
                                new Thread(new Runnable() {

                                    public void run() {
                                        MainFrame mainFrame = MainFrame.getInstance();
                                        mainFrame.setVisible(true);
                                        mainFrame.showMessages();
                                    }
                                }).start();
                            }
                        });
                    }
                } catch (Phase2Exception ex) {
                    ex.printStackTrace();
                    logger.error(ex);
                    //something went wrong, probably 'invocation response was null'
                    //in which case, the authentication failed
                    displayMessage("Login attempt failed, the service may be down or a connection not available", ERROR_MSG);
                    jbtnLogin.setEnabled(true);
                    jbtnCancel.setEnabled(true);
                }
            }
        }).start();
    }//GEN-LAST:event_jbtnLoginActionPerformed

    private boolean clientIsUsable(XVersion minimumClientVersion) {
        
        XVersion currentVersion = CONST.CURRENT_VERSION_NUMBER;
        
        return currentVersion.compareTo( minimumClientVersion) >= 0;
    }
    
    private void doLoginRecordSend(IUser user, AccessModelClient accessModelClient) throws Phase2Exception {
        
        XLoginRecord loginRecord = SystemDescriber.getInstance().buildLoginRecord();
        
        String usageDataDescription = "";
        usageDataDescription += "java version=" + loginRecord.getJavaVersion() + ",";
        usageDataDescription += "OS architecture=" + loginRecord.getOsArch() + ",";
        usageDataDescription += "OS name=" + loginRecord.getOsName() + ",";
        usageDataDescription += "OS version=" + loginRecord.getOsVersion() + ",";
        usageDataDescription += "screen size=" + loginRecord.getScreenSize();
        
        loginRecord.setUserId(user.getID());
        accessModelClient.receiveLoginRecord(loginRecord);
    }

private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_jPasswordActionPerformed

    /** Displays a message in the jtaMessageArea
     *  and scrolls the area so the the message is at the bottom.
     */
    public void displayMessage(String message, int messageCode) {
        logger.info("displayMessage(" + message + ")");

        final String msg = message;
        final Style msgStyle;
        switch (messageCode) {
            case LoginFrame.ERROR_MSG:
                msgStyle = jtpMessages.getStyle("Red");
                break;
            case LoginFrame.INFO_MSG:
                msgStyle = jtpMessages.getStyle("Blue");
                break;
            case LoginFrame.SUCCESS_MSG:
                msgStyle = jtpMessages.getStyle("Green");
                break;
            default:
                msgStyle = jtpMessages.getStyle("default");
                break;
        }

        EventQueue.invokeLater(
                new Runnable() {

                    public void run() {
                        Document doc = jtpMessages.getDocument();
                        try {
                            doc.insertString(doc.getLength(), "\n", msgStyle);
                            doc.insertString(doc.getLength(), msg, msgStyle);
                            jtpMessages.setCaretPosition(jtpMessages.getDocument().getLength());
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error(e);
                        }
                    }
                });
    }

    //place to put extraction of telescope status from exposed web-service endpoints / online .xml documents


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //for apple users:
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginFrame.getInstance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnLogin;
    private javax.swing.JProgressBar jpbLoadProgress;
    private javax.swing.JTextField jtUsername;
    private javax.swing.JTextPane jtpMessages;
    // End of variables declaration//GEN-END:variables
}
