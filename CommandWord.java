/**
 * Representations for all the valid command words for the game.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord
{
    GO("go"),
    QUIT("quit"),
    HELP("aider"),
    LOOK("look"),
    EAT("eat"),
    BACK("back"),
    TEST("test"),
    TAKE("take"),
    DROP("drop"),
    ITEMS("items"),
    CHARGE("charge"),
    TELEPORT("teleport"),
	ALEA("alea"),
    UNKNOWN("?");
    private String commandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * Fonction permettant de renvoyer la commande en tant que chaine de caracteres
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}