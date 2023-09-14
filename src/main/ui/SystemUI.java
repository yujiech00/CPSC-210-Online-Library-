package ui;

import javax.swing.*;
import java.awt.*;

public abstract class SystemUI {
    protected JFrame jf;
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;



    public SystemUI(String name) {
        jf = new JFrame(name);

        //super(name);
    }



    // EFFECTS: set up the gridLayout, return a specific GridBagConstraints
    protected GridBagConstraints gridLayoutConstruction(Container contentPane) {
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        return c;
    }



}
