package Notebook.Commands;

import Notebook.NotebookStaff.NotebookProvider;

public class CommandPrintNotebook implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private int id;

  public CommandPrintNotebook(int id) {
    this.id = id;
  }

  public void Execute() {
    notebookProvider.printNotebook(id);
  }

}
