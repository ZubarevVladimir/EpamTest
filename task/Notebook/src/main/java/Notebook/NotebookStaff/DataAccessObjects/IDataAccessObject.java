package Notebook.NotebookStaff.DataAccessObjects;

import Notebook.Notebook.Note;
import Notebook.Notebook.Notebook;
import java.util.List;

public interface IDataAccessObject {

  Notebook loadNotebook(int notebookID);

  List<Notebook> loadNotebooks();

  void addNotebook(Notebook notebook);

  void saveNotebooks(List<Notebook> notebooksList);

  void deleteNotebook(int notebookID);

  void deleteNote(int noteID);

  void addNote(int notebookID, String title, String text, String authorName,
      String authorSurname);
}
