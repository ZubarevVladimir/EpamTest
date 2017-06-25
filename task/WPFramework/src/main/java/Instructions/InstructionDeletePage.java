package Instructions;

import Tester.WordPressTester;

/**
 * Contains method and parameters for execute instruction deletePage.
 */
public class InstructionDeletePage implements IInstruction {

  private WordPressTester wordPressTester = WordPressTester.getInstance();
  private String title;

  public InstructionDeletePage(String title) {
    this.title = title;
  }

  /**
   * Call tester's method, suitable this instruction.
   */
  public void Execute() {
    wordPressTester.checkDeletePage(title);
  }
}
