package Instructions;

import Tester.WordPressTester;

/**
 * Contains method and parameters for execute instruction createComment.
 */
public class InstructionCreateComment implements IInstruction {

  private WordPressTester wordPressTester = WordPressTester.getInstance();
  private String postTitle;
  private String commentText;

  public InstructionCreateComment(String postTitle, String commentText) {
    this.commentText = commentText;
    this.postTitle = postTitle;
  }

  /**
   * Call tester's method, suitable this instruction.
   */
  public void Execute() {
    wordPressTester.checkCreateComment(postTitle, commentText);
  }
}