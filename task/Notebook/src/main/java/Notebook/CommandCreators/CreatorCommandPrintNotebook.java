package Notebook.CommandCreators;

import Notebook.Commands.CommandPrintNotebook;
import Notebook.Commands.ICommand;

public class CreatorCommandPrintNotebook implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  public CreatorCommandPrintNotebook(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.printnotebook.name())) {
      command = new CommandPrintNotebook(Integer.parseInt(parametersArray[1]));
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
