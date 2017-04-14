package Notebook.CommandCreators;

import Notebook.Commands.ICommand;

/**
 * Contains chain of responsibility command's creators.
 */
public class CommandCreator {

  private ICreatorCommand creatorCommand;

  /**
   * Create necessary command according to given parameter.
   *
   * @param commandParameters parameters for create and execute command.
   * @return ICommand - command, witch contains in parameter.
   */
  public ICommand getCommand(String commandParameters) {
    creatorCommand = new CreatorCommandAdd(
        new CreatorCommandLoadNotebook(
            new CreatorCommandLoadNotebooks(
                new CreatorCommandCreate(
                    new CreatorCommandSaveNotebook(
                        new CreatorCommandSaveNotebooks(
                            new CreatorCommandPrint(
                                new CreatorCommandPrintNotebooks(
                                    new CreatorCommandDeleteNote(
                                        new CreatorCommandDeleteNotebook(
                                            new CreatorCommandHelp(
                                                new CreatorCommandOpen(null))))))))))));
    return creatorCommand.getCommand(commandParameters);
  }
}
