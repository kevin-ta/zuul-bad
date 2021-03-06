package pkg_commands;

import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class Parser 
{
    private CommandWords aValidCommands;

    /**
     * Constructeur de la classe Parser qui cree les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
    }

    /**
     * Get a new command from the user. The command is read by parsing the 'inputLine'.
     * @param inputLine A string containing the inputline
     * @return A new instantiated Command object
     */
    public Command getCommand(String inputLine) 
    {
        //String inputLine = "";   // will hold the full input line
        String word1;
        String word2;

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
        
        Command command = this.aValidCommands.get(word1);
        if(command != null) {
            command.setSecondWord(word2);
        }
        return command;
    }
    
    /**
     * Fonction retournant une chaine de caracteres contenant la liste des commandes disponibles
     * @return Une chaine de caracteres contenant la liste des commandes disponibles
     */
    public String getCommandList()
    {
        return aValidCommands.getCommandList();
    }
}