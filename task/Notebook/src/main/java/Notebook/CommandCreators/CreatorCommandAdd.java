package Notebook.CommandCreators;

import Notebook.Commands.CommandAdd;
import Notebook.Commands.ICommand;
import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;
import java.util.Scanner;

/**
 * Contains method for create command add.
 */
public class CreatorCommandAdd implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  public CreatorCommandAdd(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'add', else, call next creator in chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.add.name())) {
      String[] arrayParameters = parametersArray[1].split("[|]", 4);
      command = new CommandAdd(arrayParameters[2], arrayParameters[3], arrayParameters[0],
          arrayParameters[1]);
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
