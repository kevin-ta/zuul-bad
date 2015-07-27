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
} // Room
