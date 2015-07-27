/**
 * Classe qui gère la partie commande du jeu
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructeur de la classe Command
     * Une commande est composéee d'un premier mot et éventuellement d'un second mot
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord  = pSecondWord;
    }
    
    /**
     * Accesseur qui retourne le premier mot de la commande
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    }
    
    /**
     * Accesseur qui retourne le second mot de la commande
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }
    
    /**
     * Teste si la commande possède un second mot
     */
    public boolean hasSecondWord()
    {
        return getSecondWord() != null;
    }
    
    /**
     * Teste si la commande est inconnue
     */
    public boolean isUnknown()
    {
        return getCommandWord() == null;
    }
} // Command
