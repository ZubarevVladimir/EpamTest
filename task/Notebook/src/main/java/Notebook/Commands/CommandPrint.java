package Notebook.Commands;

import Notebook.NotebookStaff.NotebookConsoleViewer;
import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;

/**
 * Contains method for execute and undo command print.
 */
public class CommandPrint implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  NotebookConsoleViewer viewer = new NotebookConsoleViewer(notebookProvider.getCurrentNotebook());

  /**
   * Call provider for print current notebook.
   */
  public void execute() {
    viewer.print();
  }

  /**
   * Undo command print.
   *
   * @return List<ICommand> - stack without last command print.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size());
    return manager.getCommandList();
  }
}
