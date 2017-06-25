package Notebook.Commands;

import Notebook.NotebookStaff.NotebookProvider;

public class CommandSetSource implements ICommand {

  private NotebookProvider notebookProvider = NotebookProvider.getNotebookProvider();
  private String typeDAO;

  public CommandSetSource(String typeDAO) {
    this.typeDAO = typeDAO;
  }

  public void Execute() {
    notebookProvider.setDAOType(typeDAO);
  }
}