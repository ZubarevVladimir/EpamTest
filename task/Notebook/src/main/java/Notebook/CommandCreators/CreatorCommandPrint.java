package Notebook.CommandCreators;

import Notebook.Commands.CommandPrint;
import Notebook.Commands.ICommand;
import Notebook.NotebookStaff.NotebookConsoleViewer;
import Notebook.NotebookStaff.NotebookProvider;

/**
 * Contains method for create command print.
 */
class CreatorCommandPrint implements ICreatorCommand {

  private ICreatorCommand nextCommandCreator;
  private ICommand command;

  CreatorCommandPrint(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'print', else, call next creator in
   * chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
  public ICommand getCommand(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].equalsIgnoreCase(EnumCommands.print.name())) {
      command = new CommandPrint();
    } else {
      command = nextCommandCreator.getCommand(parameters);
    }
    return command;
  }
}
