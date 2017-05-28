import java.util.ArrayList;

/**
 * This is the representation of a player in the game Zuul.
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class Player
{
    private String aName;
    private Room aCurrentRoom;
    private ItemList inventory;
    private double aMaxWeight;
    
    /**
     * Constructor for objects of class Player
     * @param pName A string containing the name of the player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.inventory = new ItemList();
        this.aMaxWeight = 2.0;
    }

    /**
     * Enter the given room.
     * @param nextRoom A Room object
     */
    public void changeRoom(final Room nextRoom)
    {
        this.aCurrentRoom = nextRoom;
    }
    
    /**
     * Gets the room in which the player is currently located.
     * @return A Room object which corresponds to the current room
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    /**
     * Gets the name
     * @return A string containing the name of the player
     */
    public String getName()
    {
        return this.aName;
    }
    
    /**
     * Add an item in the list inventory.
     * @param item An Item object
     */
    public void addItem(Item item)
    {
        this.inventory.addItem(item);
    }
    
    /**
     * Remove an item in the list inventory.
     * @param item An Item object
     */
    public void removeItem(Item item)
    {
        this.inventory.removeItem(item);
    }
    
    /**
     * Find an item in the list items.
     * @param item An Item object
     * @return An Item object or null
     */
    public Item findItem(String item)
    {
        return this.inventory.findItem(item);
    }
    
    /**
     * Accesseur du poids max de l'inventaire
     * @return Le poids maximum de l'inventaire
     */
    public double getMaxWeight()
    {
        return this.aMaxWeight;
    }
    
     /**
     * Mutateur permettant de modifier le poids max de l'inventaire
     * @param pWeight The weight of the item
     */
    public void setMaxWeight(final double pWeight)
    {
        this.aMaxWeight += pWeight;
    }
    
    /**
     * Accesseur permettant d'acceder au poids actuelle de l'inventaire
     * @return Le poids current de l'inventaire
     */
    public double getCurrentWeight()
    {
        return this.inventory.getCurrentWeight();
    }
    
    /**
     * Fonction retournant une chaine de caracteres contenant les objets actuels de l'inventaire
     * @return Une chaine de caractere contenant les objets actuels de l'inventaire
     */
    public String getItemString()
    {
        return this.inventory.getItemString();
    }
}