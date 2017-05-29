package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;

/**
 * Classe de la commande help
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class HelpCommand extends Command
{
    /**
     * Constructeur de la classe HelpCommand
     */
    public HelpCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande help
     * @param player Un objet Player
     * @return true
     */
    public boolean execute(Player player)
    {
        GameEngine.gui.println("You are lost. You are alone.");
        GameEngine.gui.println("You wander around at the university.");
        GameEngine.gui.println("Your command words are:");
        GameEngine.gui.println(GameEngine.aParser.getCommandList() + "\n");
        return true;
    }
}
