package TWMFramework.Instructions;

import TWMFramework.Page.PageTester;

/**
 * Contains method and parameters for execute this instruction.
 */
public class InstructionCheckLinkPresentByName implements IInstruction {

  private PageTester pageTester = PageTester.getPageTester();
  private String linkName;

  public InstructionCheckLinkPresentByName(String linkName) {
    this.linkName = linkName;
  }

  /**
   * Call receiver's method, suitable this instruction.
   */
  public void Execute() {
    pageTester.checkLinkPresentByName(linkName);
  }
}