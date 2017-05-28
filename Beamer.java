/**
 * Classe Beamer
 */
public class Beamer extends Item
{
    private Room aRoom;
    private boolean aCharged;
    
    /**
     * Constructeur de la classe Beamer
     */
    public Beamer(final String pDescription, final double pWeight)
    {
        super(pDescription, pWeight);
    }

    public Room getRoom()
    {
        return this.aRoom;
    }

    public void setRoom(final Room pRoom)
    {
        this.aRoom = pRoom;
    }
    
    public boolean getCharged()
    {
        return this.aCharged;
    }

    public void setCharged(final boolean pCharged)
    {
        this.aCharged = pCharged;
    }
}
