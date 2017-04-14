package Notebook.NotebookStaff;

import Notebook.Notebook.IDGenerator;
import Notebook.Notebook.Notebook;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains methods for work with notebook.
 */
public class NotebookProvider {

  private final String MESSAGE_NOTEBOOK_CREATE = "notebook created";
  private final String MESSAGE_LOAD = " load";
  private final String MESSAGE_SAVE = " save";
  private final String MESSAGE_NOT_FOUND_FILE = "Not found file ";
  private final String MESSAGE_NONEXISTENT_WAY = "Nonexistent way ";
  private final String MESSAGE_NOTE_DELETE = "Note delete";

  private IDGenerator generator = IDGenerator.getIDGenerator();
  private static NotebookProvider provider;
  private Notebook notebook;
  private List<Notebook> notebooksList = new ArrayList<>();

  private NotebookProvider() {
  }

  /**
   * Singleton method for getting notebook provider.
   *
   * @return NotebookProvider - singleton exemplar this class.
   */
  public static NotebookProvider getNotebookProvider() {
    if (provider == null) {
      provider = new NotebookProvider();
    }
    return provider;
  }

  /**
   * Method for getting current notebook.
   *
   * @return Notebook - current notebook.
   */
  public Notebook getCurrentNotebook() {
    return notebook;
  }

  public void openNotebook(int notebookID) {
    for (Notebook notebook : notebooksList) {
      if (notebook.getId() == notebookID) {
        this.notebook = notebook;
      }
    }
  }

  /**
   * Add note to notebook.
   *
   * @param title note title.
   * @param text note text.
   */
  public void addNote(String title, String text, String authorName, String authorSurname) {
    notebook.addNote(title, text, authorName, authorSurname);
  }

  /**
   * Delete notebook with getting id.
   *
   * @param id - id deleted notebook.
   */
  public void deleteNotebook(int id) {
    for (Notebook notebook : notebooksList) {
      if (notebook.getId() == id) {
        notebooksList.remove(notebook);
      }
    }
  }

  /**
   * Delete note by given id.
   *
   * @param id id note, which need delete.
   */
  public void deleteNote(int id) {
    notebook.deleteNote(id);
    System.out.println(MESSAGE_NOTE_DELETE);
  }

  /**
   * Print all notebooks, witch contains in list.
   */
  public void printNotebookList() {
    for (Notebook notebook : notebooksList) {
      System.out.println("Notebook id: " + notebook.getId() + ", " +
          "Notebook title: " + notebook.getTitle() + ", " + notebook.getAuthor().toString());
    }
  }

  /**
   * Delete last note in current notebook.
   */
  public void deleteLastNote() {
    notebook.deleteLastNote();
    System.out.println(MESSAGE_NOTE_DELETE);
  }

  /**
   * Load notebook by given path.
   *
   * @param loadPath opened notebook path.
   */
  public void loadNotebook(String loadPath) {
    Gson gson = new Gson();
    try (BufferedReader reader = new BufferedReader(new FileReader(loadPath))) {
      notebook = gson.fromJson(reader, Notebook.class);
      notebooksList.add(notebook);
      System.out.println(loadPath + MESSAGE_LOAD);
    } catch (IOException ex) {
      System.out.println(MESSAGE_NOT_FOUND_FILE + loadPath);
    }
  }

  /**
   * Load all notebooks by given path.
   *
   * @param loadPath opened notebook path.
   */
  public void loadNotebookList(String loadPath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(loadPath))) {
      Gson gson = new Gson();
      // TypeToken
      Notebook[] arrayNotebooks = gson.fromJson(reader, Notebook[].class);
      notebooksList = Arrays.asList(arrayNotebooks);
      notebook = notebooksList.get(notebooksList.size() - 1);
      System.out.println(loadPath + MESSAGE_LOAD);
    } catch (IOException ex) {
      System.out.println(MESSAGE_NOT_FOUND_FILE + loadPath);
    }
  }

  /**
   * Create new notebook.
   */
  public void createNotebook(String title, String authorName, String authorSurname) {
    System.out.println(title + " " + MESSAGE_NOTEBOOK_CREATE);
    notebook = new Notebook(generator.getID(), title, authorName, authorSurname);
    notebooksList.add(notebook);
  }

  /**
   * Save notebook by given path.
   *
   * @param savePath path, where notebook will be saved.
   */
  public void saveNotebook(String savePath) {
    Gson gson = new Gson();
    String string = gson.toJson(notebook);
    try (FileWriter fileWriter = new FileWriter(savePath, false)) {
      fileWriter.write(string);
      System.out.println(savePath + MESSAGE_SAVE);
    } catch (IOException ex) {
      System.out.println(MESSAGE_NONEXISTENT_WAY + savePath);
    }
  }

  /**
   * Save all notebooks by given path.
   *
   * @param savePath path, where notebook will be saved.
   */
  public void saveNotebookList(String savePath) {
    Gson gson = new Gson();
    String string = gson.toJson(notebooksList);
    try (FileWriter fileWriter = new FileWriter(savePath, false)) {
      fileWriter.write(string);
      System.out.println(savePath + MESSAGE_SAVE);
    } catch (IOException ex) {
      System.out.println(MESSAGE_NONEXISTENT_WAY + savePath);
    }
  }
}