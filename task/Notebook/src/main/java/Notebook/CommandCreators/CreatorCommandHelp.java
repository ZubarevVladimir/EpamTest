package Notebook.CommandCreators;

import Notebook.Commands.CommandHelp;
import Notebook.Commands.ICommand;

public class CreatorCommandHelp implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  public CreatorCommandHelp(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

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
