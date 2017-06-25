package Notebook.Commands;

import Notebook.NotebookStaff.NotebookProvider;

public class CommandPrintNotebooks implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();

  public void Execute() {
    notebookProvider.printNotebookList();
  }

}
