package Notebook.CommandCreators;

import Notebook.Commands.CommandAdd;
import Notebook.Commands.CommandSetSource;
import Notebook.Commands.ICommand;

public class CommandCreatorSetSource implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  public CommandCreatorSetSource(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.setsource.name())) {
      command = new CommandSetSource(parametersArray[1].trim());
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
