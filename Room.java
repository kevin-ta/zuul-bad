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
    private ArrayList<Item> items;
    
    /**
     * Constructeur de la classe Game
     * Il permet d'initialiser un objet pièce et la HashMap des sorties possibles
     */
    public Room(final String pDescription, final String image)
    {
        this.aDescription = pDescription;
        this.exits = new HashMap<String, Room>();
        this.imageName = image;
        this.items = new ArrayList<Item>();
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
        return "Vous etes " + this.aDescription + "\n"  + getExitString() + "\n" + getItemString();
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
        this.items.add(item);
    }
    
    /**
     * Remove an item in the list items.
     */
    public void removeItem(Item item)
    {
        this.items.remove(item);
    }
    
    /**
     * Find an item in the list items.
     */
    public Item findItem(String item)
    {
        for( int i=0; i < items.size(); i++)
        {
            Item chp = (Item) items.get(i);
            if (item.equals(chp.getDescription()))
            {
                return chp;
            }
        }
        return null;
    }
    
    /**
     * @return all the items present in a list.
     */
    public String getItemString()
    {
        String returnString = "Items:";
        for( int i=0; i < items.size(); i++)
        {
            returnString += (" " + ((Item) items.get(i)).getLongDescription());
        }
        return returnString;
    }
} // Room
