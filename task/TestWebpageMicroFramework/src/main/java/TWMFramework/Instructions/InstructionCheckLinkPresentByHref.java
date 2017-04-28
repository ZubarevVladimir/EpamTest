package TWMFramework.Instructions;

import TWMFramework.Page.PageTester;

/**
 * Contains method and parameters for execute this instruction.
 */
public class InstructionCheckLinkPresentByHref implements IInstruction {

  private PageTester pageTester = PageTester.getPageTester();
  private String href;

  public InstructionCheckLinkPresentByHref(String href) {
    this.href = href;
  }

  /**
   * Call receiver's method, suitable this instruction.
   */
  public void Execute() {
    pageTester.checkLinkPresentByHref(href);
  }
}