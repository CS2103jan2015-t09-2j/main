package application;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class TaskList {

	private List<String> taskList = new ArrayList<String>();
	private int size = 0;
	
	public TaskList() {
		size = 0;
	}

	/**
	 * insert a new task to the list, returns true if successfully
	 * added
	 * 
	 * @param newTask - new task created
	 * @return true - if the operation is success.
	 */
	public boolean addTask(String newTask) {
		size = size + 1;
		return taskList.add(newTask);			
	}

	/**
	 * try to remove a task by index from the list
	 * 
	 * @param index - index of task want to be deleted
	 * @return removedTask - deleted Task
	 * @throws IndexOutOfBoundsException - if index if out of range of the list
	 */
	public String deleteTask(int index) throws IndexOutOfBoundsException {
		String removedTask = new String();
		try {
			removedTask = taskList.remove(index);
			size--;
		} catch (IndexOutOfBoundsException iob) {
			return null;
		}
		return removedTask;
	}

	/**
	 * search the list by a keyword
	 * 
	 * @param keyword
	 * @return result arraylist containing the index that contains the keyword
	 */
	/*
	public ArrayList<Integer> searchTask(String keyword) {
		ArrayList<Integer> foundTaskIndex = new ArrayList<Integer>();
		int indexCounter = 1;
		for (TaskData task: taskList) {
			if (task.getDescription().contains(keyword)) {
				foundTaskIndex.add(indexCounter);
			}
			indexCounter++;
		}
		return foundTaskIndex;
	}
	*/
	
	/**
	 * display the tasks in the list
	 * @return
	 */
	public String showTask(int index) {
		return taskList.get(index);
	}
	
	public void editTask(int index, String newTask) {
		taskList.remove(index);
		taskList.add(newTask);
	}
	
	public int getSize() {
		return size;
	}
}
