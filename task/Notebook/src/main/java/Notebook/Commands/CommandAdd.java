package Notebook.Commands;

import Notebook.NotebookStaff.NotebookProvider;

public class CommandAdd implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private String title;
  private String text;
  private String authorName;
  private String authorSurname;
  private int notebookID;

  public CommandAdd(String title, String text, String authorName, String authorSurname,
      int notebookID) {
    this.title = title;
    this.text = text;
    this.authorName = authorName;
    this.authorSurname = authorSurname;
    this.notebookID = notebookID;
  }

  public void Execute() {
    notebookProvider.addNote(notebookID, title, text, authorName, authorSurname);
  }
}
