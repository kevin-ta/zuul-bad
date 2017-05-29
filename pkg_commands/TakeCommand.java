package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_item.Item;

/**
 * Classe de la commande take
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class TakeCommand extends Command
{
    /**
     * Constructeur de la classe TakeCommand
     */
    public TakeCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande take
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if(!this.hasSecondWord()) 
        {
            GameEngine.gui.println("Take what?\n");
            return false;
        }
        
        String name = this.getSecondWord();
        Item item = (player.getCurrentRoom()).findItem(name);

        if (item != null)
        {
            double weight = item.getWeight();
            if (player.getMaxWeight() - weight >= 0)
            {
                player.getCurrentRoom().removeItem(item);
                player.addItem(item);
                player.setMaxWeight(-weight);
            }
            else
            {
                GameEngine.gui.println("You can't take more.\n");
            }
        }     
        else
        {
            GameEngine.gui.println("The item doesn't exist.\n");
        }
        return false;
    }
}
