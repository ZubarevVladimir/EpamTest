package Notebook.CommandCreators;

import Notebook.Commands.CommandDeleteNote;
import Notebook.Commands.ICommand;

/**
 * Contains method for create command deletenote.
 */
class CreatorCommandDeleteNote implements ICreatorCommand {

  private ICommand command;
  private ICreatorCommand nextCommandCreator;

  CreatorCommandDeleteNote(ICreatorCommand commandCreator) {
    this.nextCommandCreator = commandCreator;
  }

  /**
   * Create command, if give parameters for create command 'deletenote', else, call next creator in chain.
   *
   * @param parameters parameters for create and execute command.
   * @return ICommand - command according to given parameters.
   */
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
