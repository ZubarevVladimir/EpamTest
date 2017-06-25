package Notebook.Commands;

import Notebook.NotebookStaff.NotebookProvider;

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

  public void Execute() {
    notebookProvider.createNotebook(title, authorName, authorSurname);
  }

}

