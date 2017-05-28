/**
 * This class is an abstract superclass for all command classes in the game.
 * Each user command is implemented by a specific command subclass.
 *
 * Objects of class Command can store an optional argument word (a second
 * word entered on the command line). If the command had only one word, 
 * then the second word is <null>.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public abstract class Command
{
    private String aSecondWord;

    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null. The command word should be null to
     * indicate that this was a command that is not recognised by this game.
     */
    public Command()
    {
        this.aSecondWord  = null;
    }
    
    /**
     * Accesseur permettant d'acceder au second mot de la commande
     * @return Un objet CommandWord
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }
    
    /**
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String secondWord)
    {
        this.aSecondWord = secondWord;
    }
    
    /**
     * Teste si la commande possede un second mot
     * @return True si la commande possede un second mot sinon false
     */
    public boolean hasSecondWord()
    {
        return (aSecondWord != null);
    }
    
    /**
     * Execute this command. A flag is returned indicating whether
     * the game is over as a result of this command.
     * 
     * @return True, if game should exit; false otherwise.
     */
    public abstract boolean execute(Player player);
}
