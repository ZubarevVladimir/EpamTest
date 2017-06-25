package Instructions;

import Tester.WordPressTester;

/**
 * Contains method and parameters for execute instruction createPost.
 */
public class InstructionCreatePost implements IInstruction {

  private WordPressTester wordPressTester = WordPressTester.getInstance();
  private String title;
  private String text;

  public InstructionCreatePost(String title, String text) {
    this.title = title;
    this.text = text;
  }

  /**
   * Call tester's method, suitable this instruction.
   */
  public void Execute() {
    wordPressTester.checkCreatePost(title, text);
  }
}
