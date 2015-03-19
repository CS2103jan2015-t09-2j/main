package application;

import java.util.ArrayList;

public class Task {
	
	private static final String[] dataField = {
		"Task Type",
		"Description",
		"Start Time",
		"End Time",
		"Deadline",
		"Status"
	};
	
	/****Attribute****/
	private String taskType;
	private String description;
	private String startDateTime;
	private String endDateTime;
	private String deadline;
	private String status;
	
	// dummy constructor delete in futre
	public Task() {
		
	}
	
	public Task(Task task) {
		this.taskType = task.getTaskType();
		this.description = task.getDescription();
		this.startDateTime = task.getStartDateTime();
		this.endDateTime = task.getEndDateTime();
		this.deadline = task.getDeadline();
		this.status = task.getStatus();
	}
	//(improvement to be made)
	//1. need to check validity of data
	//2. separate constructor for different task type

	public Task(String taskType, String description, String startDateTime, String endDateTime, String deadline, String status) {
		this.taskType = taskType;
		this.description = description;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.deadline = deadline;
		this.status = status;
	}
	
	public Task(ArrayList<String> taskInformation) {
		this.taskType = taskInformation.get(0);
		this.description = taskInformation.get(1);
		this.startDateTime = taskInformation.get(2);
		this.endDateTime = taskInformation.get(3);
		this.deadline = taskInformation.get(4);
		this.status = taskInformation.get(5);
	}
	public void setStartDateTime(String newStartDateTime) {
		startDateTime = newStartDateTime;
	}
	
	public void setEndDateTime(String newEndDateTime) {
		endDateTime = newEndDateTime;
	}
	
	public void setDeadline(String newDeadline) {
		deadline = newDeadline;
	}

	public void setStatus(String newStatus) {
		status = newStatus;
	}
	
	public void setTaskType(String newTaskType) {
		taskType = newTaskType;
	}
	
	public void setDescription(String newDescription) {
		description = newDescription;
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
	
	public String getDeadline(){
		return deadline;
	}
	
	public String getStatus(){
		return status;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean isDone() {
		if (status.equals("done")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public String toString() {
		String str = "";
		
		String[] dataField = {
			"Task Type",
			"Description",
			"Start Time",
			"End Time",
			"Deadline",
			"Status"
		};
		
		String[] data = {
			getTaskType(),
			getDescription(),
			getStartDateTime(),
			getEndDateTime(),
			getDeadline(),
			getStatus()
		};
		
		for (int i = 0; i < dataField.length; i++) {
			str += String.format("%-20s", dataField[i]) + ": " + String.format("%s", data[i]) + "\n";
		}
		
		return str;
	}
}
