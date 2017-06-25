package Notebook.CommandCreators;

import Notebook.Commands.CommandDeleteNote;
import Notebook.Commands.ICommand;

public class CreatorCommandDeleteNote implements ICreatorCommand {

  private ICommand command;
  private ICreatorCommand nextCommandCreator;

  public CreatorCommandDeleteNote(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.deletenote.name())) {
      command = new CommandDeleteNote(Integer.parseInt(parametersArray[1]));
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
