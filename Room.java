import java.util.HashMap; 

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
        String exit = "Exits:";
        if (this.aNorthExit != null)
        {
            exit +=" north";
        }
        if (this.aEastExit != null)
        {
            exit +=" east";
        }
        if (this.aSouthExit != null)
        {
            exit+=" south"; 
        }   
        if (this.aWestExit != null)
        {
            exit +=" west";
        }
        return exit;
    }
    
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        exits.put(pDirection, pNeighbor);
    }
} // Room
