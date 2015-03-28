package logic;

import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Hashtable;

import java.util.logging.Logger;
import java.util.logging.Level;
import storage.Memory;
import application.Task;

/**
 * The main component that takes charge of deciding which 
 * handlers to call and execute
 * 
 * @author A0114463M
 */
public class LogicController {
    private static LogicController logicController;

    private static final Logger logger = 
            Logger.getLogger(LogicController.class.getName());
    private ArrayList<Task> taskList = new ArrayList<Task>();
    private CommandHandler[] handlers = {new EditTimeHandler(),
                                         new EditDescriptionHandler(),
                                         new UndoHandler(),
                                         new AddHandler(),
                                         new ClearHandler(),
                                         new DeleteHandler(),
                                         new EditHandler(),
                                         new ExitHandler(),
                                         new MarkHandler(),
                                         new SetLocationHandler(),
                                         new ShowHandler()};

    private Hashtable<String, CommandHandler> handlerTable = 
            new Hashtable<String, CommandHandler>();

    private LogicController() {
        logger.entering(getClass().getName(), "Initiating LogicController");
        taskList = new ArrayList<Task>(Memory.getInstance().getTaskList());
        initializeHandlers();
    }


    public static LogicController getInstance() {
        if (logicController == null) {
            logicController = new LogicController();
        }
        return logicController;
    }

    /**
     * Take the input from user from UI and call respective
     * handlers. Return the feedback to UI after each execution
     * @param userCommand
     * @return - feedback to user
     */
    public String executeCommand(String userCommand) {
        String command = userCommand.split(" ")[0];
        
        if (!handlerTable.containsKey(command)) {
            return "Unknown command!\n";
        }
        
        CommandHandler handler = handlerTable.get(command);
        if (handler instanceof UndoableCommandHandler) {
            handler = handler.getNewInstance();
        }
        
        String parameter = userCommand.replaceFirst(Pattern.quote(command), "").trim();
        return handler.execute(command, parameter, taskList);
    }

    /**
     * associate the aliases of each handlers to its owner
     * such that correct handlers can be invoked for execution
     * conflicting aliases will log error
     */
    private void initializeHandlers() {
        for (CommandHandler handler: handlers) {
            ArrayList<String> aliases = handler.getAliases();
            for (String cmd: aliases) {
                if (handlerTable.containsKey(cmd)) {
                    logger.log(Level.INFO, "conflicting command "+ cmd);
                }
                else {
                    handlerTable.put(cmd, handler);
                }
            }
        }
    }

    /**
     * return the taskList in LogicController
     * @return 
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }

}
