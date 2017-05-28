import java.util.HashMap;
import java.util.Set;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class CommandWords
{
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructeur de la classe CommandWords
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Verifie si une chaine de caractere donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une commande valide, false sinon
     */
    public boolean isCommand(final String pString)
    {
        return validCommands.containsKey(pString);
    }
    
    /**
     * Affiche tous les commandes valides
     * @return Une chaine de caractere contenant la liste des commandes
     */
    public String getCommandList() {
        String vCommandList = new String();
        Set<String> keys = validCommands.keySet();
        for(String commands : keys) {
            vCommandList += " " + commands;
        }
        return vCommandList;
    }
    
    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
}