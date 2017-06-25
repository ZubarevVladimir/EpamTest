package Notebook.CommandCreators;

import Notebook.Commands.CommandPrintNotebooks;
import Notebook.Commands.ICommand;

public class CreatorCommandPrintNotebooks implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  public CreatorCommandPrintNotebooks(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

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
