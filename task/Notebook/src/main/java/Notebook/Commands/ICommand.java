package Notebook.Commands;

import java.util.List;

/**
 * Contains methods for execute and undo different command.
 */
public interface ICommand {

  /**
   * Method for execute command.
   */
  void execute();

  /**
   * Method for undo method.
   * @return List - stack without this command.
   */
  List<ICommand> undo();
}
