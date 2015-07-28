import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * Classe qui gère la partie pièce du jeu
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String imageName;
    
    /**
     * Constructeur de la classe Game
     * Il permet d'initialiser un objet pièce et la HashMap des sorties possibles
     */
    public Room(final String pDescription, final String image)
    {
        this.aDescription = pDescription;
        this.exits = new HashMap<String, Room>();
        this.imageName = image;
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
        return "Vous etes " + this.aDescription + "\n"  + getExitString();
    }
    
    /**
     * Return a string describing the room's image name
     */
	public String getImageName()
	{
		return this.imageName;
	}
} // Room
