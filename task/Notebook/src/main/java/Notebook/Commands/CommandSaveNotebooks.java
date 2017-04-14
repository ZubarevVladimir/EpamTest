package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;

/**
 * Contains method for execute and undo command savenotebooks.
 */
public class CommandSaveNotebooks implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private String savePath;

  public CommandSaveNotebooks(String savePath) {
    this.savePath = savePath;
  }

  /**
   * Call provider for save notebooks from savepath file.
   */
  public void execute() {
    notebookProvider.saveNotebookList(savePath);
  }

  /**
   * Undo command savenotebooks.
   *
   * @return List<ICommand> - stack without last command savnotebooks.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size() - 1);
    return manager.getCommandList();
  }
}
