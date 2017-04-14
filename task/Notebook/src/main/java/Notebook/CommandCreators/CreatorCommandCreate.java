package Notebook.CommandCreators;

import Notebook.Commands.CommandCreate;
import Notebook.Commands.ICommand;
import Notebook.NotebookStaff.NotebookManager;
import Notebook.NotebookStaff.NotebookProvider;

/**
 * Contains method for create command create.
 */
class CreatorCommandCreate implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  CreatorCommandCreate(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'create', else, call next creator in chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
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
