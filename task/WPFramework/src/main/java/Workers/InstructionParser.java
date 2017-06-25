package Workers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse instructions, which receive from file.
 */
public class InstructionParser {

  private List<String> instructionsList;//"D:/untitled/task/WPFramework/instructions.txt"
  private final String pathName = "instructions.txt";
  private final String NOT_FOUND_FILE = "Not found file";

  /**
   * Parse instruction like strings, add to list and return this list.
   *
   * @return List - list, contains instructions in file.
   */
  public List<String> getInstructions() {
    try (BufferedReader reader = new BufferedReader(new FileReader(pathName))) {
      instructionsList = reader.lines().collect(Collectors.toList());
    } catch (IOException ex) {
      System.out.println(NOT_FOUND_FILE);
    }
    return instructionsList;
  }
}