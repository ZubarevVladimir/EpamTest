package TWMFramework.Instructions;

import TWMFramework.Page.PageTester;

/**
 * Contains method for execute this instruction.
 */
public class InstructionClose implements IInstruction {

  private PageTester pageTester = PageTester.getPageTester();

  public InstructionClose() {
  }

  /**
   * Call receiver's method, suitable this instruction.
   */
  public void Execute() {
    pageTester.close();
  }
}