package pkg_room;

import pkg_character.*;
import pkg_item.Item;
import pkg_item.ItemList;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Classe permettant de gerer les pieces du jeu
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> exits;
    private String imageName;
    private ItemList items;
    private CharacterList characters;
    
    /**
     * Constructeur de la classe Game
     * Il permet d'initialiser un objet piece et la HashMap des sorties possibles
     * @param pDescription Le nom de la piece
     * @param image Le nom du fichier image
     */
    public Room(final String pDescription, final String image)
    {
        this.aDescription = pDescription;
        this.exits = new HashMap<String, Room>();
        this.imageName = image;
        this.items = new ItemList();
        this.characters = new CharacterList();
    }

    /**
     * Accesseur qui retourne la sortie
     * @param pDirection Une direction
     * @return La valeur de la cle pDirection dans la hasmap exits sinon null
     */
    public Room getExit(final String pDirection)
    {
        return this.exits.get(pDirection);
    }
    
    /**
     * Fonction retournant une chaine de caracteres contenant la liste des sorties
     * @return Une chaine de caracteres contenant la liste des sorties
     */
    private String getExitString()
    {
        String vReturnString = "Exits:";
        Set<String> keys = exits.keySet();
        for (String exit : keys)
        {
            vReturnString += " " + exit;
        }
        return vReturnString;
    }
    
    /**
     * Cree une sortie dans une direction donnee
     * @param pDirection La direction de la sortie
     * @param pNeighbor Le nom de la piece voisine correspondant a cette sortie
     */
    public void setExit(final String pDirection, final Room pNeighbor)
    {
        this.exits.put(pDirection, pNeighbor);
    }
    
    /**
     * Accesseur retournant une chaine de caracteres contenant la description de la piece
     * @return Une chaine de caracteres contenant la description de la piece
     */
    public String getLongDescription()
    {
        return "Vous etes " + this.aDescription + "\n"  + getExitString() + "\n" + items.getItemString() + "\n" + getCharacterString();
    }
    
    /**
     * Accesseur qui retourne la direction de la piece
     * @param pRoom Un objet Room
     * @return une chaine de caracteres contenant la direction de la piece sinon null
     */
    public String getDirection(final Room pRoom)
    {
        String direction = null;
        for (String key : exits.keySet())
        {
            if (pRoom.equals(exits.get(key)))
            {
                direction = key;
                break;
            }
        }
        return direction;
    }
    
    /**
     * Return a string describing the room's image name
     * @return A string describing the room's image name
     */
    public String getImageName()
    {
        return this.imageName;
    }
    
    /**
     * Add an item in the list items
     * @param item An item object
     */
    public void addItem(Item item)
    {
        this.items.addItem(item);
    }
    
    /**
     * Remove an item in the list items
     * @param item An item object
     */
    public void removeItem(Item item)
    {
        this.items.removeItem(item);
    }
    
    /**
     * Find an item in the list items
     * @param item An item object
     * @return An Item object or null
     */
    public Item findItem(String item)
    {
        return this.items.findItem(item);
    }
    
    /**
     * @return all the items present in a list
     */
    public String getItemString()
    {
        return this.items.getItemString();
    }
    
    /**
     * Add a character in the list characters
     * @param character A character object
     */
    public void addCharacter(pkg_character.Character character)
    {
        this.characters.addCharacter(character);
    }
    
    /**
     * Remove a character in the list characters
     * @param character A character object
     */
    public void removeCharacter(pkg_character.Character character)
    {
        this.characters.removeCharacter(character);
    }

    /**
     * Find a character in the list characters
     * @param character A character
     * @return A character object or null
     */
    public pkg_character.Character FindCharacter(String character)
    {
        return this.characters.findCharacter(character);
    }

    /**
     * @return all the characters present in a list
     */
    public String getCharacterString()
    {
        return this.characters.getCharacterString();
    }
}
