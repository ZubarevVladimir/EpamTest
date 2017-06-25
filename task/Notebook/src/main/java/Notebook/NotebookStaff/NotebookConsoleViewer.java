package Notebook.NotebookStaff;

import Notebook.Notebook.Note;
import Notebook.Notebook.Notebook;

/**
 * Contains methods for print notes in notebook.
 */
public class NotebookConsoleViewer {

  private Notebook notebook;

  public NotebookConsoleViewer(Notebook notebook) {
    this.notebook = notebook;
  }

  /**
   * Print all notes in notebook.
   */
  public void print() {
    System.out.println("Notebook id: " + notebook.getId() + ", " +
        "Notebook title: " + notebook.getTitle() + ", " + notebook.getAuthor().toString());
    for (Note listsNote : notebook.getNoteList()) {
      System.out.println("Note: " + listsNote.toString());
    }
  }
}