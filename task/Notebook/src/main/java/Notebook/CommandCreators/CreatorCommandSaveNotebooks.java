package Notebook.CommandCreators;

import Notebook.Commands.CommandSaveNotebooks;
import Notebook.Commands.ICommand;

/**
 * Contains method for create command savenotebooks.
 */
class CreatorCommandSaveNotebooks implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  CreatorCommandSaveNotebooks(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'savenotebooks', else, call next creator
   * in chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.savenotebooks.name())) {
      command = new CommandSaveNotebooks(parametersArray[1].trim());
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
