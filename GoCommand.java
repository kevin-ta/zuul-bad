/**
 * Classe de la commande go
 * 
 * @author Kevin Ta
 * @version 2015 - 2016
 */
public class GoCommand extends Command
{
    /**
     * Constructeur de la classe GoCommand
     */
    public GoCommand()
    {
    }
    
    /**
     * Fonction permettant d'executer la commande go
     * @param player Un objet Player
     * @return false
     */
    public boolean execute(Player player)
    {
        if (!this.hasSecondWord())
        {
            GameEngine.gui.println("Go where ?");
            return false;
        }
        String vDirection = this.getSecondWord();
        Room vNextRoom = player.getCurrentRoom().getExit(vDirection);
        if (vNextRoom == null)
        {
            GameEngine.gui.println("There is no door !");
        }
        else
        {
            GameEngine.roomHistory.push(player.getCurrentRoom());
            player.changeRoom(vNextRoom);
            GameEngine.gui.println(player.getCurrentRoom().getLongDescription() + "\n");
            if(player.getCurrentRoom().getImageName() != null)
                GameEngine.gui.showImage(player.getCurrentRoom().getImageName());
        }
        return false;
    }
}
