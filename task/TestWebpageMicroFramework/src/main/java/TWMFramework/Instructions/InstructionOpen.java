package TWMFramework.Instructions;

import TWMFramework.Page.PageTester;

/**
 * Contains method and parameters for execute this instruction.
 */
public class InstructionOpen implements IInstruction {

  private PageTester pageTester = PageTester.getPageTester();
  private String url;
  private int timeout;

  public InstructionOpen(String url, int timeout) {
    this.url = url;
    this.timeout = timeout;
  }

  /**
   * Call receiver's method, suitable this instruction.
   */
  public void Execute() {
    pageTester.open(url, timeout);
  }
}