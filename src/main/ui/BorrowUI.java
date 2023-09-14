package ui;

import exception.NoEnoughBookException;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class BorrowUI extends SystemUI implements ActionListener, KeyListener {
    //private JFrame jf = new JFrame("Book Borrowing Page");
    private static JLabel l1 = new JLabel();
    private static JLabel l2 = new JLabel();
    private static JLabel l3 = new JLabel();
    private static TextField tf1 = new TextField();
    private static TextField tf2 = new TextField();
    private static TextField tf3 = new TextField();
    protected static String currentAccount;
    //private static TextArea notification = new TextArea();
    private static JButton buttonDone;
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;



    public BorrowUI() {
        super("Book Borrowing Page");
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/BorrowUIbg.jpg").getImage());

        //JPanel jp = new JPanel();
        jf.add(jp);
        addComponentsToPaneForBorrow(jp);
        jf.setSize(400, 600);
        jf.setBounds(300, 200, 400, 300);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        //notification.setColumns(20);
        //notification.setRows(3);
        //notification.setForeground(Color.BLUE);
        //Font font = new Font("Segoe Script", Font.PLAIN, 12);
        //notification.setFont(font);


    }

    private void addComponentsToPaneForBorrow(Container cp) {
        GridBagConstraints c = gridLayoutConstruction(cp);
        label1ForBorrow(cp,c);
        label2ForBorrow(cp,c);
        label3ForBorrow(cp,c);
        typeInput(cp,c);
        bookNameInput(cp,c);
        numInput(cp,c);
        //notificationForBorrow(cp,c);
        buttonForDone(cp,c);
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





    private static void label3ForBorrow(Container pane, GridBagConstraints c) {
        l3.setText("numToBorrow");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(l3, c);
    }


    private void numInput(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 2;
        tf3.addKeyListener(this);
        pane.add(tf3, c);


    }


    private static void label2ForBorrow(Container pane, GridBagConstraints c) {
        l2.setText("bookType");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(l2, c);
    }


    private static void typeInput(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(tf2, c);


    }

    private static void label1ForBorrow(Container pane, GridBagConstraints c) {
        l1.setText("bookName");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(l1, c);
    }

    private static void bookNameInput(Container pane, GridBagConstraints c) {
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        tf1.setColumns(12);
        pane.add(tf1,c);

    }

//    private static void notificationForBorrow(Container pane, GridBagConstraints c) {
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 2;
//        c.gridy = 3;
//        //notification.setLineWrap(true);
//        pane.add(notification, c);
//
//    }

    private void buttonForDone(Container pane, GridBagConstraints c) {
        buttonDone = new JButton("Done");
        buttonDone.setActionCommand("Done");
        buttonDone.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 3;
        c.gridy = 4;
        pane.add(buttonDone,c);

    }


    // EFFECTS: react to the buttonDone clicked
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Done")) {
            String bn = tf1.getText();
            String bt = tf2.getText();
            String n = tf3.getText();
            if (bn.equals("") || bt.equals("") || n.equals("")) {
                JOptionPane.showMessageDialog(jf, "All lines should be filled in!",
                        "!!!", JOptionPane.WARNING_MESSAGE);
            } else {
                inputHandling(bn, bt, n);
            }
        }
    }

    private void inputHandling(String bn, String bt, String n) {
        try {
            int num = Integer.parseInt(n);
            //String borrowerName = LoginUI.tf1.getText();
            try {
                borrowHandling(bn, bt, num, currentAccount);
            } catch (IOException | NoEnoughBookException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jf,"Invalid book number!",
                    "!!!",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void borrowHandling(String bn, String bt, int num, String borrowerName) throws
            IOException, NoEnoughBookException {
        if (MainMenuUI.getLibrary().getLibraryManager().findBookRecord(new Book(bt,bn,null)) == null) {
            JOptionPane.showMessageDialog(jf,
                    "Sorry, we don't have this kind of book. Search before borrow!", ":)",
                    JOptionPane.INFORMATION_MESSAGE);
            new SearchSystemUI();
        } else if (MainMenuUI.getLibrary().getLibraryManager().enoughBookToBeBorrowed(num,bn,bt)) {
            Book bookToBeBorrowed = new Book(bt, bn, null);
            LibraryManager lm = MainMenuUI.getLibrary().getLibraryManager();
            BookRecord found = lm.findBookRecord(bookToBeBorrowed);
            bookFindingHandling(bn, bt, num, borrowerName, lm, found);
        } else {
            JOptionPane.showMessageDialog(jf,
                    "Sorry, we don't have enough books left.Try to borrow another book ");
        }
    }

    private void bookFindingHandling(String bn, String bt, int num, String borrowerName,
                                     LibraryManager lm, BookRecord found) throws IOException {
        found.setNumberMinus(num);
        BookBorrowRecord newAdded = lm.getBookBorrowRecordRoom().findOrCreateBookBorrowRecordWhenBorrow(
                bn, bt);
        newAdded.updateAllBorrowInfoForBorrow(borrowerName, num);
        //notification.setText("All done! Remember to return your book within 30 days");
        lm.getBookBorrowRecordRoom().save1("./data/borrowersListFile.txt");
        lm.save1("./data/outputFile.txt");
        JOptionPane.showMessageDialog(jf,"All done! Remember to return your book within 30 days",
                "Great :)",JOptionPane.INFORMATION_MESSAGE);

        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    // EFFECTS: click the buttonDone when pressing the ENTER key
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonDone.doClick();
        }

    }
}
