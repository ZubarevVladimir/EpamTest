package InstructionCreators;

import Instructions.IInstruction;
import Instructions.InstructionCreateComment;
import Instructions.InstructionCreatePost;

/**
 * Create instruction createComment.
 */
public class InstructionCreateCommentCreator implements IInstructionCreator {

  private IInstructionCreator nextInstructionCreator;
  private IInstruction instruction;

  public InstructionCreateCommentCreator(IInstructionCreator instructionCreator) {
    this.nextInstructionCreator = instructionCreator;
  }

  /**
   * Create instruction createComment if given parameters correct, or call next
   * creator.
   *
   * @param parameters - string, contains necessary parameters for create and execute instruction.
   * @return IInstruction - instruction, created by given parameters.
   */
  public IInstruction getInstruction(String parameters) {
    String[] parametersArray = parameters.trim().split(" ", 2);
    if (parametersArray[0].trim().equalsIgnoreCase(EnumInstruction.createComment.name())) {
      instruction = new InstructionCreateComment(
          parametersArray[1].trim().split("[|]", 2)[0].trim(),
          parametersArray[1].trim().split("[|]", 2)[1].trim());
    } else {
      instruction = nextInstructionCreator.getInstruction(parameters);
    }
    return instruction;
  }

}
