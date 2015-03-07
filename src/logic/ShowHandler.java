package logic;


/**
 * showing all tasks in the taskList by passing no
 * parameters OR search for tasks containing the 
 * keyword
 */
public class ShowHandler {

	TaskList taskList = new TaskList();
	
	protected ShowHandler(TaskList taskList) {
		this.taskList = taskList;
	}
	
	/**
	 * show all contents in taskList
	 * 
	 * @param taskList - list to be shown
	 * @return String of all tasks, no task message will be shown if 
	 * 		   the list is empty
	 */
	protected String showTask() {
		String feedback = new String();
		if (taskList.getSize() == 0) {
			feedback = "There is no task.";
		}
		else {
			feedback = taskList.displayTask();
		}
		
		return feedback;
	}
	
	/**
	 * show tasks containing the keyword
	 * 
	 * @param index - arraylist storing tasks to be shown
	 * @param taskList - taskList to be shown
	 * @return formatted string of tasks, message if no task if found
	 */
	protected String showTask(String keyword) {
		String feedback = new String();
		feedback = taskList.searchTask(keyword);
		if (feedback.trim().equals("")) {
			return "No task containing " + keyword;
		}
		else {
			return feedback;
		}
	}
}