package pkg_character;

import pkg_room.Room;

/**
 * Classe permettant de creer un MovingCharacter
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class MovingCharacter extends Character
{
    private String aName;
    private String aDialogue;
    private Room aNextRoom;

    /**
     * Constructeur de la classe MovingCharacter
     * @param pName Le nom du Character
     * @param pDialogue Le dialogue du Character
     * @param pNextRoom La prochaine piece du Character
     */
    public MovingCharacter(final String pName, final String pDialogue, final Room pNextRoom)
    {
        super(pName, pDialogue);
        this.aNextRoom = pNextRoom;
    }

    /**
     * Accesseur permettant d'acceder à la prochaine pièce du Character
     * @return Un objet Room représentant la prochaine pièce du Character
     */
    public Room getNextRoom()
    {
        return this.aNextRoom;
    }
}
