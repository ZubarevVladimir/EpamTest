package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;
import java.util.Scanner;

/**
 * Contains method for execute and undo command deletenote.
 */
public class CommandDeleteNote implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private int deletedID;

  public CommandDeleteNote(int deletedID) {
    this.deletedID = deletedID;
  }

  /**
   * Call provider for delete note by id.
   */
  public void execute() {
    notebookProvider.deleteNote(deletedID - 1);
  }

  /**
   * Undo command deletenote.
   *
   * @return List<ICommand> - stack without last command deletenote.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size() - 1);
    return manager.getCommandList();
  }

}
