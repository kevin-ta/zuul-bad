package pkg_room;

import java.util.Random;
import java.util.ArrayList;

/**
 * Classe qui permet de choisir une piece aleatoire
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class RoomRandomizer
{
    private static Long aSeed = null;
    private Random aRandom;
    private Room[] aTabRoom;

    /**
     * Constructeur de la classe RoomRandomizer
     * @param pRooms Une ArrayList contenant la liste des pieces
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
     * Fonction retournant une piece aleatoire
     * @return Un objet Room aleatoire
     */
    public Room nextRoom()
    {
        if (this.aSeed != null)
            this.aRandom = new Random(this.aSeed );
        return this.aTabRoom[aRandom.nextInt(this.aTabRoom.length)];
    }
    
    /**
     * Mutateur permettant de definir le seed
     * @param pSeed Un seed
     */
    public static void setSeed(final Long pSeed)
    {
        RoomRandomizer.aSeed = pSeed;
    }
}
