/**
 * Classe gerant la partie commande du jeu
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;

    /**
     * Constructeur de la classe Command
     * Une commande est composeee d'un premier mot et eventuellement d'un second mot
     * @param pCommandWord Un objet CommandWord qui represente le premier mot
     * @param pSecondWord  Un objet CommandWord qui represente le second mot
     */
    public Command(final CommandWord pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord  = pSecondWord;
    }
    
    /**
     * Accesseur permettant d'acceder au premier mot de la commande
     * @return Un objet CommandWord
     */
    public CommandWord getCommandWord()
    {
        return this.aCommandWord;
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
     * Teste si la commande possede un second mot
     * @return True si la commande possede un second mot sinon false
     */
    public boolean hasSecondWord()
    {
        return (aSecondWord != null);
    }
    
    /**
     * Teste si le premier mot de la commande est inconnue
     * @return True si le premier mot de la commande est inconnu sinon false
     */
    public boolean isUnknown()
    {
        return (aCommandWord == CommandWord.UNKNOWN);
    }
}
