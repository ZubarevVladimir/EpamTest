package Notebook.NotebookStaff.DataAccessObjects;

import Notebook.Notebook.Note;
import Notebook.Notebook.Notebook;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonAccessObject implements IDataAccessObject {

  public Notebook loadNotebook(int notebookID) {
    for (Notebook notebook : loadNotebooks()) {
      if (notebook.getId() == notebookID) {
        return notebook;
      }
    }
    System.out.println("Incorrect ID");
    return null;
  }

  public void addNote(int notebookID, String title, String text, String authorName,
      String authorSurname) {
    Notebook updateNotebook = loadNotebook(notebookID);
    updateNotebook.addNote(title, text, authorName, authorSurname);
    deleteNotebook(notebookID);
    addNotebook(updateNotebook);
  }

  public List<Notebook> loadNotebooks() {
    List<Notebook> notebooksList = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("nb.json"))) {
      Type listType = new TypeToken<ArrayList<Notebook>>() {
      }.getType();
      notebooksList = new Gson().fromJson(reader, listType);
      return notebooksList;
    } catch (IOException ex) {
      System.out.println("Not found file");
    }
    return notebooksList;
  }

  public void deleteNotebook(int notebookID) {
    List<Notebook> notebooksList = loadNotebooks();
    Notebook delNotebook = new Notebook(1,"", "", "");
    for (Notebook notebook : notebooksList) {
      if (notebook.getId() == notebookID) {
        delNotebook = notebook;
      }
    }
    notebooksList.remove(delNotebook);
    saveNotebooks(notebooksList);
  }

  public void deleteNote(int noteID) {
    List<Notebook> notebooksList = loadNotebooks();
    for (Notebook notebook : notebooksList) {
      Note noteOne = new Note(0, "", "", "", "");
      for (Note note : notebook.getNoteList()) {
        if (note.getId() == noteID) {
          noteOne = note;
        }
      }
      notebook.deleteNote(noteOne);
    }
    saveNotebooks(notebooksList);
  }

  public void addNotebook(Notebook notebook) {
    String string;
    List<Notebook> notebookList;
    if (loadNotebooks() == null) {
      notebookList = new ArrayList<>();
      notebookList.add(notebook);
    } else {
      notebookList = loadNotebooks();
      notebookList.add(notebook);
    }
    string = new Gson().toJson(notebookList);
    try (FileWriter fileWriter = new FileWriter("nb.json", false)) {
      fileWriter.write(string);
    } catch (IOException ex) {
      System.out.println("Not found file");
    }
  }

  public void saveNotebooks(List<Notebook> notebooksList) {
    Gson gson = new Gson();
    String string = gson.toJson(notebooksList);
    try (FileWriter fileWriter = new FileWriter("nb.json", false)) {
      fileWriter.write(string);
    } catch (IOException ex) {
      System.out.println("Not found file");
    }
  }
}