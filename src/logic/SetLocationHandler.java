//@author A0114463M
package logic;

import java.util.ArrayList;
import java.util.Arrays;

import application.Task;
import storage.DatabaseLocationChanger;

public class SetLocationHandler extends CommandHandler {

    private static final String INVALID_PATH_MESSAGE = "Invalid path!\n";
    private static final String NEW_LOCATION_MESSAGE = "The file is now saved to %1$s\n";
    private static final String HELP_MESSAGE = "%1$s <path>\n\t set the directory that tasks will be saved to\n";
    
    private ArrayList<String> aliases = new ArrayList<String>(
            Arrays.asList("setlocation", "saveto", "st"));
    @Override
    protected ArrayList<String> getAliases() {
        return aliases;
    }

    @Override
    protected String execute(String command, String parameter, ArrayList<Task> taskList) {
        DatabaseLocationChanger dlc = new DatabaseLocationChanger();
        String[] token = parameter.split(" ");
        if (isHelp(token)) {
            return getHelp(command);
        }
        
        if (dlc.setDatabaseLocation(parameter)) {
            return String.format(NEW_LOCATION_MESSAGE, parameter);
        }
        else {
            return INVALID_PATH_MESSAGE;
        }
   
    }

    private boolean isHelp(String[] token) {
        return token[0].toLowerCase().equals("help");
    }

    @Override
    public String getHelp(String command) {
        // TODO Auto-generated method stub
        return String.format(HELP_MESSAGE, command);
    }
    
}
