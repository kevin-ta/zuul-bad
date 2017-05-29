package pkg_commands;

import pkg_game.GameEngine;
import pkg_game.Player;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Classe de la commande test
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class TestCommand extends Command
{
    /**
     * Constructeur de la classe TestCommand
     */
    public TestCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande test
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if(!this.hasSecondWord())
        { 
            GameEngine.gui.println("What file ?"); 
            return false;
        } 
        String file = this.getSecondWord();
        Scanner test = null;
        try
        {
            test = new Scanner(new File(file));
        }
        catch(FileNotFoundException evt)
        {
            GameEngine.gui.println("The file " + file + " was not found.\n");
            return false;
        }
        while(test.hasNextLine())
        { 
            GameEngine.interpretCommand((String) test.nextLine());
        }
        test.close();
        return false;
    }
}
