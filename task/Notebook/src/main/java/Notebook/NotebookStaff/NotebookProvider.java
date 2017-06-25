package Notebook.NotebookStaff;


import Notebook.Notebook.IDGenerator;
import Notebook.Notebook.Notebook;
import Notebook.NotebookStaff.DataAccessObjects.IDataAccessObject;
import Notebook.NotebookStaff.DataAccessObjects.JsonAccessObject;
import Notebook.NotebookStaff.DataAccessObjects.MySQLAccessObject;

public class NotebookProvider {

  private static NotebookProvider provider;
  private IDataAccessObject dataObject;
  private IDGenerator generator = IDGenerator.getIDGenerator();

  private NotebookProvider() {
  }

  public static NotebookProvider getNotebookProvider() {
    if (provider == null) {
      provider = new NotebookProvider();
    }
    return provider;
  }

  public void setDAOType(String typeDAO) {
    if (typeDAO.equalsIgnoreCase("json")) {
      dataObject = new JsonAccessObject();
    } else if (typeDAO.equalsIgnoreCase("mysql")) {
      dataObject = new MySQLAccessObject();
    }
  }

  public void addNote(int notebookID, String title, String text, String authorName,
      String authorSurname) {
    dataObject.addNote(notebookID, title, text, authorName, authorSurname);
  }

  public void deleteNotebook(int id) {
    dataObject.deleteNotebook(id);
  }

  public void deleteNote(int id) {
    dataObject.deleteNote(id);
  }

  public void printNotebookList() {
    for (Notebook notebook : dataObject.loadNotebooks()) {
      System.out.println("Notebook id: " + notebook.getId() + ", " +
          "Notebook title: " + notebook.getTitle() + ", " + notebook.getAuthor().toString());
    }
  }

  public void printNotebook(int id) {
    new NotebookConsoleViewer(dataObject.loadNotebook(id)).print();

  }

  public void createNotebook(String title, String authorName, String authorSurname) {
    dataObject.addNotebook(new Notebook(generator.getID(), title, authorName, authorSurname));
  }
}