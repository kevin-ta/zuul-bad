package pkg_character;

import pkg_room.Room;

/**
 * Classe permettant de creer un Character
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class Character
{
    private String aName;
    private String aDialogue;

    /**
     * Constructeur de la classe Character
     * @param pName Le nom du Character
     * @param pDialogue Le dialogue du Character
     */
    public Character(final String pName, final String pDialogue)
    {
        this.aName = pName;
        this.aDialogue = pDialogue;
    }
    
    /**
     * Accesseur permettant d'acceder au nom du Character
     * @return Une chaine de caractere contenant le nom du Character
     */
    public String getName()
    {
        return this.aName;
    }
    
    /**
     * Accesseur permettant d'acceder au dialogue du Character
     * @return Une chaine de caractere contenant le dialogue du Character
     */
    public String getDialogue()
    {
        return this.aDialogue;
    }
    
    /**
     * Accesseur permettant d'acceder à la prochaine pièce du Character
     * @return null car seul un moving character peut bouger
     */
    public Room getNextRoom()
    {
        return null;
    }
}
