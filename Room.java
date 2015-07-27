 public class Room
{
    private String aDescription;
    public Room aNorthExit;
    public Room aEastExit;
    public Room aWestExit;
    public Room aSouthExit;
    
    public Room(final String pDescription)
    {
        this.aDescription = pDescription;
    }

    public String getDescription()
    {
        return this.aDescription;
    }
    
    public void setExits(final Room pNorthExit, final Room pEastExit, final Room pWestExit, final Room pSouthExit)
    {
        this.aNorthExit = pNorthExit;
        this.aEastExit  = pEastExit;
        this.aWestExit  = pWestExit;
        this.aSouthExit = pSouthExit;
    }
    
    public Room getExit(final String pDirection)
    {
        if (pDirection.equals("north"))
        {
            return this.aNorthExit;
        }
        if (pDirection.equals("east"))
        {
            return this.aEastExit;
        }
        if (pDirection.equals("south"))
        {
            return this.aWestExit;
        }
        if (pDirection.equals("west"))
        {
            return this.aWestExit;
        }
        return null;
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
} // Room
