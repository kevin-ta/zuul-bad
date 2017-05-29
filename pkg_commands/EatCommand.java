package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_item.Item;

/**
 * Classe de la commande eat
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class EatCommand extends Command
{
    /**
     * Constructeur de la classe EatCommand
     */
    public EatCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande eat
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if (!this.hasSecondWord())
        {
            GameEngine.gui.println("You have eaten now and you are not hungry any more.\n");
            return false;
        }
        else if (this.getSecondWord().equals("cookie"))
        {
            Item item = player.findItem(this.getSecondWord());
            if (item != null)
            {
                player.removeItem(item);
                player.setMaxWeight(10.0);
                GameEngine.gui.println("You have eaten the magic cookie.\n");
                GameEngine.gui.println("You have set the maximum weight of your inventory to 10kg.\n");
                return false;
            }
            GameEngine.gui.println("I don't understand.\n");
        }
        else
        {
            GameEngine.gui.println("I don't understand.\n");
        }
        return false;
    }
}
