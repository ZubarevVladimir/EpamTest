package Notebook.Commands;

public class CommandHelp implements ICommand {

  public void Execute() {
    System.out.println("ADD <Notebook ID>|<Author's name> | <Author's surname> | <Note title> | <Note text>;");
    System.out.println("CREATE <Author's name> | <Author's surname> | <Notebook title>;");
    System.out.println("DELETENOTE <Note id>");
    System.out.println("DELETENOTEBOOK <Notebook id>");
    System.out.println("SETSOURCE <Notebook's source>");
    System.out.println("PRINTNOTEBOOK <Notebook ID>;");
    System.out.println("PRINTNOTEBOOKS ;");
    System.out.println("Enter 'stop' for stop program.");
  }
}