package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_item.Beamer;
import pkg_room.Room;

/**
 * Classe de la commande teleport
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class TeleportCommand extends Command
{
    /**
     * Constructeur de la classe TeleportCommand
     */
    public TeleportCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande teleport
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if(player.findItem("beamer") == null)
        {
            GameEngine.gui.println("You need the beamer to teleport.");
            return false;
        }
        
        Beamer vBeamer = (Beamer) player.findItem("beamer");
    
        if (vBeamer.getCharged())
        {
            Room vRoom = vBeamer.getRoom();
            if (!vRoom.equals(player.getCurrentRoom()))
            {
                GameEngine.gui.println("You are using the beamer.");
                player.changeRoom(vRoom);
                vBeamer.setCharged(false);
                GameEngine.roomHistory.clear();
                GameEngine.roomHistory.push(player.getCurrentRoom());
                GameEngine.gui.println(player.getCurrentRoom().getLongDescription() + "\n");
                if(player.getCurrentRoom().getImageName() != null)
                    GameEngine.gui.showImage(player.getCurrentRoom().getImageName());
            }
            else
            {
                GameEngine.gui.println("You are already in the charged room.");
            }
        }
        else
        {
            GameEngine.gui.println("You need to charge to beamer.");
        }
        return false;
    }
}
