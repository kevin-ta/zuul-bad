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
     * Constructeur par defaut
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        validCommands.put("go", CommandWord.GO);
        validCommands.put("aller", CommandWord.GO);
        validCommands.put("quit", CommandWord.QUIT);
        validCommands.put("quitter", CommandWord.QUIT);
        validCommands.put("help", CommandWord.HELP);
        validCommands.put("aider", CommandWord.HELP);
        validCommands.put("look", CommandWord.LOOK);
        validCommands.put("eat", CommandWord.EAT);
        validCommands.put("back", CommandWord.BACK);
        validCommands.put("test", CommandWord.TEST);
        validCommands.put("take", CommandWord.TAKE);
        validCommands.put("drop", CommandWord.DROP);
        validCommands.put("items", CommandWord.ITEMS);
    } // CommandWords()

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand(final String pString)
    {
        return validCommands.containsKey(pString);
    } // isCommand()
    
    /**
     * Affiche tous les commandes valides
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
} // CommandWords