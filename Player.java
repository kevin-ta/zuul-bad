import java.util.ArrayList;

/**
 * This is the representation of a player in the game Zuul.
 */
public class Player
{
    private String aName;
    private Room aCurrentRoom;
    private ArrayList<Item> inventory;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.inventory = new ArrayList<Item>();
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
    
        /**
     * Add an item in the list inventory.
     */
    public void addInventory(Item item)
    {
        this.inventory.add(item);
    }
    
    /**
     * Remove an item in the list inventory.
     */
    public void removeInventory(Item item)
    {
        this.inventory.remove(item);
    }
    
    /**
     * Find an item in the list items.
     */
    public Item findInventory(String item)
    {
        for( int i=0; i < inventory.size(); i++)
        {
            Item chp = (Item) inventory.get(i);
            if (item.equals(chp.getDescription()))
            {
                return chp;
            }
        }
        return null;
    }
}