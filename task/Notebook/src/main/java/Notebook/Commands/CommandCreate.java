package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;

/**
 * Contains method for execute and undo command create.
 */
public class CommandCreate implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private String title;
  private String authorName;
  private String authorSurname;

  public CommandCreate(String title, String authorName, String authorSurname) {
    this.authorName = authorName;
    this.authorSurname = authorSurname;
    this.title = title;
  }

  /**
   * Call provider for create empty notebook.
   */
  public void execute() {
    notebookProvider.createNotebook(title, authorName, authorSurname);
  }

  /**
   * Undo command create.
   * @return List<ICommand> - stack without last command create.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size() - 1);
    return manager.getCommandList();
  }
}

