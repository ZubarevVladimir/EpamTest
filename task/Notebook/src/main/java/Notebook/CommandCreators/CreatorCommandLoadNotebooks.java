package Notebook.CommandCreators;

import Notebook.Commands.CommandLoadNotebooks;
import Notebook.Commands.ICommand;

/**
 * Contains method for create command loadnotebooks.
 */
class CreatorCommandLoadNotebooks implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  CreatorCommandLoadNotebooks(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'loadnotebooks', else, call next creator
   * in chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.loadnotebooks.name())) {
      command = new CommandLoadNotebooks(parametersArray[1].trim());
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
