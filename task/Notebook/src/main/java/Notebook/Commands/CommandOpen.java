package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;

/**
 * Contains method for execute and undo command open.
 */
public class CommandOpen implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private int notebookID;

  public CommandOpen(int notebookID) {
    this.notebookID = notebookID;
  }

  /**
   * Call provider for open notebook by id.
   */
  public void execute() {
    notebookProvider.openNotebook(notebookID);
  }

  /**
   * Undo command open.
   *
   * @return List<ICommand> - stack without last command open.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size() - 1);
    return manager.getCommandList();
  }
}
