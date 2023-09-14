package ui;

import model.LibraryManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JPanel;



public class MainMenuUI implements ActionListener {
    private static Library library;
    private static JLabel timeLabel;
    private static final boolean shouldFill = true;
    private static final boolean shouldWeightX = true;
    private static final boolean RIGHT_TO_LEFT = false;
    static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


//    private static SearchSystemUI searchSystemUI;
//    private static AddSystemUI addSystemUI;
//    private static ReturnSystemUI returnSystemUI;
//    private static BorrowSystemUI borrowSystemUI;


//    public MainMenuUI() {
//        searchSystemUI = new SearchSystemUI();
//        searchSystemUI.setMainMenuLayout(this);
//        addSystemUI = new AddSystemUI();
//        returnSystemUI = new ReturnSystemUI();
//        borrowSystemUI = new BorrowSystemUI();
//
//    }
//
//    public void setSearchSystemUI(SearchSystemUI s) {
//        if (!searchSystemUI.equals(s)) {
//            searchSystemUI = s;
//            s.setMainMenuLayout(this);
//        }
//    }

//    public static LibraryManager getLibraryManager() {
//        return libraryManager;
//    }


    public static Library getLibrary() {
        return library;
    }

    private static void addComponentsToPane(Container pane) throws MalformedURLException {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        //JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        buttonForAdd(pane, c);

        buttonForSearch(pane, c);

        buttonForBorrow(pane, c);

        buttonForReturn(pane, c);

        buttonForAboutUs(pane, c);

        setLibraryIcon(pane, c);

        currentTimeBar(pane, c);


    }

    private static void buttonForAboutUs(Container pane, GridBagConstraints c) {
        JButton button;
        button = new JButton("About Us");
        setUpForAboutUs(c);
        c.gridy = 2;
        button.setSize(5, 2);
        pane.add(button, c);
        button.setActionCommand("About Us");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new AboutUsUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void setUpForAboutUs(GridBagConstraints c) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 1;
        c.gridwidth = 0;
    }

    private static void buttonForReturn(Container pane, GridBagConstraints c) {
        JButton button;
        button = new JButton("ReturnSystem");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 2;
        pane.add(button, c);
        button.setActionCommand("Return");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ReturnSystemUI();

            }
        });


    }


    private static void buttonForBorrow(Container pane, GridBagConstraints c) {
        JButton button;
        button = new JButton("BorrowSystem");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button, c);
        button.setActionCommand("Borrow");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new BorrowSystemUI();


            }
        });

    }

    private static void buttonForSearch(Container pane, GridBagConstraints c) {
        JButton button;
        button = new JButton("SearchSystem");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(button, c);
        button.setActionCommand("Search");
        //button.addActionListener(new SearchSystemUI());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SearchSystemUI();

            }
        });


    }

    private static void buttonForAdd(Container pane, GridBagConstraints c) {
        JButton button;
        button = new JButton("AddSystem");
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(button, c);
        button.setActionCommand("Add");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddSystemUI();

            }
        });

    }

    private static void setLibraryIcon(Container pane, GridBagConstraints c) throws MalformedURLException {
        ImageIcon img = new ImageIcon(new URL("file:///Users/yujiech/Desktop/CPSC%20210/icon/library%20icon.png"));
        c.weightx = 0;
        c.gridx = 1;
        c.gridy = 0;
        JLabel jlPic = new JLabel(img);
        pane.add(jlPic, c);

    }

    private static void currentTimeBar(Container pane, GridBagConstraints c) {
        Calendar now = Calendar.getInstance();
        timeLabel = new JLabel(dateFormat.format(now.getTime()));
        timeLabel.setBounds(100, 100, 125, 125);
        c.gridx = 3;
        c.gridy = 0;
        pane.add(timeLabel, c);

        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                timeLabel.setText(dateFormat.format(now.getTime()));
            }
        }).start();

    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() throws MalformedURLException {
        //Create and set up the window.
        JFrame frame = new JFrame("Library System");
        ImagePanel jp = new ImagePanel(
                new ImageIcon("/Users/yujiech/IdeaProjects/project_b9k2b/data/MainMenuUIbg.jpg").getImage());
        //JPanel jp = new JPanel();

        // change the bg of main menu according to the time/season
        frame.add(jp);
        frame.setPreferredSize(new Dimension(400, 500));
        frame.setBounds(300, 200, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBackGroundMusic();

        //Set up the content pane.
        addComponentsToPane(jp);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }


    private static void setBackGroundMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(
                    "/Users/yujiech/IdeaProjects/project_b9k2b/data/background.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // EFFECTS: run the Library system GUI
    public static void main(String[] args) throws IOException {
        library = new Library("Vancouver");
        LibraryManager lm = library.getLibraryManager();
        lm.updateLibrarySystem(lm.load1("./data/outputFile.txt"));
        lm.getBookBorrowRecordRoom().load("./data/borrowersListFile.txt");
//        libraryManager = new LibraryManager();
//        libraryManager.updateLibrarySystem(libraryManager.load1("./data/outputFile.txt"));
//        libraryManager.getBookBorrowRecordRoom().load("./data/borrowersListFile.txt");
//        searchSystemUI = new SearchSystemUI();
//        addSystemUI = new AddSystemUI();
//        returnSystemUI = new ReturnSystemUI();
//        borrowSystemUI = new BorrowSystemUI();
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //
        if (actionEvent.getActionCommand().equals("Add")) {
//            //
        }

//
//        if (actionEvent.getActionCommand().equals("Search")) {
//            //
//        }
//
//        if (actionEvent.getActionCommand().equals("Borrow")) {
//            //
//
//        if (actionEvent.getActionCommand().equals("Return")) {
//            //
//        }
//

    }




}
