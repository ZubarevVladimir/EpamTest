package Notebook.CommandCreators;

import Notebook.Commands.CommandDeleteNotebook;
import Notebook.Commands.ICommand;

public class CreatorCommandDeleteNotebook implements ICreatorCommand {

  private ICommand command;
  private ICreatorCommand nextCommandCreator;

  public CreatorCommandDeleteNotebook(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

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
