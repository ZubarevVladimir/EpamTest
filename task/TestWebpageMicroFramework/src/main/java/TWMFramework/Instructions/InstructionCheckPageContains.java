package TWMFramework.Instructions;

import TWMFramework.Page.PageTester;

/**
 * Contains method and parameters for execute this instruction.
 */
public class InstructionCheckPageContains implements IInstruction {

  private String text;
  private PageTester pageTester = PageTester.getPageTester();

  public InstructionCheckPageContains(String text) {
    this.text = text;
  }

  /**
   * Call receiver's method, suitable this instruction.
   */
  public void Execute() {
    pageTester.checkPageContains(text);
  }
}