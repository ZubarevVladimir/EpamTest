package TWMFramework.InstructionCreators;

import TWMFramework.Instructions.InstructionCheckLinkPresentByHref;
import TWMFramework.Instructions.IInstruction;

/**
 * Create instruction checkLinkPresentByHref.
 */
public class InstructionCheckLinkPresentByHrefCreator implements IInstructionCreator {

  private IInstructionCreator nextInstructionCreator;
  private IInstruction instruction;

  public InstructionCheckLinkPresentByHrefCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction checkLinkPresentByHref if given parameters correct, or call next
   * creator.
   *
   * @param parameters string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.checklinkpresentbyhref.name())) {
      instruction = new InstructionCheckLinkPresentByHref(
          parametersArray[1].trim().replaceAll("[\"]", ""));
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }
}