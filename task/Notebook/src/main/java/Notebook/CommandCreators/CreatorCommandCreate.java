package Notebook.CommandCreators;

import Notebook.Commands.CommandCreate;
import Notebook.Commands.ICommand;
import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;

public class CreatorCommandCreate implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  public CreatorCommandCreate(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.create.name())) {
      String[] arrayParameters = parametersArray[1].split("[|]", 3);
      command = new CommandCreate(arrayParameters[2], arrayParameters[0], arrayParameters[1]);
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
