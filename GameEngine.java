import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
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
    private Parser aParser;
    private UserInterface gui;
    public static Stack<Room> roomHistory;
    private Player player;
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
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * @param commandLine A string containing a command
     */
    public void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = aParser.getCommand(commandLine);
        if(command.isUnknown()) {
            gui.println("I don't know what you mean...");
            return;
        }
        CommandWord commandWord = command.getCommandWord();
        switch (commandWord)
        {
            case HELP : printHelp();
            break;
            case GO : goRoom(command);
            break;
            case QUIT :
            if(command.hasSecondWord())
                gui.println("Quit what?");
            else
                endGame();
            break;
            case EAT : eat(command);
            break;
            case LOOK : look();
            break;
            case BACK : goBack(command);
            break;
            case TEST : test(command);;
            break;
            case TAKE : take(command);
            break;
            case DROP : drop(command);
            break;
            case ITEMS : items();
            break;
            case CHARGE: charge();
            break;
            case TELEPORT: teleport();
            break;
            case ALEA: alea(command);
	        break;
        }
    }
    
    /**
     * Procedure permettant d'afficher des informations sur la piece actuelle
     */
    private void printLocationInfo()
    {
        gui.println(player.getCurrentRoom().getLongDescription() + "\n");
    }
    
    /**
     * Procedure permettant d'afficher le message de bienvenue
     */
    private void printWelcome()
    {
        gui.println("Welcome to the World of Zuul!");
        gui.println("World of Zuul is a new, incredibly boring adventure game.");
        gui.println("Type 'help' if you need help.\n");
        printLocationInfo();
        gui.showImage(player.getCurrentRoom().getImageName());
    }
    
    /**
     * Procedure correspondant a la commande de deplacement
     * @param pCommand Un objet Command contenant comme premier mot go
     */
    private void goRoom(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            gui.println("Go where ?");
            return;
        }
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = player.getCurrentRoom().getExit(vDirection);
        if (vNextRoom == null)
        {
            gui.println("There is no door !");
        }
        else
        {
            roomHistory.push(player.getCurrentRoom());
            player.changeRoom(vNextRoom);
            printLocationInfo();
            if(player.getCurrentRoom().getImageName() != null)
                gui.showImage(player.getCurrentRoom().getImageName());
        }
    }
    
    /**
     * Procedure correspondant a la commande d'aide
     */
    private void printHelp()
    {
        gui.println("You are lost. You are alone.");
        gui.println("You wander around at the university.");
        gui.println("Your command words are:");
        gui.println(this.aParser.getCommandList() + "\n");
    }
    
    /**
     * Procedure permettant d'afficher des informations sur la piece actuelle
     */
    private void look()
    {
        gui.println(player.getCurrentRoom().getLongDescription() + "\n");
    }
    
    /**
     * Procedure correspondant a la commande eat
     * @param pCommand Un objet Command contenant comme premier mot eat
     */
    private void eat(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            gui.println("You have eaten now and you are not hungry any more.\n");
            return;
        }
        else if (pCommand.getSecondWord().equals("cookie"))
        {
            Item item = player.findItem(pCommand.getSecondWord());
            if (item != null)
            {
                this.player.removeItem(item);
                this.player.setMaxWeight(10.0);
                gui.println("You have eaten the magic cookie.\n");
                gui.println("You have set the maximum weight of your inventory to 10kg.\n");
                return;
            }
            gui.println("I don't understand.\n");
        }
        else
        {
            gui.println("I don't understand.\n");
        }
    }
    
    /**
     * Procedure correspondant a la commande back
     * @param pCommand Un objet Command contenant comme premier mot back
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
            Room vPreviousRoom = roomHistory.peek();
            String direction = player.getCurrentRoom().getDirection(vPreviousRoom);
            if(direction == null)
            {
                gui.println("You can't back, you are trapped inside");
                return;
            }
            player.changeRoom(roomHistory.pop());
            printLocationInfo();
            if(player.getCurrentRoom().getImageName() != null)
                gui.showImage(player.getCurrentRoom().getImageName());
        }
    }
    
    /**
     * Procedure correspondant a la commande test
     * @param command Un objet Command contenant comme premier mot test
     */
    private void test(Command command) 
    { 
        if(!command.hasSecondWord())
        { 
            gui.println("What file ?"); 
            return;
        } 
        String file = command.getSecondWord();
        Scanner test = null;
        try
        {
            test = new Scanner(new File(file));
        }
        catch(FileNotFoundException evt)
        {
            gui.println("The file " + file + " was not found.\n");
            return;
        }
        while(test.hasNextLine())
        { 
            interpretCommand((String) test.nextLine());
        }
        test.close();
    }
    
    /**
     * Procedure correspondant a la commande take
     * @param command Un objet Command contenant comme premier mot take
     */
    public void take(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            gui.println("Take what?\n");
            return;
        }
        
        String name = command.getSecondWord();
        Item item = (player.getCurrentRoom()).findItem(name);

        if (item != null)
        {
            double weight = item.getWeight();
            if (this.player.getMaxWeight() - weight >= 0)
            {
                this.player.getCurrentRoom().removeItem(item);
                this.player.addItem(item);
                this.player.setMaxWeight(-weight);
            }
            else
            {
                gui.println("You can't take more.\n");
            }
        }     
        else
        {
            gui.println("The item doesn't exist.\n");
        }
    }
    
    /**
     * Procedure correspondant a la commande drop
     * @param command Un objet Command contenant comme premier mot drop
     */
    public void drop(Command command)
    {
        if(!command.hasSecondWord()) 
        {
            gui.println("Drop what?\n");
            return;
        }     

        String name = command.getSecondWord();
        Item item = player.findItem(name);

        if (item != null)
        {
            double weight = item.getWeight();
            this.player.getCurrentRoom().addItem(item);
            this.player.removeItem(item);
            this.player.setMaxWeight(weight);
        } 
        else
        {
            gui.println("The item doesn't exist.\n");
        }
    }
    
    /**
     * Procedure correspondant a la commande charge
     */
    public void charge()
    {
        if(player.findItem("beamer") == null)
		{
			gui.println("You need the beamer to charge.");
			return;
		}
		
		Beamer vBeamer = (Beamer) player.findItem("beamer");
        gui.println("You save the current room with your beamer.");
		vBeamer.setCharged(true);
		vBeamer.setRoom(player.getCurrentRoom());
    }
    
    /**
     * Procedure correspondant a la commande teleport
     */
    public void teleport()
    {
		if(player.findItem("beamer") == null)
		{
			gui.println("You need the beamer to teleport.");
			return;
		}
		
		Beamer vBeamer = (Beamer) player.findItem("beamer");
	
		if (vBeamer.getCharged())
		{
			Room vRoom = vBeamer.getRoom();
			if (!vRoom.equals(player.getCurrentRoom()))
			{
				gui.println("You are using the beamer.");
				player.changeRoom(vRoom);
				vBeamer.setCharged(false);
				roomHistory.clear();
				roomHistory.push(player.getCurrentRoom());
                printLocationInfo();
                if(player.getCurrentRoom().getImageName() != null)
                    gui.showImage(player.getCurrentRoom().getImageName());
			}
			else
			{
				gui.println("You are already in the charged room.");
			}
		}
		else
		{
			gui.println("You need to charge to beamer.");
        }
    }
	
    /**
     * Procedure correspondant a la commande alea
     * @param command Un objet Command contenant comme premier mot eat
     */
    public void alea(Command command)
	{
    	if(!command.hasSecondWord())
		{
        	gui.println("Random enabled.");
        	RoomRandomizer.setSeed(null);
        }
        else
        {
        	try
			{
        		RoomRandomizer.setSeed(Long.parseLong(command.getSecondWord(), 10));
        	}
			catch (NumberFormatException E)
        	{
        		gui.println("Wrong seed.");
        		return;
        	}
        	
    		gui.println("You changed the seed.");        		
        }
	}
    
    /**
     * Procedure permettant d'afficher l'inventaire
     */
    public void items()
    {
        gui.println(this.player.getItemString());
        gui.println("Your inventory weighs " + this.player.getCurrentWeight() + " kg.\n");
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