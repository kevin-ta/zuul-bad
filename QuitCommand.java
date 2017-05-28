/**
 * Classe de la commande quit
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class QuitCommand extends Command
{
    /**
     * Constructeur de la classe QuitCommand
     */
    public QuitCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande quit
     * @param player Un objet Player
     * @return true
     */
    public boolean execute(Player player)
    {
        GameEngine.gui.println("Thank you for playing.  Good bye.");
        GameEngine.gui.enable(false);
        return true;
    }
}
