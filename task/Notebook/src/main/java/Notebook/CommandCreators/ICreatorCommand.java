package Notebook.CommandCreators;

import Notebook.Commands.ICommand;

/**
 * Interface for command creator's.
 */
public interface ICreatorCommand {

  /**
   * Method for create concrete command contains in parameters.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command, witch contains in parameter.
   */
  ICommand getCommand(String parameters);

}
