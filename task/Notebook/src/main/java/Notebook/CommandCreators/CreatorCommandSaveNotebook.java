package Notebook.CommandCreators;

import Notebook.Commands.CommandSaveNotebook;
import Notebook.Commands.ICommand;

/**
 * Contains method for create command savenotebook.
 */
class CreatorCommandSaveNotebook implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  CreatorCommandSaveNotebook(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'savenotebook', else, call next creator
   * in chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.savenotebook.name())) {
      command = new CommandSaveNotebook(parametersArray[1].trim());
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
