package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_item.Beamer;

/**
 * Classe de la commande charge
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class ChargeCommand extends Command
{
    /**
     * Constructeur de la classe ChargeCommand
     */
    public ChargeCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande charge
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if(player.findItem("beamer") == null)
        {
            GameEngine.gui.println("You need the beamer to charge.");
            return false;
        }
        
        Beamer vBeamer = (Beamer) player.findItem("beamer");
        GameEngine.gui.println("You save the current room with your beamer.");
        vBeamer.setCharged(true);
        vBeamer.setRoom(player.getCurrentRoom());
        return false;
    }
}
