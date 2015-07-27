 public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    public Game()
    {
        createRooms();
        printWelcome();
        this.aParser = new Parser();
    }
    
    private void createRooms()
    {
        Room vOutside = new Room("outside the main entrance of the university");
        Room vTheatre = new Room("in a lecture theatre");
        Room vPub     = new Room("in the campus pub");
        Room vLab     = new Room("in a computing lab");
        Room vOffice  = new Room("in the computing admin office");
        
        vOutside.setExit("east", vTheatre);
        vOutside.setExit("west", vPub);
        vOutside.setExit("south", vLab);
        
        vTheatre.setExit("west", vOutside);
        
        vPub.setExit("east", vOutside);
        
        vLab.setExit("north", vOutside);
        vLab.setExit("east", vOffice);

        vOffice.setExit("west", vLab);

        this.aCurrentRoom = vOutside;
    }
    
    private void goRoom(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            System.out.println("Go where ?");
            return;
        }
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
        if (vNextRoom == null)
        {
            System.out.println("There is no door !");
        }
        else
        {
            this.aCurrentRoom = vNextRoom;
            printLocationInfo();
        }
    }
    
    private void printWelcome()
    {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.\n");
        printLocationInfo();
    }
    
    private void printHelp()
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the university.");
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }
    
    private boolean quit(final Command pCommand)
    {
        if (pCommand.hasSecondWord())
        {
            System.out.println("Quit what ?");
            return false;
        }
        return true;
    }
    
    private boolean processCommand(final Command pCommand)
    {
        String Command = pCommand.getCommandWord();
        if (Command.equals("go"))
        {
            goRoom(pCommand);
        }
        else if (Command.equals("quit"))
        {
            return quit(pCommand);
        }
        else if (Command.equals("help"))
        {
            printHelp();
        }
        else
        {
            System.out.println("I don't know what you mean...");
            return false;
        }
        return false;
    }
    
    public void play()
    {
        printWelcome();
        boolean vFinished = false;
        while(!vFinished)
        {
            Command vCommand = this.aParser.getCommand();
            vFinished = processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    
    private void printLocationInfo()
    {
        System.out.println("Vous êtes " + this.aCurrentRoom.getDescription());
        System.out.print(this.aCurrentRoom.getExitString());
    }
} // Game