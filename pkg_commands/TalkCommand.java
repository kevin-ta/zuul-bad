package pkg_commands;

import pkg_character.Character;
import pkg_character.MovingCharacter;
import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_item.Item;
import pkg_room.Room;

/**
 * Classe de la commande talk
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class TalkCommand extends Command
{
    /**
     * Constructeur de la classe TalkCommand
     */
    public TalkCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande talk
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if(!this.hasSecondWord()) 
        {
            GameEngine.gui.println("Talk to who?\n");
            return false;
        }
        
        String name = this.getSecondWord();
        Character character = (player.getCurrentRoom()).FindCharacter(name);

        if (character != null)
        {
            String dialogue = character.getDialogue();
            GameEngine.gui.println(dialogue + "\n");
            Room room = character.getNextRoom();
            if(room != null && player.getCurrentRoom() != room)
            {
                character.getNextRoom().addCharacter(character);
                player.getCurrentRoom().removeCharacter(character);
                GameEngine.gui.println(character.getName() + " is moving\n");
            }
        }     
        else
        {
            GameEngine.gui.println("The character doesn't exist.\n");
        }
        return false;
    }
}
