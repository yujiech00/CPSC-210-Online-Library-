package ui;

import exception.WrongPlaceToReturnException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


public class ReturnSystemUI extends JFrame implements ActionListener, KeyListener {
    private static JLabel l1 = new JLabel();
    private static JLabel l2 = new JLabel();
    private static JLabel l3 = new JLabel();
    private static JLabel l4 = new JLabel();
    private static JTextField txtField1 = new JTextField(8);
    private static JTextField txtField2 = new JTextField(8);
    private static JTextField txtField3 = new JTextField(8);
    private static JTextField txtField4 = new JTextField(8);
   // private static JTextArea textArea = new JTextArea();
    private static JButton button;
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;


    public ReturnSystemUI() {
        super("ReturnSystem");
        setPreferredSize(new Dimension(400, 90));
        //((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new GridLayout());
        button = new JButton("Return");
        button.setActionCommand("return");
        button.addActionListener(this);
        //JPanel jp = new JPanel();
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/ReturnUIbg.jpg").getImage());

        pack();
        add(jp);
        setBounds(400, 500, 400, 300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        addComponentsToPane(jp);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        nameInput(pane, c);

        label1(pane, c);

        typeInput(pane, c);

        label2(pane, c);

        buttonForConfirm(pane, c);

        //resultText(pane, c);

        label3(pane,c);

        numberInput(pane,c);

        label4(pane,c);

        borrowerNameInput(pane,c);



    }

    private void buttonForConfirm(Container pane, GridBagConstraints c) {
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 2;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 5;       //third row
        pane.add(button, c);
        button.addActionListener(this);

    }


    private static void label4(Container pane, GridBagConstraints c) {
        l4.setText("borrower name");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(l4, c);
    }

    private void borrowerNameInput(Container pane, GridBagConstraints c) {
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3;
        pane.add(txtField4, c);
        txtField4.addKeyListener(this);

    }


    private static void label3(Container pane, GridBagConstraints c) {
        l3.setText("numberToReturn");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(l3, c);
    }

    private void numberInput(Container pane, GridBagConstraints c) {
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        pane.add(txtField3, c);
        txtField3.addKeyListener(this);

    }


    private static void label2(Container pane, GridBagConstraints c) {
        l2.setText("bookType");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(l2, c);
    }


    private void typeInput(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(txtField2, c);
        txtField2.addKeyListener(this);



    }

    private static void label1(Container pane, GridBagConstraints c) {
        l1.setText("bookName");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(l1, c);
    }

    private void nameInput(Container pane, GridBagConstraints c) {
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        pane.add(txtField1, c);
        txtField1.addKeyListener(this);

    }

//    private static void resultText(Container pane, GridBagConstraints c) {
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 1;
//        c.gridx = 2;
//        c.gridy = 4;
//        textArea.setLineWrap(true);
//        textArea.setRows(2);
//        Font font = new Font("Segoe Script", Font.BOLD, 10);
//        textArea.setFont(font);
//        //c.ipady = 8;
//        pane.add(textArea, c);
//
//
//    }


    // EFFECTS: react to the buttonReturn clicked and
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("return")) {
            String bookName = txtField1.getText();
            String bookType = txtField2.getText();
            String n = txtField3.getText();
//            int numberToReturn = Integer.parseInt(txtField3.getText());
            String borrowerName = txtField4.getText();
            if (!bookName.equals("") && !bookType.equals("") && !borrowerName.equals("") && !n.equals("")) {
//                JOptionPane.showMessageDialog(this, "All lines should be filled in!",
//                        "!!!", JOptionPane.WARNING_MESSAGE);
//            } else {
                int numberToReturn = Integer.parseInt(n);
                returnResult(bookName, bookType, numberToReturn, borrowerName);
                returnHandling();
                txtField1.setText("");
                txtField2.setText("");
                txtField3.setText("");
                txtField4.setText("");
            }
        }
    }

    private void returnResult(String bookName, String bookType, int numberToReturn, String borrowerName) {
        try {
            MainMenuUI.getLibrary().getLibraryManager().changeBookRecordSystemForReturn(
                    bookName, bookType, numberToReturn,
                    borrowerName, "./data/borrowersListFile.txt");
            JOptionPane.showMessageDialog(this,
                    "All done! Thanks for using our library system!");

        } catch (WrongPlaceToReturnException | IOException e) {
            JOptionPane.showMessageDialog(this, " Return books to the wrong library!!!");
        }
    }

    private void returnHandling() {
        try {
            MainMenuUI.getLibrary().getLibraryManager().getBookBorrowRecordRoom().save1(
                    "./data/borrowersListFile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            MainMenuUI.getLibrary().getLibraryManager().save1("./data/outputFile.txt");
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


    // EFFECTS: click the button when pressing the ENTER key
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            button.doClick();
        }
    }

}



