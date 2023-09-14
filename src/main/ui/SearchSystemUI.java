package ui;

import model.Book;
import model.BookRecord;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchSystemUI extends JFrame implements ActionListener {

    private static JLabel l1 = new JLabel();
    private static JLabel l2 = new JLabel();
    private static JTextField txtField1 = new JTextField(8);
    private static JTextField txtField2 = new JTextField(8);
    private static JTextArea textArea = new JTextArea();
    private static JButton button;
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;
    private static MainMenuUI mainMenuUI;

    public SearchSystemUI()  {
        super("Search System");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(400, 90));
       // ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13)); //full-screen bg
        setLayout(new GridLayout());
        button = new JButton("Search");
        button.setActionCommand("search");
        button.addActionListener(this); //sets "this" class as an action listener for btn.
        //that means that when the btn is clicked,
        //this.actionPerformed(ActionEvent e) will be called.
        //You could also set a different class, if you wanted
        //to capture the response behaviour elsewhere
//        JFrame frame = new JFrame("SearchSystem");    //创建Frame窗口
        //JPanel jp = new JPanel();    //创建面板
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/SearchUIbg.jpg").getImage());
        pack();
        add(jp);
        setBounds(400, 500, 400, 300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        addComponentsToPane(jp);
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

        resultText(pane,c);


    }

    private void buttonForConfirm(Container pane, GridBagConstraints c) {
       // JButton button;
        //button = new JButton("Search");
        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        //c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 3;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 3;       //third row
        pane.add(button, c);
        button.setActionCommand("Search");
        button.addActionListener(this);

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


    private static void typeInput(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(txtField2, c);


    }

    private static void label1(Container pane, GridBagConstraints c) {
        l1.setText("bookName");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(l1, c);
    }

    private static void nameInput(Container pane, GridBagConstraints c) {
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        pane.add(txtField1,c);

    }

    private static void resultText(Container pane, GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 2;
        textArea.setLineWrap(true);
        textArea.setRows(4);
        textArea.setColumns(6);
        Font font = new Font("Segoe Script", Font.PLAIN, 12);
        textArea.setFont(font);
        pane.add(textArea, c);


    }





    // EFFECTS: react to the buttonSearch clicked
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //libraryManager.load1("./data/outputFile.txt");
        if (actionEvent.getActionCommand().equals("Search")) {
            String bookName = txtField1.getText();
            String bookType = txtField2.getText();
            BookRecord target = MainMenuUI.getLibrary().getLibraryManager().findBookRecord(
                    new Book(bookType, bookName, null));
            if (target == null) {
                textArea.setText("Sorry, this book is not available!");
                textArea.setForeground(Color.RED);
            } else {
                target.setAvailableStatus();
                textArea.setText(target.getBook().getTitle() + " " + target.getBook().getType()
                        + "\n" + target.getAvailableStatus() + "\n" + target.getNumber());
                textArea.setForeground(Color.BLUE);
            }
        }
    }


//    public void setMainMenuLayout(MainMenuUI m) {
//        if (!mainMenuUI.equals(m)) {
//            mainMenuUI = m;
//            m.setSearchSystemUI(this);
//        }
//    }



}
