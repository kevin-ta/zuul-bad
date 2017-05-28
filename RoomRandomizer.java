import java.util.Random;
import java.util.ArrayList;

/**
 * RoomRandomizer
 */
public class RoomRandomizer
{
    private static Long aSeed = null;
    private Random aRandom;
    private Room[] aTabRoom;

    /**
     * Constructeur de la classe RoomRandomizer
     */
    public RoomRandomizer(final ArrayList<Room> pRooms)
    {
        if (this.aSeed == null)
        {
            this.aRandom = new Random();
        }
        else
        {
            this.aRandom = new Random(this.aSeed);
        }
        this.aTabRoom = new Room[pRooms.size()];
        this.aTabRoom = pRooms.toArray(this.aTabRoom);
    }

    /**
     * Retourne une pièce aléatoire
     */
    public Room nextRoom()
    {
        if (this.aSeed != null)
            this.aRandom = new Random(this.aSeed );
        return this.aTabRoom[aRandom.nextInt(this.aTabRoom.length)];
    }
    
    /**
     * Mutateur pour définir le seed
     */
    public static void setSeed(final Long pSeed)
    {
        RoomRandomizer.aSeed = pSeed;
    }
}
