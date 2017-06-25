package Instructions;

import Tester.WordPressTester;

/**
 * Contains method and parameters for execute instruction deletePost.
 */
public class InstructionDeletePost implements IInstruction {

  private WordPressTester wordPressTester = WordPressTester.getInstance();
  private String title;

  public InstructionDeletePost(String title) {
    this.title = title;
  }

  /**
   * Call tester's method, suitable this instruction.
   */
  public void Execute() {
    wordPressTester.checkDeletePost(title);
  }
}
