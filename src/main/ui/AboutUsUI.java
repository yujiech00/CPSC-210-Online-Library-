package ui;

import model.MemberManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


// video by Pixabay from Pexels
public class AboutUsUI extends SystemUI implements ActionListener {
    private static JButton b1;
    private static JButton b2;
    private static JButton b3;
    private static JButton b4;
    private static JButton b5;



    public AboutUsUI() throws MalformedURLException {
        super("About Us");
        jf.setPreferredSize(new Dimension(400, 90));
        //((JPanel) jf.getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        jf.setLayout(new GridLayout());
        //ImageIcon mainBackground = new ImageIcon(new URL("file:///Users/yujiech/Desktop/icon/AboutUsUIbg.jpg"));
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/AboutUsUIbg.jpg").getImage());

        //JPanel jp = new JPanel();
        jf.pack();
        jf.add(jp);
        jf.setBounds(400, 500, 400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        addComponentsToPaneForAboutUs(jp);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
    }

//    public static JPanel drawGamePanel() {
//        //Create game panel and attributes
//        JPanel gamePanel = new JPanel();
//        Image background = Toolkit.getDefaultToolkit().createImage("Background.png");
//        gamePanel.drawImage(background, 0, 0, null);
//        //Set Return
//        return gamePanel;
//    }

    private void addComponentsToPaneForAboutUs(Container cp) throws MalformedURLException {
        GridBagConstraints c = gridLayoutConstruction(cp);
        branchButton(cp,c);
        memberButton(cp,c);
        contactButton(cp,c);
        feedbackButton(cp,c);
        moreDetailsButton(cp,c);
    }

    private void moreDetailsButton(Container pane, GridBagConstraints c) throws MalformedURLException {
        ImageIcon video = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/video%20icon.png"));
        b5 = new JButton(video);
       // b5 = new JButton("More details");
        b5.setActionCommand("More details");
        b5.addActionListener(this);
        b3.setForeground(Color.PINK);
        b5.setToolTipText("click to watch our short intro video");
        b5.setSize(2,2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(b5,c);
    }



    private void feedbackButton(Container pane, GridBagConstraints c) {
        b4 = new JButton("Feedback");
        b4.setActionCommand("Feedback");
        b4.addActionListener(this);
        b4.setToolTipText("click to give us your feedback");
        b4.setForeground(Color.ORANGE);
        b4.setSize(10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(b4,c);
    }




    private void branchButton(Container pane, GridBagConstraints c) {
        b1 = new JButton("Branch Info");
        b1.setActionCommand("Branch");
        b1.addActionListener(this);
        b1.setToolTipText("click to see all our branches' info");
        b1.setForeground(Color.BLUE);
        b1.setSize(10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(b1,c);
    }


    private void memberButton(Container pane, GridBagConstraints c) {
        b2 = new JButton("Member Description");
        b2.setActionCommand("Member Description");
        b2.addActionListener(this);
        b2.setToolTipText("click to see our member size");
        b2.setForeground(Color.RED);
        b2.setSize(10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 3;
        c.gridy = 0;
        pane.add(b2,c);
    }

    private void contactButton(Container pane, GridBagConstraints c) {
        b3 = new JButton("Contact Us");
        b3.setActionCommand("Contact Us");
        b3.addActionListener(this);
        b3.setToolTipText("click to see more contact ways");
        b3.setBackground(Color.ORANGE);
        b3.setSize(10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(b3,c);
    }







    //EFFECTS: react to the button clicked
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        branchHandling(actionEvent);

        try {
            memberDescription(actionEvent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            contactUs(actionEvent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        feedback(actionEvent);

        try {
            moreDetails(actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void branchHandling(ActionEvent actionEvent) {
        try {
            branchInfo(actionEvent);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void moreDetails(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getActionCommand().equals("More details")) {
            JOptionPane.showMessageDialog(
                    jf,"Please wear the headphone to watch the following introduction movie!");
            //Desktop.getDesktop().open(new File("/Users/yujiech/Desktop/library.mp4"));
            Desktop.getDesktop().open(new File("/Users/yujiech/Desktop/CPSC 210/icon/library video.mp4"));

        }
    }

    private void feedback(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Feedback")) {
            jf.setVisible(false);
            new FeedbackUI();
        }
    }

    private void branchInfo(ActionEvent actionEvent) throws MalformedURLException {
        Icon icon = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/branch%20icon.png"));
        if (actionEvent.getActionCommand().equals("Branch")) {
            JOptionPane.showMessageDialog(jf,
                    "Richmond 236-222-2222; " + "\n"
                            + "Burnaby 236-333-3333; " + "\n"
                            + "Vancouver 236-111-1111; " + "\n"
                            + "Toronto 236-555-5555; " + "\n"
                            + "Montreal 236-666-6666","Branch Information",JOptionPane.PLAIN_MESSAGE,icon);

        }
    }

    private void contactUs(ActionEvent actionEvent) throws MalformedURLException {
        Icon icon = new ImageIcon(new URL(
                "file:///Users/yujiech/Desktop/CPSC%20210/icon/contact.jpg"));
        if (actionEvent.getActionCommand().equals("Contact Us")) {
            JOptionPane.showMessageDialog(jf,
                    "FaceBook: @VancouverLibrary " + "\n"
                            + "Instagram: @VancouverLibrary " + "\n"
                            + "Email: VancouverLibrary@gmail.com " + "\n"
                            + "CustomerServiceCenter: 236-333-6666","Contact Us",JOptionPane.PLAIN_MESSAGE,icon);

        }
    }

    private void memberDescription(ActionEvent actionEvent) throws MalformedURLException {
        Icon icon = new ImageIcon(new URL(
                "file:///Users/yujiech/Desktop/CPSC%20210/icon/member%20icon.png"));
        if (actionEvent.getActionCommand().equals("Member Description")) {
            MemberManager mm = MainMenuUI.getLibrary().getMemberManager();
            try {
                mm.load("./data/memberListFile.txt");
                JOptionPane.showMessageDialog(jf,
                        "We are glad to have " + mm.getMembers().size() + " members so far in our library!",
                        "Member Description",JOptionPane.PLAIN_MESSAGE,icon);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
