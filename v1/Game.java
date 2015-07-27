package v1;

public class Game
{
    private Room aCurrentRoom;
    
    public Game()
    {
        createRooms();
        printWelcome();
    }
    
    private void createRooms()
    {
        Room vOutside = new Room("outside the main entrance of the university");
        Room vTheatre = new Room("in a lecture theatre");
        Room vPub     = new Room("in the campus pub");
        Room vLab     = new Room("in a computing lab");
        Room vOffice  = new Room("in the computing admin office");
        
        vOutside.setExits(null, vTheatre, vPub, vLab);
        vTheatre.setExits(null, null, vOutside, null);
        vPub.setExits(null, vOutside, null, null);
        vLab.setExits(vOutside, vOffice, null, null);
        vOffice.setExits(null, null, vLab, null);
        
        this.aCurrentRoom = vOutside;
    }
    
    private void goRoom(final Command pCommand)
    {
        Room vNextRoom = null;
        if (!pCommand.hasSecondWord())
        {
            System.out.println("Go where ?");
            return;
        }
        String vDirection = pCommand.getSecondWord();
        if (vDirection.equals("north"))
        {
            vNextRoom = this.aCurrentRoom.aNorthExit;
        }
        if (vDirection.equals("east"))
        {
            vNextRoom = this.aCurrentRoom.aEastExit;
        }
        if (vDirection.equals("west"))
        {
            vNextRoom = this.aCurrentRoom.aWestExit;
        }
        if (vDirection.equals("south"))
        {
            vNextRoom = this.aCurrentRoom.aSouthExit;
        }
        if (vNextRoom == null)
        {
            System.out.println("There is no door !");
        }
        else
        {
            this.aCurrentRoom = vNextRoom;
            System.out.println("You are " + this.aCurrentRoom.getDescription());
            System.out.print("Exits:");
            if (this.aCurrentRoom.aNorthExit != null)
            {
                System.out.print(" north");
            }
            if (this.aCurrentRoom.aEastExit != null)
            {
                System.out.print(" east");
            }
            if (this.aCurrentRoom.aWestExit != null)
            {
                System.out.print(" west");
            }
            if (this.aCurrentRoom.aSouthExit != null)
            {
                System.out.print(" south");
            }
        }
    }
    
    private void printWelcome()
    {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.\n");
        System.out.println("You are " + this.aCurrentRoom.getDescription());
        System.out.print("Exits:");
        if (this.aCurrentRoom.aNorthExit != null)
        {
            System.out.print(" north");
        }
        if (this.aCurrentRoom.aEastExit != null)
        {
            System.out.print(" east");
        }
        if (this.aCurrentRoom.aWestExit != null)
        {
            System.out.print(" west");
        }
        if (this.aCurrentRoom.aSouthExit != null)
        {
            System.out.print(" south");
        }
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
} // Game