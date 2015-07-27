import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * Classe qui gère la partie pièce du jeu
 */
public class Room
{
    private String aDescription;
    public Room aNorthExit;
    public Room aEastExit;
    public Room aWestExit;
    public Room aSouthExit;
    private HashMap<String, Room> exits;
    
    /**
     * Constructeur de la classe Game
     * Il permet d'initialiser un objet pièce et la HashMap des sorties possibles
     */
    public Room(final String pDescription)
    {
        this.aDescription = pDescription;
        exits = new HashMap<String, Room>();
    }
    
    /**
     * Accesseur qui retourne la description de la pièce
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    /**
     * Accesseur qui retourne la sortir
     */
    public Room getExit(final String pDirection)
    {
        return exits.get(pDirection);
    }
    
    /**
     * Mutateur qui retourne la liste des sorties
     */
    public String getExitString()
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
        exits.put(pDirection, pNeighbor);
    }
} // Room
