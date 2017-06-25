package TWMFramework.InstructionCreators;

import TWMFramework.Instructions.InstructionCheckPageTitle;
import TWMFramework.Instructions.IInstruction;

/**
 * Create instruction checkPageTitle.
 */
public class InstructionCheckPageTitleCreator implements IInstructionCreator {

  private IInstruction instruction;
  private IInstructionCreator nextInstructionCreator;

  public InstructionCheckPageTitleCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction checkPageTitle if given parameters correct, or call next
   * creator.
   *
   * @param parameters string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.checkpagetitle.name())) {
      instruction = new InstructionCheckPageTitle(parametersArray[1].trim().replaceAll("[\"]", ""));
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }
}