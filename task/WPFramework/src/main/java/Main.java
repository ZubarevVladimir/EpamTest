import Results.ResultContainer;
import Results.ResultPresenter;
import Results.TestResult;
import Workers.InstructionManager;
import Workers.InstructionParser;
import Workers.XMLParser;
import java.util.List;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point method
   *
   * @param args - not used.
   */
  public static void main(String[] args) {
    InstructionParser parser = new InstructionParser();
    List<String> instructionsList = parser.getInstructions();
    InstructionManager instructionManager = new InstructionManager();
    ResultContainer container = ResultContainer.getInstance();
    XMLParser xmlParser = new XMLParser();
    xmlParser.startParseResults();
    for (String instruction : instructionsList) {
      long startTime = System.currentTimeMillis();
      try {
        instructionManager.executeInstruction(instruction);
      } catch (Exception ex) {
        container.addResult(
            new TestResult(false, "Incorrect command", instruction,
                System.currentTimeMillis() - startTime, 1));
      }
    }
    ResultPresenter presenter = new ResultPresenter();
    presenter.setData(container.getResult());
    xmlParser.stopParseResults(presenter);
  }
}
