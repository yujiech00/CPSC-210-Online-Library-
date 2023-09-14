package ui;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GiftUI extends SystemUI implements ActionListener {

    private Clip clip = AudioSystem.getClip();
    private AudioInputStream audioInputStream;




    public GiftUI() throws MalformedURLException, LineUnavailableException {
        super("Gift Page for New Member");
        jf.setPreferredSize(new Dimension(400, 90));
        //((JPanel) jf.getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        jf.setLayout(new GridLayout());
        //JPanel jp = new JPanel();
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/GiftUIbg.jpg").getImage());

        jf.pack();
        jf.add(jp);
        jf.setBounds(400, 500, 400, 300);
        jf.setVisible(true);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        addComponentsToPaneForGiftPage(jp);
        jf.setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);

    }

    private void addComponentsToPaneForGiftPage(Container cp) throws MalformedURLException {
        GridBagConstraints c = gridLayoutConstruction(cp);
        giftButton1(cp,c);
        giftButton2(cp,c);
        giftButton3(cp,c);
        giftButton4(cp,c);

    }

    private void giftButton1(Container pane, GridBagConstraints c) throws MalformedURLException {
        ImageIcon gift = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/gifticon.jpg"));
        JButton giftButton = new JButton(gift);
        c.gridx = 1;
        c.gridy = 0;
        pane.add(giftButton, c);
        giftButton.setActionCommand("1");
        giftButton.addActionListener(this);


    }

    private void giftButton2(Container pane, GridBagConstraints c) throws MalformedURLException {
        ImageIcon gift = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/gifticon.jpg"));
        JButton giftButton = new JButton(gift);
        c.gridx = 2;
        c.gridy = 0;
        pane.add(giftButton, c);
        giftButton.setActionCommand("2");
        giftButton.addActionListener(this);

    }

    private void giftButton3(Container pane, GridBagConstraints c) throws MalformedURLException {
        ImageIcon gift = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/gifticon.jpg"));
        JButton giftButton = new JButton(gift);
        c.gridx = 1;
        c.gridy = 1;
        pane.add(giftButton, c);
        giftButton.setActionCommand("3");
        giftButton.addActionListener(this);

    }

    private void giftButton4(Container pane, GridBagConstraints c) throws MalformedURLException {
        ImageIcon gift = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/gifticon.jpg"));
        JButton giftButton = new JButton(gift);
        c.gridx = 2;
        c.gridy = 1;
        pane.add(giftButton, c);
        giftButton.setActionCommand("4");
        giftButton.addActionListener(this);

    }

    // EFFECTS: react to the button clicked and open BorrowUI
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            choosePrize(actionEvent);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        jf.dispose();
        new BorrowUI();

    }

    private void choosePrize(ActionEvent actionEvent) throws
            UnsupportedAudioFileException, IOException, LineUnavailableException {
        // create AudioInputStream object
        //gift1(actionEvent);
        prizeChoosing(actionEvent);
    }

    private void gift1(ActionEvent actionEvent) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (actionEvent.getActionCommand().equals("1")) {
            JOptionPane.showMessageDialog(jf, "Second prize!!!");
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File("/Users/yujiech/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown "
                            + "Album/Scream Of Joy-SoundBible.com-1639390065.wav").getAbsoluteFile());
            // create clip reference
            //clip = AudioSystem.getClip();
            // open audioInputStream to the clip
            clip.open(audioInputStream);
            clip.loop(0);


        }
    }

    private void prizeChoosing(ActionEvent actionEvent) throws IOException,
            UnsupportedAudioFileException, LineUnavailableException {
        gift1(actionEvent);
        gift2(actionEvent);
        gift3(actionEvent);
        gift4(actionEvent);
    }

    private void gift4(ActionEvent actionEvent) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (actionEvent.getActionCommand().equals("4")) {
            JOptionPane.showMessageDialog(jf, "Third prize!!!");
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File("/Users/yujiech/Music/iTunes/iTunes Media/Music/Unknown "
                            + "Artist/Unknown Album/Ta Da-SoundBible.com-1884170640.wav").getAbsoluteFile());
            clip.open(audioInputStream);
            clip.loop(0);
        }
    }

    private void gift3(ActionEvent actionEvent) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (actionEvent.getActionCommand().equals("3")) {
            JOptionPane.showMessageDialog(jf, "First prize!!!");
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File("/Users/yujiech/Music/iTunes/iTunes Media/Music/Unknown Artist/Unknown "
                            + "Album/Scream Of Joy-SoundBible.com-1639390065.wav").getAbsoluteFile());
            clip.open(audioInputStream);
            clip.loop(0);
        }
    }

    private void gift2(ActionEvent actionEvent) throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        if (actionEvent.getActionCommand().equals("2")) {
            JOptionPane.showMessageDialog(jf, "Fourth prize!!!");
            audioInputStream = AudioSystem.getAudioInputStream(
                    new File("/Users/yujiech/Music/iTunes/iTunes Media/Music/Unknown "
                            + "Artist/Unknown Album/Ta Da-SoundBible.com-1884170640.wav").getAbsoluteFile());
            clip.open(audioInputStream);
            clip.loop(0);
        }
    }


}
