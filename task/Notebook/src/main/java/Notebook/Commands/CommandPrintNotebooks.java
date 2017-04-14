package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;

/**
 * Contains method for execute and undo command printnotebooks.
 */
public class CommandPrintNotebooks implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();

  /**
   * Call provider for print information about all notebooks.
   */
  public void execute() {
    notebookProvider.printNotebookList();
  }

  /**
   * Undo command printnotebooks.
   * @return List<ICommand> - stack without last command printnotebooks.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size());
    return manager.getCommandList();
  }
}
