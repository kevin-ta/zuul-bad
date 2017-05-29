package pkg_game;

import pkg_character.Character;
import pkg_character.MovingCharacter;
import pkg_item.*;
import pkg_commands.Command;
import pkg_commands.Parser;
import pkg_room.Room;
import pkg_room.TransporterRoom;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;

/**
 * Classe principale du jeu, elle permet de demarrer Zuul.
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class GameEngine implements ActionListener
{
    public static Parser aParser;
    public static UserInterface gui;
    public static Stack<Room> roomHistory;
    private static Player player;
    private Timer timer;
    private int aTimeLimit;
    public static ArrayList<Room> rooms;
    
    /**
     * Constructeur de la classe Game.
     * Il permet d'initialiser le jeu et d'afficher un message de bienvenue
     */
    public GameEngine()
    {
        this.player = new Player("BDE");
        this.aParser = new Parser();
        roomHistory = new Stack<Room>();
        rooms = new ArrayList<Room>();
        Room startRoom = createRooms();
        player.changeRoom(startRoom);
        timer = new Timer(300000, this);
        timer.start();
    }
    
    /**
     * Procedure permettant la creation du GUI
     * @param userInterface Un objet UserInterface
     */
    public void setGUI(UserInterface userInterface)
    {
        gui = userInterface;
        printWelcome();
    }
    
    /**
     * Fonction permettant de creer les pieces du jeu
     * @return Un objet Room correspondant a la premiere piece du jeu
     */
    private Room createRooms()
    {
        Room vOutside = new Room("outside the main entrance of the university", "images/outside.gif");
        Room vTheatre = new TransporterRoom("in a lecture theatre", "images/courtyard.gif");
        Room vPub     = new Room("in the campus pub", "images/dungeon.gif");
        Room vLab     = new Room("in a computing lab", "images/hallway.gif");
        Room vServer  = new Room("in the server room", "images/stairs.gif");
        Room vOffice  = new Room("in the computing admin office", "images/castle.gif");
        
        vOutside.setExit("east", vTheatre);
        vOutside.setExit("west", vPub);
        vOutside.setExit("south", vLab);
        
        vTheatre.setExit("west", vOutside);
        
        vPub.setExit("south", vLab);
        
        vLab.setExit("north", vOutside);
        vLab.setExit("east", vOffice);
        vLab.setExit("up", vServer);
        
        vServer.setExit("down", vLab);

        vOffice.setExit("west", vLab);
        
        vOutside.addItem(new Item("beer", 0.5));
        vOutside.addItem(new Item("cola", 1));
        vOutside.addItem(new Item("cookie", 0));
        vTheatre.addItem(new Item("juice", 1));
        Beamer beamer = new Beamer("beamer", 1);
        vOutside.addItem(beamer);
        
        rooms.add(vOutside);
        rooms.add(vTheatre);
        rooms.add(vPub);
        rooms.add(vLab);
        rooms.add(vOffice);
        
        vOutside.addCharacter(new Character("guardian", "Hello I'm the guardian of the well-known Poste Nord"));
        vOutside.addCharacter(new MovingCharacter("zephyr", "The best BDE ever <3", vTheatre));
        vOutside.addCharacter(new Character("macao", "The best family <3"));
 
        return vOutside;
    }
    
    /**
     * Accesseur permettant d'acceder a la liste des pieces
     * @return Une ArrayList contenant les pieces du jeu
     */
    public static ArrayList<Room> getRooms()
    {
        return GameEngine.rooms;
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param commandLine A string containing a command
     */
    public static void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = aParser.getCommand(commandLine);
        if(command == null) {
            gui.println("I don't know what you mean...");
        }
        else
        {
            command.execute(player);
        }
        gui.println("\n");
    }

    /**
     * Procedure permettant d'afficher le message de bienvenue
     */
    private void printWelcome()
    {
        gui.println("Welcome to the World of Zuul!");
        gui.println("World of Zuul is a new, incredibly boring adventure game.");
        gui.println("Type 'help' if you need help.\n");
        gui.println(player.getCurrentRoom().getLongDescription() + "\n");
        gui.showImage(player.getCurrentRoom().getImageName());
    }

    /**
     * Procedure permettant de mettre fin au jeu
     */
    private void endGame()
    {
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
    
    /**
     * Procedure correspondant au timer du jeu
     * @param e Un objet ActionEvent
     */
    public void actionPerformed(ActionEvent e)
    {
        this.aTimeLimit--;
        if (aTimeLimit <= 0)
        {
            gui.println("There is no time left, game over..");
            gui.enable(false);
            endGame();
            timer.stop();
        }
    }
}