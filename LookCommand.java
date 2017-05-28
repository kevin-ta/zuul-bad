/**
 * Classe de la commande look
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class LookCommand extends Command
{
    /**
     * Constructeur de la classe LookCommand
     */
    public LookCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande look
     * @param player Un objet Player
     * @return true
     */
    public boolean execute(Player player)
    {
        GameEngine.gui.println(player.getCurrentRoom().getLongDescription() + "\n");
        return true;
    }
}
