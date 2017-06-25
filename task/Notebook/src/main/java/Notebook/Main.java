package Notebook;

import Notebook.NotebookStaff.NotebookManager;
import java.util.Scanner;

public class Main {

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
      }
    }
  }
}
