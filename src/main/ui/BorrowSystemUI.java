package ui;


import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class BorrowSystemUI extends SystemUI implements ActionListener, KeyListener {
    private static JLabel l1 = new JLabel();
    private static JRadioButton rb1;
    private static JRadioButton rb2;
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;
    private static JButton buttonOK;
    private static ButtonGroup buttonGroup = new ButtonGroup();



    public BorrowSystemUI() {
        super("Borrow System");
        jf.setPreferredSize(new Dimension(400, 90));
        //((JPanel) jf.getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        jf.setLayout(new GridLayout());
        //JPanel jp = new JPanel();
        ImagePanel jp = new ImagePanel(
                new ImageIcon(
                        "/Users/yujiech/IdeaProjects/project_b9k2b/data/BorrowSystemUIbg.jpg").getImage());
//        choiceList = new JList();
//        JScrollPane scrollPane = new JScrollPane();
//        jp.add(scrollPane,BorderLayout.CENTER);
//        scrollPane.setViewportView(choiceList);
//        String[] listData = new String[2];
//        listData[0] = "Yes";
//        listData[1] = "No";
//        choiceList.setListData(listData);

        jf.add(jp);
        jf.setBounds(400, 500, 400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        jf.addKeyListener(this);
        addComponentsToPaneForMemberChecking(jp);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

    }

    private void addComponentsToPaneForMemberChecking(Container pane) {
        GridBagConstraints c = gridLayoutConstruction(pane);
        label1(pane, c);
        choice1Y(pane, c);
        choice1N(pane, c);
        confirmButton(pane, c);
        buttonGroup.add(rb1);
        buttonGroup.add(rb2);


    }


    private void confirmButton(Container pane, GridBagConstraints c) {
        buttonOK = new JButton();
        buttonOK.setText("OK");
        buttonOK.setActionCommand("OK");
        buttonOK.addActionListener(this);
        pane.add(buttonOK);
    }


    private void choice1Y(Container pane, GridBagConstraints c) {
        rb1 = new JRadioButton("Yes",true);    //创建JRadioButton对象
        rb1.addActionListener(this);
        pane.add(rb1);
    }

    private void choice1N(Container pane, GridBagConstraints c) {
        rb2 = new JRadioButton("No");    //创建JRadioButton对象
        rb2.addActionListener(this);
        pane.add(rb2);

    }


    private static void label1(Container pane, GridBagConstraints c) {
        l1.setText("Are you a member of our library?");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 0;
        pane.add(l1, c);
        Font font = new Font("Segoe Script", Font.ITALIC, 10);
        l1.setFont(font);
    }


    // EFFECTS: react to the button clicked ,if button yes is chosen, open LoginUI;
    //           if button no is chosen, open SignUpUI
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("OK")) {
            if (buttonGroup.getSelection().equals(rb1.getModel())) {
                new LoginUI();
                jf.setVisible(true);
                jf.dispose();
            } else {
                new SignUpUI();
                jf.setVisible(true);
                jf.dispose();
            }
        }
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

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }


    // click the buttonOK when pressing the ENTER key
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonOK.doClick();
        }

    }

}







//        if (actionEvent.getActionCommand().equals("login")) {
//            loginHandling();
//
//        }
//        if (actionEvent.getActionCommand().equals("Done")) {
//            String bn = tf1.getText();
//            String bt = tf2.getText();
//            int num = Integer.parseInt(tf3.getText());
//            String borrowerName = accountName.getText();
//            borrowHandling(bn, bt, num, borrowerName);
//        }


//    private void loginHandling() throws IOException {
//        Member m = new Member(accountName.getText(),Integer.parseInt(tf2.getText()));
//        if (MainMenuLayout.getLibrary().getMemberManager().checkMembership(m)) {
//            JOptionPane.showMessageDialog(this,"Login successfully!");
//            //notification.setText("Login successfully!");
//            new BorrowUI();
//        } else {
//            notification.setText("Your membership info is not found. You are not a member yet");
//            // jump to sign up page
//        }
//    }

//    private void borrowHandling(String bn, String bt, int num, String borrowerName) throws IOException {
//        if (MainMenuLayout.getLibrary().getLibraryManager().enoughBookToBeBorrowed(num,bn,bt)) {
//            Book bookToBeBorrowed = new Book(bt, bn, null);
//            LibraryManager lm = MainMenuLayout.getLibrary().getLibraryManager();
//            BookRecord found = lm.findBookRecord(bookToBeBorrowed);
//            found.setNumberMinus(num);
//            BookBorrowRecord newAdded = lm.getBookBorrowRecordRoom().findOrCreateBookBorrowRecordWhenBorrow(
//                    bn,bt);
//            newAdded.updateAllBorrowInfoForBorrow(borrowerName,num);
//            notification.setText("All done! Remember to return your book within 30 days");
//            lm.getBookBorrowRecordRoom().save1("./data/borrowersListFile.txt");
//            lm.save1("./data/outputFile.txt");
//
//
//        }
//    }

    //private void createMemberGUI() {
    //JFrame memberLoginFrame = getJFrame("Member Login");
    //Set up the content pane.
    //addComponentsToPaneForMemberLogin(memberLoginFrame.getContentPane());
    //Display the window.
    // windowDisplay(memberLoginFrame);
    //}

