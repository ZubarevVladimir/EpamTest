package InstructionCreators;

import Instructions.IInstruction;
import Instructions.InstructionCorrectAuthorization;
import Instructions.InstructionIncorrectAuthorization;

/**
 * Create instruction incorrectAuthorization.
 */
public class InstructionIncorrectAuthorizationCreator implements IInstructionCreator {

  private IInstructionCreator nextInstructionCreator;
  private IInstruction instruction;

  public InstructionIncorrectAuthorizationCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction incorrectAuthorization if given parameters correct, or call next
   * creator.
   *
   * @param parameters string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.incorrectAuthorization.name())) {
      instruction = new InstructionIncorrectAuthorization(
          parametersArray[1].trim().split("[|]", 2)[0].trim(),
          parametersArray[1].trim().split("[|]", 2)[1].trim());
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }

}