package TWMFramework;

import TWMFramework.Results.Result;
import TWMFramework.Results.ResultContainer;
import TWMFramework.Workers.InstructionManager;
import TWMFramework.Workers.InstructionParser;
import java.util.List;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point method.
   *
   * @param args - useless parameter.
   */
  public static void main(String[] args) {
    InstructionParser parser = new InstructionParser();
    List<String> instructionsList = parser.getInstructions();
    InstructionManager instructionManager = new InstructionManager();
    ResultContainer container = ResultContainer.getContainer();
    for (String instruction : instructionsList) {
      try {
        instructionManager.executeInstruction(instruction);
      } catch (NullPointerException ex) {
        container.addResult(new Result("!", "[" + instruction + "]", 0));
      } catch (ArrayIndexOutOfBoundsException ex) {
        System.out.println("Incorrect parameters");
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }
}
