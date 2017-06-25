package Notebook.CommandCreators;

import Notebook.Commands.ICommand;

public class CommandCreator {

  private ICreatorCommand creatorCommand;

  public ICommand getCommand(String commandParameters) {
    creatorCommand = new CreatorCommandAdd(
        new CreatorCommandCreate(
            new CreatorCommandPrintNotebook(
                new CreatorCommandPrintNotebooks(
                    new CreatorCommandDeleteNote(
                        new CreatorCommandDeleteNotebook(
                            new CreatorCommandHelp(new CommandCreatorSetSource(null))))))));
    return creatorCommand.getCommand(commandParameters);
  }

}
