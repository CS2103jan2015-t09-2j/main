/**
 * Construct by passing a TaskList to the constructor 
 * 
 * process each line of input given by user and calls different
 * handlers by different command given by user
 * and returns a feedback to ui
 */
package handler;

import application.TaskList;
import parser.CommandParser;
import database.Database;

public class CommandHandler {

	TaskList taskList = new TaskList();
	//Database db = new Database();
	
	public CommandHandler(TaskList taskList) {
		this.taskList = taskList;
		//db.createDatabase();
	}
	
	public String processCommand(String userInput) {
		CommandParser cp = new CommandParser();
		String userCommand = cp.determineCommandType(userInput);
		executeCommand(userCommand, userInput);
		
		return userCommand;
	}
	
	// dummy for now
	private String executeCommand(String command, String userInput) {
		String parameter = userInput.replace(command + " ", "");
		switch (command) {
			case "add":
				if (AddHandler.addTask(parameter, taskList)) {
					command = "Suceesfully added " + parameter;
				} else {
					command = "Failed to add " + parameter;
				}
				break;
			case "delete":
				String removedTask = DeleteHandler.deleteTask(parameter, taskList);
				if (removedTask == null) {
					command = "Please check your input";
				} else {
					System.out.println("Successfully removed " + removedTask);
				}
				break;
			case "show":
				if (taskList.getSize() == 0) {
					System.out.println("No task");
				} else {
					for (int i = 0; i < taskList.getSize(); i++) {		
						System.out.println(taskList.showTask(i));
					}
				}
				break;
			case "edit":
				
			default:
				break;
		}
		return "";
	}
}
