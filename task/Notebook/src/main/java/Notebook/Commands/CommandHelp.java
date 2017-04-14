package Notebook.Commands;

import Notebook.NotebookStaff.NotebookManager;
import java.util.List;

/**
 * Contains method for execute and undo command help.
 */
public class CommandHelp implements ICommand {

  /**
   * Call provider for print information about all available commands.
   */
  public void execute() {
    System.out.println("ADD <Author's name> | <Author's surname> | <Note title> | <Note text>;");
    System.out.println("CREATE <Author's name> | <Author's surname> | <Notebook title>;");
    System.out.println("OPEN <Notebook id>");
    System.out.println("LOADNOTEBOOK <Load file path>;");
    System.out.println("LOADNOTEBOOKS <Load file path>;");
    System.out.println("SAVENOTEBOOK <Save file path>;");
    System.out.println("SAVENOTEBOOKS <Save file path>;");
    System.out.println("DELETENOTE <Note id>");
    System.out.println("DELETENOTEBOOK <Notebook id>");
    System.out.println("PRINTNOTEBOOKS;");
    System.out.println("PRINT;");
    System.out.println("UNDO;");
    System.out.println("Enter 'stop' for stop program.");
  }

  /**
   * Undo command print.
   * @return List<ICommand> - stack without last command print.
   */
  public List<ICommand> undo() {
    NotebookManager manager = NotebookManager.getNotebookManager();
    manager.getCommandList().remove(manager.getCommandList().size() - 1);
    return manager.getCommandList();
  }
}