/**
 * TransporterRoom
 */
public class TransporterRoom extends Room
{
    public TransporterRoom(final String pDescription, final String pImage)
    {
        super(pDescription, pImage);
    }
    /**
     * Accesseur qui retourne une sortie aléatoire
     */
    public Room getExit(final String pDirection)
    {
        return this.findRandomRoom();
    }
    
    /**
     * Retourne une pièce aléatoire
     */
    public Room findRandomRoom()
    {
        RoomRandomizer random = new RoomRandomizer(GameEngine.getRooms());
        return random.nextRoom();
    }
}
