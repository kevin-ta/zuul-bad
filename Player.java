import java.util.ArrayList;

/**
 * This is the representation of a player in the game Zuul.
 */
public class Player
{
    private String aName;
    private Room aCurrentRoom;
    private ItemList inventory;
    private double aMaxWeight;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.inventory = new ItemList();
        this.aMaxWeight = 2.0;
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
    public void addItem(Item item)
    {
        this.inventory.addItem(item);
    }
    
    /**
     * Remove an item in the list inventory.
     */
    public void removeItem(Item item)
    {
        this.inventory.removeItem(item);
    }
    
    /**
     * Find an item in the list items.
     */
    public Item findItem(String item)
    {
        return this.inventory.findItem(item);
    }
    
    /**
     * Accesseur du poids max de l'inventaire
     */
    public double getMaxWeight()
    {
        return this.aMaxWeight;
    }
    
     /**
     * Mutateur du poids max de l'inventaire
     */
    public void setMaxWeight(final double pWeight)
    {
        this.aMaxWeight += pWeight;
    }
    
    /**
     * Accesseur du poids actuelle de l'inventaire
     */
    public double getCurrentWeight()
    {
        return this.inventory.getCurrentWeight();
    }
    
    /**
     * Accesseur qui retourne les objets actuels de l'inventaire
     */
    public String getItemString()
    {
        return this.inventory.getItemString();
    }
}