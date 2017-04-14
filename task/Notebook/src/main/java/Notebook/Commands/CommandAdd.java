package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.List;
import java.util.Scanner;

/**
 * Contains method for execute and undo command add.
 */
public class CommandAdd implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  String title;
  String text;
  String authorName;
  String authorSurname;

  public CommandAdd(String title, String text, String authorName, String authorSurname) {
    this.title = title;
    this.text = text;
    this.authorName = authorName;
    this.authorSurname = authorSurname;
  }

  /**
   * Call provider for add note in current notebook.
   */
  public void execute() {
    notebookProvider.addNote(title, text, authorName, authorSurname);
  }

  /**
   * Undo command add.
   * @return List<ICommand> - stack without last command add.
   */
  public List<ICommand> undo() {
    notebookProvider.deleteLastNote();
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size() - 1);
    return manager.getCommandList();
  }
}
