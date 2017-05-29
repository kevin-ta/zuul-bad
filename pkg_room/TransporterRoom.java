package pkg_room;

import pkg_game.GameEngine;

/**
 * Classe qui permet de creer une piece avec des sorties aleatoires
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class TransporterRoom extends Room
{
    /**
     * Constructeur de la classe RoomRandomizer
     * @param pDescription Le nom de la piece
     * @param pImage Le nom du fichier image
     */
    public TransporterRoom(final String pDescription, final String pImage)
    {
        super(pDescription, pImage);
    }

    /**
     * Fonction permettant de retourner une sortie aleatoire
     * @param pDirection Une direction
     * @return Un objet Room aleatoire
     */
    public Room getExit(final String pDirection)
    {
        return this.findRandomRoom();
    }
    
    /**
     * Fonction permettant de retourner une piece aleatoire
     * @return Un objet Room aleatoire
     */
    public Room findRandomRoom()
    {
        RoomRandomizer random = new RoomRandomizer(GameEngine.getRooms());
        return random.nextRoom();
    }
}
