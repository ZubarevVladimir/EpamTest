package TWMFramework.InstructionCreators;

import TWMFramework.Instructions.IInstruction;
import TWMFramework.Instructions.InstructionCheckLinkPresentByName;

/**
 * Create instruction checkLinkPresentByName.
 */
public class InstructionCheckLinkPresentByNameCreator implements IInstructionCreator {

  private IInstructionCreator nextInstructionCreator;
  private IInstruction instruction;

  public InstructionCheckLinkPresentByNameCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction checkLinkPresentByName if given parameters correct, or call next
   * creator.
   *
   * @param parameters string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.checklinkpresentbyname.name())) {
      instruction = new InstructionCheckLinkPresentByName(
          parametersArray[1].trim().replaceAll("[\"]", ""));
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }
}