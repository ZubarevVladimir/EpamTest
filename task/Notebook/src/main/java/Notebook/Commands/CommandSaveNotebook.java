package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;
import java.util.Scanner;

/**
 * Contains method for execute and undo command savenotebook.
 */
public class CommandSaveNotebook implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private String savePath;

  public CommandSaveNotebook(String savePath) {
    this.savePath = savePath;
  }

  /**
   * Call provider for save notebook from savepath file.
   */
  public void execute() {
    notebookProvider.saveNotebook(savePath);
  }

  /**
   * Undo command savenotebook.
   *
   * @return List<ICommand> - stack without last command savenotebook.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size() - 1);
    return manager.getCommandList();
  }
}
