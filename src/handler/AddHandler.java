/**
 *  handle adding a task to the task list
 *  and write the changes to database if adding is
 *  success
 */
package handler;

import application.TaskList;

public class AddHandler {

	/**
	 * add a task to the task list
	 * 
	 * @param taskInformation - parameter user given
	 * @param taskList
	 * @return true if successfully added, false is not supposed to be returned
	 */
	public static boolean addTask(String taskInformation, TaskList taskList) {
		// parsing the parameters of the taskData
		
		
		//TaskData newTask = new TaskData();
		if (taskList.addTask(taskInformation)) {
			/* it shall be i pass the new task to the database and database shall add
			 * accrodingly
			database.
			*/
			return true;
		} else {
			return false;
		}
	}
}
