package Instructions;

public interface IInstruction {

  /**
   * Call receiver's method, suitable this instruction.
   */
  void Execute();
}