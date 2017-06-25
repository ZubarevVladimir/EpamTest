package TWMFramework.Instructions;

import TWMFramework.Page.PageTester;

/**
 * Contains method and parameters for execute this instruction.
 */
public class InstructionCheckPageTitle implements IInstruction {

  private String text;
  private PageTester pageTester = PageTester.getPageTester();

  public InstructionCheckPageTitle(String text) {
    this.text = text;
  }

  /**
   * Call receiver's method, suitable this instruction.
   */
  public void Execute() {
    pageTester.checkPageTitle(text);
  }
}