package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_room.RoomRandomizer;

/**
 * Classe de la commande alea
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class AleaCommand extends Command
{
    /**
     * Constructeur de la classe AleaCommand
     */
    public AleaCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande alea
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if(!this.hasSecondWord())
        {
            GameEngine.gui.println("Random enabled.");
            RoomRandomizer.setSeed(null);
        }
        else
        {
            try
            {
                RoomRandomizer.setSeed(Long.parseLong(this.getSecondWord(), 10));
            }
            catch (NumberFormatException E)
            {
                GameEngine.gui.println("Wrong seed.");
                return false;
            }
            
            GameEngine.gui.println("You changed the seed.");               
        }
        return false;
    }
}
