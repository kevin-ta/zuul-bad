/**
 * Classe de la commande back
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class BackCommand extends Command
{
    /**
     * Constructeur de la classe BackCommand
     */
    public BackCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande back
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if (this.hasSecondWord())
        {
            GameEngine.gui.println("Back where ?");
            return false;
        }
        if (GameEngine.roomHistory.isEmpty())
        {
            GameEngine.gui.println("You can't back anymore");
        }
        else
        {
            Room vPreviousRoom = GameEngine.roomHistory.peek();
            String direction = player.getCurrentRoom().getDirection(vPreviousRoom);
            if(direction == null)
            {
                GameEngine.gui.println("You can't back, you are trapped inside");
                return false;
            }
            player.changeRoom(GameEngine.roomHistory.pop());
            GameEngine.gui.println(player.getCurrentRoom().getLongDescription() + "\n");
            if(player.getCurrentRoom().getImageName() != null)
                GameEngine.gui.showImage(player.getCurrentRoom().getImageName());
        }
        return false;
    }
}
