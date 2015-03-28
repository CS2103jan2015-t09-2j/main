package ui;

import java.util.Scanner;

import logic.LogicController;

public class CommandLineInterface {

	private static final String COMMAND_MESSAGE = new String("Command: ");
	private static final String WELCOME_MESSAGE = new String( "Welcome to TaskManager!\n");
	private static final String GOODBYE_MESSAGE = new String("GoodBye!\n");
	private Scanner scanner;

	public CommandLineInterface(){
	} 	

	/**
	 * Scan the user input and execute the command.
	 */
	public void processUserInput(){
		String userCommand, message;
		scanner = new Scanner(System.in);
		LogicController commandHandler = LogicController.getInstance();
		
		TaskListUI taskListUI = new TaskListUI(commandHandler.getTaskList());
		taskListUI.showTask();
	
		printMessageToUser(String.format(WELCOME_MESSAGE));

		while (true) {
		    clearConsole();
			printMessageToUser(String.format(COMMAND_MESSAGE));
			userCommand = scanner.nextLine();
			message = commandHandler.executeCommand(userCommand);
			if (message == null) {
				printMessageToUser(GOODBYE_MESSAGE);
				System.exit(0);
			}			
			printMessageToUser(message);
			taskListUI.showTask();
		}
	}

	/**
	 * Print all of the message to the user
	 * @param message
	 */
	public void printMessageToUser(String message){
		System.out.println(message);
	}

	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
}
