package TWMFramework.InstructionCreators;

import TWMFramework.Instructions.IInstruction;
import TWMFramework.Instructions.InstructionCheckPageContains;

/**
 * Create instruction checkPageContains.
 */
public class InstructionCheckPageContainsCreator implements IInstructionCreator {

  private IInstruction instruction;
  private IInstructionCreator nextInstructionCreator;

  public InstructionCheckPageContainsCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction checkPageContains if given parameters correct, or call next
   * creator.
   *
   * @param parameters string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.checkpagecontains.name())) {
      instruction = new InstructionCheckPageContains(
          parametersArray[1].trim().replaceAll("[\"]", ""));
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }
}