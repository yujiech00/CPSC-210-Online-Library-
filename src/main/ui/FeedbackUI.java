package ui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedbackUI extends SystemUI implements ActionListener, KeyListener {

    private static TextArea feedback;
    private static JButton buttonDone;


    public FeedbackUI() {
        super("Feedback Page");
        //ImageIcon img = new ImageIcon("file:///Users/yujiech/Desktop/heart-shaped.jpg");
        //setIconImage(img.getImage());
        jf.setPreferredSize(new Dimension(400, 90));
        //((JPanel) jf.getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        jf.setLayout(new GridLayout());
        //JPanel jp = new JPanel();
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/FeedbackUIbg.jpg").getImage());

        jf.pack();
        jf.add(jp);
        jf.setBounds(400, 500, 400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        addComponentsToPaneForFeedback(jp);
        jf.addKeyListener(this);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
    }

    private void addComponentsToPaneForFeedback(Container cp) {
        GridBagConstraints c = gridLayoutConstruction(cp);
        doneButton(cp,c);
        feedback(cp,c);

    }

    private void doneButton(Container pane, GridBagConstraints c) {
        buttonDone = new JButton("Done");
        buttonDone.setActionCommand("Done");
        buttonDone.addActionListener(this);
        buttonDone.setForeground(Color.BLUE);
        buttonDone.setSize(2,3);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(buttonDone,c);
    }

    private void feedback(Container pane, GridBagConstraints c) {
        feedback = new TextArea("Enter what you want to say to us");
        feedback.setRows(5);
        feedback.setColumns(8);
        //feedback.setBackground(Color.ORANGE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(feedback,c);
        feedback.addKeyListener(this);
    }


    // EFFECTS: react to the buttonDone clicked
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            Icon icon = new ImageIcon(new URL(
                    "file:///Users/yujiech/Desktop/CPSC%20210/icon/feedback.jpg"));

            if (actionEvent.getActionCommand().equals("Done")) {
                JOptionPane.showMessageDialog(jf,
                        "Thank you for your feedback! It means a lot to us!",null,JOptionPane.PLAIN_MESSAGE,icon);
                feedback.setText("");

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        if (actionEvent.getActionCommand().equals("Done")) {
//            JOptionPane.showMessageDialog(this,
//                    "Thank you for your feedback! It means a lot to us!",null,JOptionPane.PLAIN_MESSAGE,icon);
//
//
//            feedback.setText("");
//
//
//        }

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
