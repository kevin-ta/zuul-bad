package pkg_game;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling
 * @version 1.0 (Jan 2003)
 */
public class UserInterface implements ActionListener
{
    private GameEngine engine;
    private JFrame myFrame;
    private JTextField entryField;
    private JTextArea log;
    private JLabel image;
    private JButton aHelpButton, aLookbutton, aBackbutton, aItemsbutton, aNorthbutton, aSouthbutton, aEastbutton, aWestbutton; 

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(GameEngine gameEngine)
    {
        engine = gameEngine;
        createGUI();
    }

    /**
     * Print out some text into the text area.
     * @param text A string
     */
    public void print(String text)
    {
        log.append(text);
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Print out some text into the text area, followed by a line break.
     * @param text A string
     */
    public void println(String text)
    {
        log.append(text + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Show an image file in the interface.
     * @param imageName A string contaning the filename of an image
     */
    public void showImage(String imageName)
    {
        URL imageURL = this.getClass().getClassLoader().getResource(imageName);
        if(imageURL == null)
            System.out.println("image not found");
        else {
            ImageIcon icon = new ImageIcon(imageURL);
            image.setIcon(icon);
            myFrame.pack();
        }
    }

    /**
     * Enable or disable input in the input field.
     * @param on A boolean
     */
    public void enable(boolean on)
    {
        entryField.setEditable(on);
        if(!on)
            entryField.getCaret().setBlinkRate(0);
    }

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        myFrame = new JFrame("Zork");
        entryField = new JTextField(34);
        
        aHelpButton = new JButton("Help");
        aBackbutton = new JButton("Back");
        aLookbutton = new JButton("Look");
        aNorthbutton = new JButton("North");
        aSouthbutton = new JButton("South");
        aEastbutton = new JButton("East");
        aWestbutton = new JButton("West");
        aItemsbutton = new JButton("Items");
        
        log = new JTextArea();
        log.setEditable(false);
        JScrollPane listScroller = new JScrollPane(log);
        listScroller.setPreferredSize(new Dimension(400, 200));
        listScroller.setMinimumSize(new Dimension(400,100));

        JPanel panel = new JPanel();
        JPanel right = new JPanel();
        JPanel left = new JPanel();
        image = new JLabel();

        panel.setLayout(new BorderLayout());
        panel.add(image, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entryField, BorderLayout.SOUTH);
        panel.add(right, BorderLayout.EAST);
        panel.add(left, BorderLayout.WEST);
        
        right.setLayout(new BorderLayout());
        right.add(aNorthbutton, BorderLayout.NORTH);
        right.add(aSouthbutton, BorderLayout.SOUTH);
        right.add(aEastbutton, BorderLayout.EAST);
        right.add(aWestbutton, BorderLayout.WEST);
        
        left.setLayout(new BorderLayout());
        left.add(aLookbutton, BorderLayout.NORTH);
        left.add(aBackbutton, BorderLayout.SOUTH);
        left.add(aItemsbutton, BorderLayout.EAST);
        left.add(aHelpButton, BorderLayout.WEST);

        myFrame.getContentPane().add(panel, BorderLayout.CENTER);

        // add some event listeners to some components
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        entryField.addActionListener(this);
        aHelpButton.addActionListener(this);
        aLookbutton.addActionListener(this);
        aNorthbutton.addActionListener(this);
        aSouthbutton.addActionListener(this);
        aEastbutton.addActionListener(this);
        aWestbutton.addActionListener(this);
        aBackbutton.addActionListener(this);
        aItemsbutton.addActionListener(this);

        myFrame.pack();
        myFrame.setVisible(true);
        entryField.requestFocus();
    }

    /**
     * Actionlistener interface for entry textfield.
     * @param e An ActionEvent object
     */
    public void actionPerformed(ActionEvent e) 
    {
        Object source = e.getSource();
        if (source == aHelpButton) engine.interpretCommand("aider");
        else if (source == aLookbutton) engine.interpretCommand("look");
        else if (source == aBackbutton) engine.interpretCommand("back");
        else if (source == aItemsbutton) engine.interpretCommand("items");
        else if (source == aNorthbutton) engine.interpretCommand("go north");
        else if (source == aSouthbutton) engine.interpretCommand("go south");
        else if (source == aEastbutton) engine.interpretCommand("go east");
        else if (source == aWestbutton) engine.interpretCommand("go west");
        else processCommand();
    }

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        boolean finished = false;
        String input = entryField.getText();
        entryField.setText("");

        engine.interpretCommand(input);
    }
}