package Notebook.NotebookStaff;

import Notebook.CommandCreators.CommandCreator;
import Notebook.Commands.ICommand;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains method for executing command.
 */
public class NotebookManager {

  private static NotebookManager manager;
  private ICommand command;
  private List<ICommand> commandList = new ArrayList<>();

  private NotebookManager() {
  }

  public static NotebookManager getNotebookManager() {
    if (manager == null) {
      manager = new NotebookManager();
    }
    return manager;
  }

  /**
   * Call creator for create command according to given string and execute this command.
   * If given command is 'undo', undo last command.
   *
   * @param commandParameters command with parameters, which need execute.
   */
  public void executeCommand(String commandParameters) {
    if (!commandParameters.equals("undo")) {
      CommandCreator creator = new CommandCreator();
      command = creator.getCommand(commandParameters);
      command.execute();
      commandList.add(command);
    } else if (commandParameters.equals("undo")){
      manager.getCommandList().get(manager.getCommandList().size()-1).undo();
    }
  }

  public List<ICommand> getCommandList() {
    return commandList;
  }
}
