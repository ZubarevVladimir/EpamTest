package TWMFramework.Workers;

import TWMFramework.InstructionCreators.InstructionCreator;
import TWMFramework.Instructions.IInstruction;

/**
 * Contains method for executing instruction.
 */
public class InstructionManager {

  private static InstructionManager manager;
  private IInstruction instruction;

  /**
   * Initialize instruction according to given string and execute it.
   *
   * @param instruction instruction with parameters,  which need execute.
   */
  public void executeInstruction(String instruction) {
    InstructionCreator creator = new InstructionCreator();
    this.instruction = creator.getInstruction(instruction);
    this.instruction.Execute();
  }
}