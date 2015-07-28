/**
 * This is the representation of a player in the game Zuul.
 */
public class Player
{
    private String aName;
    private Room aCurrentRoom;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
    }

    /**
     * Enter the given room.
     */
    public void changeRoom(final Room nextRoom)
    {
        this.aCurrentRoom = nextRoom;
    }
    
    /**
     * Gets the room in which the player is currently located.
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    /**
     * Gets the name
     */
    public String getName()
    {
        return this.aName;
    }
}