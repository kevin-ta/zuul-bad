import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

 public class Room
{
    private String aDescription;
    public Room aNorthExit;
    public Room aEastExit;
    public Room aWestExit;
    public Room aSouthExit;
    private HashMap<String, Room> exits;
    
    public Room(final String pDescription)
    {
        this.aDescription = pDescription;
        exits = new HashMap<String, Room>();
    }

    public String getDescription()
    {
        return this.aDescription;
    }
    
    public Room getExit(final String pDirection)
    {
        return exits.get(pDirection);
    }
    
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
    
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        exits.put(pDirection, pNeighbor);
    }
} // Room
