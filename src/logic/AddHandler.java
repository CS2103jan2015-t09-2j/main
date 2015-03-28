package logic;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;

import application.Task;

/**
 * CommandHandler for "add" function.
 * 
 * Adding tasks is achieved by "add [task information]"
 * New task included in parameter invokes the static method createNewTask
 * in CommandHandler abstract class through various parsers.
 * The new task is added to the memory 
 * 
 * @author A0114463M
 *
 */
class AddHandler extends UndoableCommandHandler {
    private static final String HELP_MESSAGE = "add <task information>\n\t add a new task to TaskManager\n";
    private static final String FATAL_ERROR_MESSAGE = "Fatal error! Unable to add Task";
    private static final String SUCCESS_ADD_MESSAGE = "Task \"%1$s\" is added\n";
    private ArrayList<String> aliases = new ArrayList<String>(Arrays.asList("add", "a", "new", "+"));
    private static final Logger addLogger = Logger.getLogger(AddHandler.class.getName());
    static Task newTask;
    
    @Override
    public ArrayList<String> getAliases() {
        // TODO Auto-generated method stub
        return aliases;
    }

    @Override
    protected String execute(String command, String parameter, ArrayList<Task> taskList) {
        String[] token = parameter.split(" ");
        if (isHelpOnly(token) || isEmptyParameter(parameter)) {
            return getHelp();
        }

        addLogger.entering(getClass().getName(), "Add non empty task");
        newTask = CommandHandler.createNewTask(parameter);
        // a non empty task is created
        assert (newTask != null);	
        if (memory.addTask(newTask)) {        
            updateTaskList(taskList);
            undoRedoManager.undo.push(this);
            addLogger.log(Level.FINE, "Add sucess");
            return String.format(SUCCESS_ADD_MESSAGE, newTask.getDescription());
        } 
        else {
            addLogger.log(Level.SEVERE, "Error adding new task!");
            throw new Error(FATAL_ERROR_MESSAGE);
        }	
    }



    /**
     * check if the argument user typed is empty
     * @param parameter
     * @return
     */
    private boolean isEmptyParameter(String parameter) {
        return parameter.trim().equals("");
    }

    /**
     * chech if user is looking for help
     * @param token
     * @return
     */
    private boolean isHelpOnly(String[] token) {
        return ((token.length == 1) && (token[0].toLowerCase().trim().equals("help")));
    }

    /**
     * update the taskList in CommandHandler
     */
    private void updateTaskList(ArrayList<Task> taskList) {
        taskList.clear();
        taskList.addAll(memory.getTaskList());
    }

    @Override
    public String getHelp() {
        return HELP_MESSAGE;
    }


    @Override
    void undo() {
    	memory.removeTask(newTask);
    }
    
    @Override
    public CommandHandler getNewInstance() {
        return new AddHandler();
    }
}
