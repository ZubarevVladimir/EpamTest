package Notebook.CommandCreators;

import Notebook.Commands.CommandPrintNotebooks;
import Notebook.Commands.ICommand;

/**
 * Contains method for create command printnotebooks.
 */
class CreatorCommandPrintNotebooks implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  CreatorCommandPrintNotebooks(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'printnotebooks', else, call next creator in
   * chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.printnotebooks.name())) {
      command = new CommandPrintNotebooks();
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
