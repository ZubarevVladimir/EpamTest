package TWMFramework.InstructionCreators;

import TWMFramework.Instructions.IInstruction;

public interface IInstructionCreator {

  IInstruction getInstruction(String parameters);

}