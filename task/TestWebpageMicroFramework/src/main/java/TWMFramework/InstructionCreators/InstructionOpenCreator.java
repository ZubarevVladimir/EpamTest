package TWMFramework.InstructionCreators;

import TWMFramework.Instructions.IInstruction;
import TWMFramework.Instructions.InstructionOpen;

/**
 * Create instruction openInstruction.
 */
public class InstructionOpenCreator implements IInstructionCreator {

  private IInstructionCreator nextInstructionCreator;
  private IInstruction instruction;

  public InstructionOpenCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction openInstruction if given parameters correct, or call next
   * creator.
   *
   * @param parameters string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.open.name())) {
      String[] arrayParameters = parametersArray[1].split(" ", 2);
      instruction = new InstructionOpen(arrayParameters[0].replaceAll("[\"]", ""),
          Integer.parseInt(arrayParameters[1].trim().replaceAll("[\"]", "")));
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }
}