//   private void windowDisplay(JFrame memberLoginFrame) {
//        memberLoginFrame.pack();
//        memberLoginFrame.setVisible(true);
//    }

//    private void createBorrowGUI() {
//        JFrame borrowFrame = getJFrame("borrow");
//        //Set up the content pane.
//        addComponentsToPaneForBorrow(borrowFrame.getContentPane());
//        //Display the window.
//        windowDisplay(borrowFrame);
//    }

//    private JFrame getJFrame(String frameName) {
//        JFrame borrowFrame = new JFrame(frameName);
//        JPanel jp = new JPanel();
//        borrowFrame.add(jp);
//        borrowFrame.setSize(400, 600);
//        borrowFrame.setBounds(300, 200, 400, 300);
//        borrowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        return borrowFrame;
//    }

//    private void addComponentsToPaneForBorrow(Container cp) {
//        GridBagConstraints c = gridLayoutConstruction(cp);
//        label1ForBorrow(cp,c);
//        label2ForBorrow(cp,c);
//        label3ForBorrow(cp,c);
//        typeInput(cp,c);
//        bookNameInput(cp,c);
//        numInput(cp,c);
//        notificationForBorrow(cp,c);
//        buttonForDone(cp,c);
//
//    }


//    private static void label3ForBorrow(Container pane, GridBagConstraints c) {
//        l3.setText("numToBorrow");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
//        c.gridwidth = 1;
//        c.gridx = 1;
//        c.gridy = 2;
//        pane.add(l3, c);
//    }
//
//
//    private static void numInput(Container pane, GridBagConstraints c) {
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 3;
//        c.gridy = 2;
//        pane.add(tf3, c);
//
//
//    }
//
//
//    private static void label2ForBorrow(Container pane, GridBagConstraints c) {
//        l2.setText("bookType");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
//        c.gridwidth = 1;
//        c.gridx = 1;
//        c.gridy = 1;
//        pane.add(l2, c);
//    }
//
//
//    private static void typeInput(Container pane, GridBagConstraints c) {
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 3;
//        c.gridy = 1;
//        pane.add(tf2, c);
//
//
//    }
//
//    private static void label1ForBorrow(Container pane, GridBagConstraints c) {
//        l1.setText("bookName");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 1;
//        c.gridy = 0;
//        pane.add(l1, c);
//    }
//
//    private static void bookNameInput(Container pane, GridBagConstraints c) {
//        if (shouldWeightX) {
//            c.weightx = 0.5;
//        }
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.gridx = 3;
//        c.gridy = 0;
//        pane.add(tf1,c);
//
//    }
//
//    private static void notificationForBorrow(Container pane, GridBagConstraints c) {
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 2;
//        c.gridy = 3;
//        //notification.setLineWrap(true);
//        pane.add(notification, c);
//
//    }
//
//    private void buttonForDone(Container pane, GridBagConstraints c) {
//        JButton buttonDone = new JButton("Done");
//        buttonDone.setActionCommand("Done");
//        buttonDone.addActionListener(actionEvent -> {
//            try {
//                actionPerformedMultiple(actionEvent);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 3;
//        c.gridy = 4;
//        pane.add(buttonDone,c);
//
//    }


//    private void addComponentsToPaneForMemberLogin(Container cp) {
//        GridBagConstraints c = gridLayoutConstruction(cp);
//        label2ForLogin(cp,c);
//        label3ForLogin(cp,c);
//        buttonForLogin(cp,c);
//        memberNameInput(cp,c);
//        last4IDInput(cp,c);
//    }





//    private static void label2ForLogin(Container pane, GridBagConstraints c) {
//        l2.setText("AccountName");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 1;
//        c.gridy = 0;
//        pane.add(l2,c);
//    }
//
//    private static void label3ForLogin(Container pane, GridBagConstraints c) {
//        l3.setText("Last4DigitOfID");
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 1;
//        c.gridy = 1;
//        pane.add(l3,c);
//    }
//
//    private static void memberNameInput(Container pane, GridBagConstraints c) {
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 3;
//        c.gridy = 0;
//        pane.add(accountName,c);
//    }
//
//    private static void last4IDInput(Container pane, GridBagConstraints c) {
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 3;
//        c.gridy = 1;
//        pane.add(tf2,c);
//    }
//
//    private void buttonForLogin(Container pane, GridBagConstraints c) {
//        buttonLogin = new JButton("Login");
//        buttonLogin.setActionCommand("login");
//        buttonLogin.addActionListener(actionEvent -> {
//            try {
//                actionPerformedMultiple(actionEvent);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 2;
//        c.gridy = 2;
//        pane.add(buttonLogin,c);
//
//    }














