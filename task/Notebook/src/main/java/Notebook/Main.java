package Notebook;

import Notebook.NotebookStaff.NotebookManager;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point method.
   * @param args - useless parameter.
   */
  public static void main(String[] args) {
    boolean NotCommandStop = true;
    NotebookManager notebookManager = NotebookManager.getNotebookManager();
    System.out.println("Enter 'help' for getting information about command.");
    while (NotCommandStop) {
      try {
        Scanner in = new Scanner(System.in);
        System.out.print("Command parameters: ");
        String command = in.nextLine().trim();
        if (command.equals("stop")) {
          NotCommandStop = false;
        } else {
          notebookManager.executeCommand(command);
        }
      } catch (NullPointerException ex) {
        System.out.println("Enter correct command");
      } catch (ArrayIndexOutOfBoundsException ex) {
        System.out.println("Incorrect parameters");
      } catch (ConcurrentModificationException ex){
        System.out.println("Can't delete once notebook");
      }
    }
  }
}
