package Notebook.Commands;

import Notebook.NotebookStaff.NotebookProvider;

public class CommandDeleteNote implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private int deletedID;

  public CommandDeleteNote(int deletedID) {
    this.deletedID = deletedID;
  }

  public void Execute() {
    notebookProvider.deleteNote(deletedID);
  }

}
