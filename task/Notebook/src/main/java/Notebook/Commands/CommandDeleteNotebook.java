package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;

/**
 * Contains method for execute and undo command deletenotebook.
 */
public class CommandDeleteNotebook implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private int notebookID;

  public CommandDeleteNotebook(int notebookID){
    this.notebookID = notebookID;
  }

  /**
   * Call provider for delete notebook by id.
   */
  public void execute() {
    notebookProvider.deleteNotebook(notebookID);
  }

  /**
   * Undo command add.
   * @return List<ICommand> - stack without last command add.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size()-1);
    return manager.getCommandList();
  }
}
