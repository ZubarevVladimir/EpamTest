package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;

/**
 * Contains method for execute and undo command loadnotebooks.
 */
public class CommandLoadNotebooks implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private String loadPath;

  public CommandLoadNotebooks(String openPath) {
    this.loadPath = openPath;
  }

  /**
   * Call provider for load all notebooks from loadpath file.
   */
  public void execute() {
    notebookProvider.loadNotebookList(loadPath);
  }

  /**
   * Undo command loadnotebooks.
   *
   * @return List<ICommand> - stack without last command add.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size()-1);
    return manager.getCommandList();
  }
}

