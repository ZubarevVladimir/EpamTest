package Instructions;

import Tester.WordPressTester;

/**
 * Contains method and parameters for execute instruction deleteComment.
 */
public class InstructionDeleteComment implements IInstruction {

  private WordPressTester wordPressTester = WordPressTester.getInstance();
  private String postTitle;
  private String commentText;

  public InstructionDeleteComment(String title, String text) {
    this.postTitle = title;
    this.commentText = text;
  }

  /**
   * Call tester's method, suitable this instruction.
   */
  public void Execute() {
    wordPressTester.checkDeleteComment(postTitle, commentText);
  }
}

