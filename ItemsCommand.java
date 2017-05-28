/**
 * Classe de la commande items
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class ItemsCommand extends Command
{
    /**
     * Constructeur de la classe ItemsCommand
     */
    public ItemsCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande items
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        GameEngine.gui.println(player.getItemString());
        GameEngine.gui.println("Your inventory weighs " + player.getCurrentWeight() + " kg.\n");
        return false;
    }
}
