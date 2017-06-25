package Notebook.CommandCreators;

import Notebook.Commands.CommandAdd;
import Notebook.Commands.ICommand;
import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.Scanner;

public class CreatorCommandAdd implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  public CreatorCommandAdd(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.add.name())) {
      String[] arrayParameters = parametersArray[1].split("[|]", 5);
      command = new CommandAdd(arrayParameters[3], arrayParameters[4], arrayParameters[1],
          arrayParameters[2],Integer.parseInt(arrayParameters[0]));
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
