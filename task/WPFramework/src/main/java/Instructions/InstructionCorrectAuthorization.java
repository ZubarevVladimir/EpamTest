package Instructions;

import Tester.WordPressTester;

/**
 * Contains method and parameters for execute instruction correctAuthorization.
 */
public class InstructionCorrectAuthorization implements IInstruction {

  private WordPressTester wordPressTester = WordPressTester.getInstance();
  private String login;
  private String password;

  public InstructionCorrectAuthorization(String login, String password) {
    this.login = login;
    this.password = password;
  }

  /**
   * Call tester's method, suitable this instruction.
   */
  public void Execute() {
    wordPressTester.checkCorrectAuthorization(login, password);
  }
}