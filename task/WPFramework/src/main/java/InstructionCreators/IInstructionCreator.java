package InstructionCreators;

import Instructions.IInstruction;

public interface IInstructionCreator {

  IInstruction getInstruction(String parameters);

}