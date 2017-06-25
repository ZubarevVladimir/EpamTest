package TWMFramework.InstructionCreators;

import TWMFramework.Instructions.IInstruction;

/**
 * Contains chain of responsibility for choose necessary creator.
 */
public class InstructionCreator {

  private IInstructionCreator instructionCreator;

  /**
   * Build instruction according to given parameters and do it.
   *
   * @param instructionParameters string, contains necessary parameters for instruction.
   * @return IInstruction - instruction build by given parameters.
   */
  public IInstruction getInstruction(String instructionParameters) {
    instructionCreator = new InstructionCheckLinkPresentByHrefCreator(
        new InstructionCheckLinkPresentByNameCreator(
            new InstructionCheckPageContainsCreator(
                new InstructionCheckPageTitleCreator(
                    new InstructionOpenCreator(
                        new InstructionCloseCreator(null))))));
    return instructionCreator.getInstruction(instructionParameters);
  }
}