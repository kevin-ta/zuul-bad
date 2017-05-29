package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_item.Item;

/**
 * Classe de la commande drop
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class DropCommand extends Command
{
    /**
     * Constructeur de la classe DropCommand
     */
    public DropCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande drop
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if(!this.hasSecondWord()) 
        {
            GameEngine.gui.println("Drop what?\n");
            return false;
        }     

        String name = this.getSecondWord();
        Item item = player.findItem(name);

        if (item != null)
        {
            double weight = item.getWeight();
            player.getCurrentRoom().addItem(item);
            player.removeItem(item);
            player.setMaxWeight(weight);
        } 
        else
        {
            GameEngine.gui.println("The item doesn't exist.\n");
        }
        return false;
    }
}
