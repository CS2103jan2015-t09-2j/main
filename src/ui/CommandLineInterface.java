package ui;

import java.util.Scanner;

import application.TaskList;
import handler.CommandHandler;


public class CommandLineInterface {

	private static final String COMMAND_MESSAGE = new String("Command: \n");
	private static final String WELCOME_MESSAGE = new String( "Welcome to TaskManager!\n");

	public CommandLineInterface(){
	} 	

	public void userInput(){
		Scanner scanner = new Scanner(System.in);
		TaskList taskList = new TaskList();
		CommandHandler commandHandler = new CommandHandler(taskList);
		String userCommand, message;
		//get to display all file.
		//		DisplayHandler....
		printMessageToUser(String.format(WELCOME_MESSAGE));

		while (true) {
			printMessageToUser(String.format(COMMAND_MESSAGE));
			userCommand = scanner.nextLine();
			//System.out.println("UL: "+userCommand);
			message = commandHandler.processCommand(userCommand);
			//printMessageToUser(message);
		}
	}

	//print all of the different type of message using this method
	public void printMessageToUser(String message){
		System.out.println(message);
	}

	
}
