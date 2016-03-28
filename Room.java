import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Classe qui gère la partie pièce du jeu
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String imageName;
    private ItemList items;
    
    /**
     * Constructeur de la classe Game
     * Il permet d'initialiser un objet pièce et la HashMap des sorties possibles
     */
    public Room(final String pDescription, final String image)
    {
        this.aDescription = pDescription;
        this.exits = new HashMap<String, Room>();
        this.imageName = image;
        this.items = new ItemList();
    }

    /**
     * Accesseur qui retourne la sortir
     */
    public Room getExit(final String pDirection)
    {
        return this.exits.get(pDirection);
    }
    
    /**
     * Mutateur qui retourne la liste des sorties
     */
    private String getExitString()
    {
        String vReturnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys)
        {
            vReturnString += " " + exit;
        }
        return vReturnString;
    }
    
    /**
     * Crée une sortie dans une direction donnée
     */
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        this.exits.put(pDirection, pNeighbor);
    }
    
    /**
     * Accesseur qui retourne la description de la pièce
     */
    public String getLongDescription()
    {
        return "Vous etes " + this.aDescription + "\n"  + getExitString() + "\n" + items.getItemString();
    }
    
    /**
     * Accesseur qui retourne la direction de la pièce
     */
    public String getDirection(final Room pRoom)
    {
        String direction = null;
        for (String key : exits.keySet())
        {
            if (pRoom.equals(exits.get(key)))
            {
                direction = key;
                break;
            }
        }
        return direction;
    }
    
    /**
     * Return a string describing the room's image name
     */
    public String getImageName()
    {
        return this.imageName;
    }
    
    /**
     * Add an item in the list items.
     */
    public void addItem(Item item)
    {
        this.items.addItem(item);
    }
    
    /**
     * Remove an item in the list items.
     */
    public void removeItem(Item item)
    {
        this.items.removeItem(item);
    }
    
    /**
     * Find an item in the list items.
     */
    public Item findItem(String item)
    {
        return this.items.findItem(item);
    }
    
    /**
     * @return all the items present in a list.
     */
    public String getItemString()
    {
        return this.items.getItemString();
    }
} // Room
