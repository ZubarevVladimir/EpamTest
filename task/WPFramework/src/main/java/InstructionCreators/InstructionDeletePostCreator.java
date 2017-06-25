package InstructionCreators;

import Instructions.IInstruction;
import Instructions.InstructionCreatePage;
import Instructions.InstructionCreatePost;
import Instructions.InstructionDeletePost;
import Instructions.InstructionIncorrectAuthorization;

/**
 * Create instruction deletePost.
 */
public class InstructionDeletePostCreator implements IInstructionCreator {

  private IInstructionCreator nextInstructionCreator;
  private IInstruction instruction;

  public InstructionDeletePostCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction deletePost if given parameters correct, or call next
   * creator.
   *
   * @param parameters - string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.deletePost.name())) {
      instruction = new InstructionDeletePost(parametersArray[1].trim());
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }
}
