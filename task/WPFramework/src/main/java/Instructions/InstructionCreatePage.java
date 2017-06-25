package Instructions;

import Tester.WordPressTester;

/**
 * Contains method and parameters for execute instruction createPage.
 */
public class InstructionCreatePage implements IInstruction {

  private WordPressTester wordPressTester = WordPressTester.getInstance();
  private String title;
  private String text;

  public InstructionCreatePage(String title, String text) {
    this.text = text;
    this.title = title;
  }

  /**
   * Call tester's method, suitable this instruction.
   */
  public void Execute() {
    wordPressTester.checkCreatePage(title, text);
  }
}
