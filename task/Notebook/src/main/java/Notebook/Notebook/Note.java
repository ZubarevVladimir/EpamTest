package Notebook.Notebook;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Note {

  private int id;
  private String title;
  private String text;
  private Calendar date;
  private Author author;

  public Note(int id, String title, String text, String authorName, String authorSurname) {
    this.author = new Author(authorName, authorSurname);
    this.id = id;
    this.title = title;
    this.text = text;
    date = new GregorianCalendar();
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Note note1 = (Note) o;

    if (id != note1.id) {
      return false;
    }
    if (!title.equals(note1.title)) {
      return false;
    }
    return text.equals(note1.text);
  }

  @Override
  public String toString() {
    return author.toString() + ", " + "ID: " + id + ", Title: " + title + ", Text: " + text
        + ", Date: " + date.getTime().toString() + ".";
  }

  @Override
  public int hashCode() {
    int result = id ^ title.hashCode()+ author.hashCode();
    result = result + text.hashCode();
    return result;
  }
}
