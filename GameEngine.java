import java.util.Stack;

/**
 * Classe principale du jeu, elle permet de démarrer Zuul.
 */
public class GameEngine
{
    private Room aCurrentRoom;
    private Parser aParser;
    private UserInterface gui;
    public static Stack<Room> roomHistory;

    /**
     * Constructeur de la classe Game.
     * Il permet d'initialiser le jeu et d'afficher un message de bienvenue
     */
    public GameEngine()
    {
        createRooms();
        this.aParser = new Parser();
        roomHistory = new Stack<Room>();
    }
    
    /**
     * Création du gui
     */
    public void setGUI(UserInterface userInterface)
    {
        gui = userInterface;
        printWelcome();
    }
    
    /**
     * Procédure permettant de créer les pièces du jeu
     */
    private void createRooms()
    {
        Room vOutside = new Room("outside the main entrance of the university", "images/outside.gif");
        Room vTheatre = new Room("in a lecture theatre", "images/courtyard.gif");
        Room vPub     = new Room("in the campus pub", "images/dungeon.gif");
        Room vLab     = new Room("in a computing lab", "images/hallway.gif");
        Room vServer  = new Room("in the server room", "images/stairs.gif");
        Room vOffice  = new Room("in the computing admin office", "images/castle.gif");
        
        vOutside.setExit("east", vTheatre);
        vOutside.setExit("west", vPub);
        vOutside.setExit("south", vLab);
        
        vTheatre.setExit("west", vOutside);
        
        vPub.setExit("east", vOutside);
        
        vLab.setExit("north", vOutside);
        vLab.setExit("east", vOffice);
        vLab.setExit("up", vServer);
        
        vServer.setExit("down", vLab);

        vOffice.setExit("west", vLab);
        
        vOutside.addItem(new Item("beer", 0.5));
        vOutside.addItem(new Item("cola", 1));
        vTheatre.addItem(new Item("juice", 1));

        this.aCurrentRoom = vOutside;
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = aParser.getCommand(commandLine);

        if(command.isUnknown()) {
            gui.println("I don't know what you mean...");
            return;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit")) {
            if(command.hasSecondWord())
                gui.println("Quit what?");
            else
                endGame();
        }
        else if (commandWord.equals("eat"))
            eat();
        else if (commandWord.equals("look"))
            look();
        else if (commandWord.equals("back"))
            goBack(command);
    }
    
    /**
     * Affiche des informations sur la pièce actuelle
     */
    private void printLocationInfo()
    {
        gui.println(this.aCurrentRoom.getLongDescription() + "\n");
    }
    
    /**
     * Affiche le message de bienvenue
     */
    private void printWelcome()
    {
        gui.println("Welcome to the World of Zuul!");
        gui.println("World of Zuul is a new, incredibly boring adventure game.");
        gui.println("Type 'help' if you need help.\n");
        printLocationInfo();
        gui.showImage(this.aCurrentRoom.getImageName());
    }
    
    /**
     * Commande de déplacement
     */
    private void goRoom(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            gui.println("Go where ?");
            return;
        }
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
        if (vNextRoom == null)
        {
            gui.println("There is no door !");
        }
        else
        {
            roomHistory.push(this.aCurrentRoom);
            this.aCurrentRoom = vNextRoom;
            printLocationInfo();
            if(aCurrentRoom.getImageName() != null)
                gui.showImage(aCurrentRoom.getImageName());
        }
    }
    
    /**
     * Commande d'aide
     */
    private void printHelp()
    {
        gui.println("You are lost. You are alone.");
        gui.println("You wander around at the university.");
        gui.println("Your command words are:");
        gui.println(this.aParser.getCommandList() + "\n");
    }
    
    /**
     * Affiche des informations sur la pièce actuelle
     */
    private void look()
    {
        gui.println(this.aCurrentRoom.getLongDescription() + "\n");
    }
    
    /**
     * Commande eat
     */
    private void eat()
    {
        gui.println("You have eaten now and you are not hungry any more.\n");
    }
    
    /**
     * Permet de revenir en arrière
     */
    private void goBack(final Command pCommand)
    {
        if (pCommand.hasSecondWord())
        {
            gui.println("Back where ?");
            return;
        }
        if (roomHistory.isEmpty())
        {
            gui.println("You can't back anymore");
        }
        else
        {
            this.aCurrentRoom = roomHistory.pop();
            printLocationInfo();
            if(aCurrentRoom.getImageName() != null)
                gui.showImage(aCurrentRoom.getImageName());
        }
    }
    
    private void endGame()
    {
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
} // Game