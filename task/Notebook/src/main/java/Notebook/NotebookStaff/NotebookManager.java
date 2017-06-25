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

  private NotebookManager() {
  }

  public static NotebookManager getNotebookManager() {
    if (manager == null) {
      manager = new NotebookManager();
    }
    return manager;
  }

  /**
   * Initialize command according to given string and execute it.
   *
   * @param commandParameters command which need execute.
   */
  public void executeCommand(String commandParameters) {
      CommandCreator creator = new CommandCreator();
      command = creator.getCommand(commandParameters);
      command.Execute();
  }
}
