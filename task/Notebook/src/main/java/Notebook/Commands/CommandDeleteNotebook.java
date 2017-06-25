package Notebook.Commands;

import Notebook.NotebookStaff.NotebookProvider;

public class CommandDeleteNotebook implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private int notebookID;

  public CommandDeleteNotebook(int notebookID){
    this.notebookID = notebookID;
  }

  public void Execute() {
    notebookProvider.deleteNotebook(notebookID);
  }

}
