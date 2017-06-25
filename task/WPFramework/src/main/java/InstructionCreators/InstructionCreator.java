package InstructionCreators;

import Instructions.IInstruction;

/**
 * Contains chain of responsibility for choose necessary creator.
 */
public class InstructionCreator {

  private IInstructionCreator instructionCreator;

  /**
   * Build instruction according to given parameters and return it.
   *
   * @param instructionParameters - string, contains necessary parameters for instruction.
   * @return IInstruction - instruction build by given parameters.
   */
  public IInstruction getInstruction(String instructionParameters) {
    instructionCreator = new InstructionCorrectAuthorizationCreator(
        new InstructionIncorrectAuthorizationCreator(
            new InstructionCreatePostCreator(
                new InstructionDeletePostCreator(
                    new InstructionCreatePageCreator(
                        new InstructionDeletePageCreator(
                            new InstructionCreateCommentCreator(
                                new InstructionDeleteCommentCreator(null))))))));
    return instructionCreator.getInstruction(instructionParameters);
  }
}