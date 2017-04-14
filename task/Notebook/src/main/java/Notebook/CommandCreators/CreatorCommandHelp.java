package Notebook.CommandCreators;

import Notebook.Commands.CommandHelp;
import Notebook.Commands.ICommand;

/**
 * Contains method for create command help.
 */
class CreatorCommandHelp implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  CreatorCommandHelp(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'help', else, call next creator in chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.help.name())) {
      command = new CommandHelp();
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
