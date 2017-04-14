package Notebook.Notebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains notes and methods for work with it.
 */
public class Notebook {

  private int id;
  private String title;
  private Author author;
  private List<Note> noteList = new ArrayList<>();
  private IDGenerator idGenerator = IDGenerator.getIDGenerator();

  public Notebook(int id, String title, String authorName, String authorSurname) {
    this.id = id;
    this.author = new Author(authorName, authorSurname);
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Author getAuthor() {
    return author;
  }

  public List<Note> getNoteList() {
    return noteList;
  }

  /**
   * Add note to notebook.
   *
   * @param title note title.
   * @param text note text.
   */
  public void addNote(String title, String text, String authorName, String authorSurname) {
    noteList.add(new Note(idGenerator.getID(), title, text, authorName, authorSurname));
  }

  /**
   * Delete note with given id.
   *
   * @param id id deleted note.
   */
  public void deleteNote(int id) {
    noteList.remove(id);
  }

  public void deleteLastNote() {
    noteList.remove(noteList.size() - 1);
  }
}
