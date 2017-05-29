package pkg_character;

import java.util.ArrayList;

/**
 * Classe permettant de gerer une liste de Characters
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class CharacterList
{
    private ArrayList<Character> aCharacters;

    /**
     * Constructeur de la classe CharacterList
     */
    public CharacterList()
    {
        this.aCharacters = new ArrayList<Character>();
    }
    
    /**
     * Fonction permettant d'ajouter un Character
     * @param pCharacter Un objet Character
     */
    public void addCharacter(Character pCharacter)
    {
        this.aCharacters.add(pCharacter);
    }
    
    /**
     * Fonction permettant de retirer un Character
     * @param character A character object
     */
    public void removeCharacter(Character character)
    {
        this.aCharacters.remove(character);
    }
    
    /**
     * Fonction permettant de retourner une chaine de caractere contenant la liste des Character
     * @return Une chaine de caractere contenant la liste des Character
     */
    public String getCharacterString()
    {
        String returnString = "Characters:";
        for(int i=0; i < aCharacters.size(); i++)
        {
            returnString += (" " + ((Character) aCharacters.get(i)).getName());    
        }
        return returnString;
    }
    
    /**
     * Fonction permettant de retrouver un Character
     * @return L'objet Character recherche sinon null
     */
    public Character findCharacter(String pCharacter)
    {
        for( int i=0; i < aCharacters.size(); i++)
        {
            Character chp = (Character) aCharacters.get(i);
            if (pCharacter.equals(chp.getName()))
            {
                return chp;
            }
        }
        return null;
    }
}
