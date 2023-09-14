package ui;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image img;


    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }


    // EFFECTS: add background image to the panel
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }


}