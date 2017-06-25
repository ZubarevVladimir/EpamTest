package Notebook.CommandCreators;

import Notebook.Commands.ICommand;

public interface ICreatorCommand {

  ICommand getCommand(String parameters);

}
