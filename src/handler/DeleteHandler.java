package handler;

import parser.IndexParser;
import application.TaskList;

public class DeleteHandler {

	/**
	 * delete a task by index
	 * 
	 * @param indexOfDeletion - intended delete index
	 * @param taskList - task List
	 * @return - false if not a number or out of range
	 *  		 true for success remove
	 */
	public static String deleteTask(String indexOfDeletion, TaskList taskList) {
		IndexParser ip = new IndexParser();
		int index = ip.extractIndex(indexOfDeletion);
		if (index < 0) {
			return null;
		} else if (index > taskList.getSize()) {
			return null;
		} else {
			return taskList.deleteTask(index);
		}
	}
}
