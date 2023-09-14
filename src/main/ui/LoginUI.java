package ui;

import model.Member;
import model.MemberManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

public class LoginUI extends SystemUI implements ActionListener, KeyListener {

    private static JButton buttonLogin;
    //private static TextArea notification = new TextArea();
    private static JLabel l1;
    private static JLabel l2;
    protected static TextField tf1 = new TextField(); ///accountName
    private static JPasswordField pf2 = new JPasswordField();
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;
    private static final Font labelFont = new Font("Georgia", Font.BOLD, 14);


    public LoginUI() {
        super("Member Login Page");
        jf.setPreferredSize(new Dimension(450, 400));
        //((JPanel) jf.getContentPane()).setBorder(new EmptyBorder(13, 20, 13, 20));
        jf.setLayout(new GridLayout(0,1,1,0));
        //JPanel jp = new JPanel();
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/LoginUIbg.jpg").getImage());

        jp.setBackground(Color.WHITE);
        jf.pack();
        jf.add(jp);
        jf.setBounds(400, 500, 400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        addComponentsToPaneForMemberLogin(jp);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        jf.addKeyListener(this);


//        notification.setColumns(8);
//        notification.setRows(3);
//        notification.setForeground(Color.BLUE);
//        Font font = new Font("Segoe Script", Font.PLAIN, 12);
//        notification.setFont(font);

    }

//    private void loginHandling() throws IOException {
//        Member m = new Member(tf1.getText(),Integer.parseInt(tf2.getText()));
//        if (MainMenuLayout.getLibrary().getMemberManager().checkMembership(m)) {
//            JOptionPane.showMessageDialog(this,"Login successfully!");
//            //notification.setText("Login successfully!");
//            new BorrowUI();
//        } else {
//            notification.setText("Your membership info is not found. You are not a member yet");
//            // jump to sign up page
//        }
//    }


    private void addComponentsToPaneForMemberLogin(Container cp) {
        GridBagConstraints c = gridLayoutConstruction(cp);
        label1ForLogin(cp,c);
        label2ForLogin(cp,c);
        buttonForLogin(cp,c);
        memberNameInput(cp,c);
        last4IDInput(cp,c);
    }

//    private GridBagConstraints gridLayoutConstruction(Container contentPane) {
//        if (RIGHT_TO_LEFT) {
//            contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//        }
//        contentPane.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        if (shouldFill) {
//            c.fill = GridBagConstraints.HORIZONTAL;
//        }
//        return c;
//    }




    private static void label1ForLogin(Container pane, GridBagConstraints c) {
        l1 = new JLabel("AccountName",JLabel.CENTER);
        l1.setFont(labelFont);
        //l1.setText("AccountName");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(l1,c);
    }

    private static void label2ForLogin(Container pane, GridBagConstraints c) {
        l2 = new JLabel("Last4DigitOfID",JLabel.CENTER);
        l2.setFont(labelFont);
        //l2.setText("Last4DigitOfID");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(l2,c);
    }

    private void memberNameInput(Container pane, GridBagConstraints c) {
        tf1 = new TextField("",JLabel.CENTER);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 0;
        tf1.addKeyListener(this);
        pane.add(tf1,c);
    }

    private void last4IDInput(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 1;
        pf2.addKeyListener(this);
        pane.add(pf2,c);
    }

    private void buttonForLogin(Container pane, GridBagConstraints c) {
        buttonLogin = new JButton("Login");
        buttonLogin.setActionCommand("login");
        buttonLogin.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(buttonLogin,c);

    }

    // EFFECTS: if input is empty or invalid, do nothing; otherwise react to the button clicked
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MemberManager mm = MainMenuUI.getLibrary().getMemberManager();
        if (checkEmptyInput()) {
            return;
        }
        if (checkInvalidInput()) {
            return;
        }
        loginHandling(actionEvent, mm);

    }

    private boolean checkInvalidInput() {
        //String accountName = tf1.getText();
        String password = String.valueOf(pf2.getPassword());
        try {
            int id = Integer.parseInt(password);
            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jf, "Only numbers in your Last4DigitOFID!","error",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
    }

    private void loginHandling(ActionEvent actionEvent, MemberManager mm) {
        try {
            mm.load("./data/memberListFile.txt");
            Icon icon = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/login%20icon.jpg"));

            if (actionEvent.getActionCommand().equals("login")) {
                Member m = new Member(tf1.getText(),Integer.parseInt(String.valueOf(pf2.getPassword())));
                membershipChecking(mm, icon, m);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void membershipChecking(MemberManager mm, Icon icon, Member m) {
        if (mm.checkMembership(m)) {
            JOptionPane.showMessageDialog(jf, "Login successfully!",null,
                    JOptionPane.PLAIN_MESSAGE,icon);
            //tf1.setText("");
            BorrowUI.currentAccount = tf1.getText();
            pf2.setText("");
            jf.dispose();
            new BorrowUI();
        } else {
            message();
            new SignUpUI();

        }
    }

    private boolean checkEmptyInput() {
        String accountName = tf1.getText();
        String password = String.valueOf(pf2.getPassword());
        if (accountName.equals("")) {
            JOptionPane.showMessageDialog(jf, "AccountName should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        if (password.equals("")) {
            JOptionPane.showMessageDialog(jf, "Password should not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    private void message() {
        JOptionPane.showMessageDialog(jf,
                "Invalid AccountName or Password","!!!",JOptionPane.WARNING_MESSAGE);
        //setVisible(false);
        JOptionPane.showMessageDialog(jf, "Not a member yet? Sign up now!");
        jf.dispose();
//        JOptionPane jop = new JOptionPane("Want to be a member today?",JOptionPane.PLAIN_MESSAGE,
//                JOptionPane.OK_CANCEL_OPTION);
//        if ((int)jop.getValue() == (JOptionPane.OK_OPTION)) {
//            new SignUpUI();
//        } else {
//            new MainMenuUI();
//        }
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    // EFFECTS: click the buttonLogin when pressing the ENTER key
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonLogin.doClick();
        }
    }
}
