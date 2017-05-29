package pkg_commands;

import pkg_game.GameEngine;

/**
 * Representations for all the valid command words for the game.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public enum CommandWord
{
    GO("go", new GoCommand()),
    QUIT("quit", new QuitCommand()),
    HELP("aider", new HelpCommand()),
    LOOK("look", new LookCommand()),
    EAT("eat", new EatCommand()),
    BACK("back", new BackCommand()),
    TEST("test", new TestCommand()),
    TAKE("take", new TakeCommand()),
    DROP("drop", new DropCommand()),
    ITEMS("items", new ItemsCommand()),
    CHARGE("charge", new ChargeCommand()),
    TELEPORT("teleport", new TeleportCommand()),
	ALEA("alea", new AleaCommand()),
	TALK("talk", new TalkCommand()),
    UNKNOWN("?", null);
    private String commandString;
    private Command command;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandString The command string.
     * @param pCommand The Command class
     */
    CommandWord(String commandString, Command pCommand)
    {
        this.commandString = commandString;
        this.command = pCommand;
    }
    
    /**
     * Fonction permettant de renvoyer la commande en tant que chaine de caracteres
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
    
    /**
     * Gets the command
     *
     * @return The command
     */
    public Command getCommand()
    {
        return this.command;
    }
}