package ui;

import model.Member;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class SignUpUI extends SystemUI implements ActionListener, KeyListener {
    private JFrame jf = new JFrame("Sign Up Page");
    private static JButton buttonSignUp;
    private static JLabel l1 = new JLabel();
    private static JLabel l2 = new JLabel();
    private static JLabel l3 = new JLabel();
    protected static TextField tf1 = new TextField();
    private static JPasswordField pf1 = new JPasswordField();
    private static JPasswordField pf2 = new JPasswordField();
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;


    public SignUpUI() {
        super("Sign Up Page");
        jf.setPreferredSize(new Dimension(400, 90));
        //((JPanel) jf.getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        jf.setLayout(new GridLayout());
        //JPanel jp = new JPanel();
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/SignUpUIbg.jpg").getImage());

        buttonSignUp = new JButton("Sign Up");
        buttonSignUp.setActionCommand("Sign Up");
        buttonSignUp.addActionListener(this);
        jf.addKeyListener(this);
        jf.pack();
        jf.add(jp);
        jf.setBounds(400, 500, 400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        addComponentsToPaneForMemberSignUp(jp);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
    }

    private void addComponentsToPaneForMemberSignUp(Container cp) {
        GridBagConstraints c = gridLayoutConstruction(cp);
        label1ForSignUp(cp,c);
        label2ForSignUp(cp,c);
        label3ForSignUp(cp,c);
        buttonForSignUp(cp,c);
        memberNameInput(cp,c);
        last4IDInput(cp,c);
        last4IDInputConfirm(cp,c);

    }

    private static void label1ForSignUp(Container pane, GridBagConstraints c) {
        l1.setText("AccountName");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(l1,c);
    }

    private static void label2ForSignUp(Container pane, GridBagConstraints c) {
        l2.setText("Last4DigitOfID");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(l2,c);
    }

    private static void label3ForSignUp(Container pane, GridBagConstraints c) {
        l3.setText("Confirm Last4DigitOfID");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(l3,c);
    }

    private static void memberNameInput(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(tf1,c);
    }

    private static void last4IDInput(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(pf1,c);
    }

    private void last4IDInputConfirm(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(pf2,c);
        pf2.addKeyListener(this);
    }

    private void buttonForSignUp(Container pane, GridBagConstraints c) {
        buttonSignUp = new JButton("Sign Up");
        buttonSignUp.setActionCommand("Sign Up");
        buttonSignUp.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 3;
        pane.add(buttonSignUp,c);

    }




    // EFFECTS: react to the buttonSignUp clicked
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Sign Up")) {
            if (tf1.getText().equals("") || String.valueOf(pf1.getPassword()).equals("")
                    || String.valueOf(pf2.getPassword()).equals("")) {
                JOptionPane.showMessageDialog(jf, "All lines should be filled in!", null,
                        JOptionPane.ERROR_MESSAGE);
            } else {
                if (!Arrays.equals(pf1.getPassword(), pf2.getPassword())) {
                    JOptionPane.showMessageDialog(jf,
                            "Two Passwords you enter are different!");
                } else {
                    Member m = new Member(tf1.getText(),Integer.parseInt(String.valueOf(pf1.getPassword())));
                    //MemberManager mm = MainMenuUI.getLibrary().getMemberManager();
                    memberHandling(m);
                }
            }
        }
    }

    private void memberHandling(Member m) {
        loadMemberList();
        MainMenuUI.getLibrary().addMember(m);
        try {
            MainMenuUI.getLibrary().getMemberManager().save1("./data/memberListFile.txt");
            Icon icon = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/heart-shaped.jpg"));

            JOptionPane.showMessageDialog(jf,
                    "Sign up successfully! Welcome to be our member! You gain a chance of lottery!",
                    null,JOptionPane.PLAIN_MESSAGE,icon);
            jf.setVisible(false);
            BorrowUI.currentAccount = tf1.getText();
            tf1.setText("");
            pf1.setText("");
            pf2.setText("");
            //new BorrowUI();
            new GiftUI();
            jf.dispose();
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void loadMemberList() {
        try {
            MainMenuUI.getLibrary().getMemberManager().load("./data/memberListFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    // EFFECTS: click the buttonSignUp when pressing the ENTER key
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonSignUp.doClick();
        }

    }
}
