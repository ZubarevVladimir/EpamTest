package Notebook.CommandCreators;

import Notebook.Commands.CommandDeleteNotebook;
import Notebook.Commands.ICommand;

/**
 * Contains method for create command deletenotebooks.
 */
class CreatorCommandDeleteNotebook implements ICreatorCommand {

  private ICommand command;
  private ICreatorCommand nextCommandCreator;

  CreatorCommandDeleteNotebook(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'deletenotebooks', else, call next creator in
   * chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.deletenotebook.name())) {
      command = new CommandDeleteNotebook(Integer.parseInt(parametersArray[1]));
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
