/**
 * TaskData stores the attributes of a task,
 * when a new task is created, the status is set to 
 * fault(uncompleted) by default;
 * 
 * Type of tasks shall be auto updated by whether 
 * startDateTime and endDateTime is null
 */
package application;

public class TaskData {
	/****Attribute****/
	private String taskType;
	private String description;
	private String startDateTime;
	private String endDateTime;
	private boolean status;
	
	// dummy constructor delete in futre
	public TaskData() {
		
	}

	/**
	 * construct a timed task with starting time and end time
	 * 
	 * @param description
	 * @param startDateTime - starting date & time
	 * @param endDateTime - ending date & time
	 */
	public TaskData(String description, String startDateTime, String endDateTime) {
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.status = false;
		this.taskType = "timed";
	}

	/**
	 * construct a deadline task with deadline only
	 * 
	 * @param description
	 * @param deadline
	 */
	public TaskData(String description, String deadline) {
		this.description = description;
		this.startDateTime = null;
		this.endDateTime = deadline;
		this.status = false;
		this.taskType = "deadline";
	}
	/**
	 * construct a floating task with desciption only
	 * 
	 * @param description
	 */
	public TaskData(String description) {
		this.description = description;
		this.startDateTime = null;
		this.endDateTime = null;
		this.status = false;
		this.taskType = "floating";
	}
	
	public void setStartDateTime(String newStartDateTime) {
		startDateTime = newStartDateTime;
	}
	
	public void setEndDateTime(String newEndDateTime) {
		endDateTime = newEndDateTime;
	}
	
	public void setDeadline(String newDeadline) {
		startDateTime = null;
		endDateTime = newDeadline;
	}

	public void setStatus(boolean newStatus) {
		status = newStatus;
	}
	
	public void setTasktype(String newTaskType) {
		taskType = newTaskType;
	}
	
	public String getTaskType() {
		return taskType;
	}
	
	public String getStartDateTime() {	
		return startDateTime;
	}
	
	public String getEndDateTime(){
		return endDateTime;
	}
	
	public String getDeadLine(){
		return endDateTime;
	}
	
	public boolean getStatus(){
		return status;
	}
	
	public String getDescription() {
		return description;
	}
	
}
