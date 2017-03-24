package com.github.zubarevladimir.Json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Contains methods for write json map in given file.
 */
public class JsonMapWriter {

  private final int NUMBER_SPACES = 2;

  /**
   * Write given map? contains json variables? in given file.
   *
   * @param writeMap map, which need to write.
   * @param outputFile name file, in which to write.
   * @throws IOException if file not found.
   */
  public void fileWriter(Map<String, List<Map<String, String>>> writeMap, String outputFile)
      throws IOException {
    try (FileWriter writer = new FileWriter(outputFile, false)) {
      writer.write("{\n");
      for (Map.Entry<String, List<Map<String, String>>> entry : writeMap.entrySet()) {
        int numberSpaces = NUMBER_SPACES;
        int mainCounter = 0;
        writeSimpleElements(writer, entry, numberSpaces);
        numberSpaces += NUMBER_SPACES;
        for (Map<String, String> localMap : entry.getValue()) {
          mainCounter = writeCompositeElements(writer, entry, numberSpaces, localMap, mainCounter);
        }
      }
      writer.write("}\n");
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * Write simple main map elements.
   *
   * @param writer contains information about write file.
   * @param entry contains all variables main map.
   * @param numberSpaces contains number necessary spaces.
   * @throws IOException if file not found.
   */
  private void writeSimpleElements(FileWriter writer,
      Map.Entry<String, List<Map<String, String>>> entry, int numberSpaces) throws IOException {
    try {
      if (entry.getValue().size() > 1 || entry.getValue().get(0).entrySet().size() > 1) {
        writer.write(getSpaces(numberSpaces) + entry.getKey() + ": [\n");
      } else {
        writer.write(getSpaces(numberSpaces) + entry.getKey() + ": ");
      }
    } catch (IOException ex) {
      throw new IOException(ex.getMessage());
    }
  }

  /**
   * Write in given file local map elements.
   *
   * @param writer contains information about write file.
   * @param entryThree contains variables local map.
   * @param numberSpaces contains number necessary spaces.
   * @param counterMap value means number write maps.
   * @return int rewrite counterMap.
   * @throws IOException if file not found.
   */
  private int writeLocalElements(FileWriter writer, Map.Entry<String, String> entryThree,
      int numberSpaces, int counterMap) throws IOException {
    try {
      if (entryThree.getKey().equals("")) {
        writer.write(entryThree.getValue() + "\n");
      } else {
        counterMap++;
        writer.write(
            getSpaces(numberSpaces) + entryThree.getKey() + ": " + entryThree.getValue()
                + "\n");
      }
    } catch (IOException ex) {
      throw new IOException(ex.getMessage());
    }
    return counterMap;
  }

  /**
   * Write in file elements given map, which has composite structure.
   *
   * @param writer contains information about write file.
   * @param entry contains all variables main map.
   * @param numberSpaces contains number necessary spaces.
   * @param localMap array variable, contains information about local variables.
   * @param mainCounter number maps in array.
   * @return int number maps in array.
   * @throws IOException if file not found.
   */
  private int writeCompositeElements(FileWriter writer,
      Map.Entry<String, List<Map<String, String>>> entry, int numberSpaces,
      Map<String, String> localMap, int mainCounter
  ) throws IOException {
    try {
      int counterMap = 0;
      if (entry.getValue().size() > 1 || entry.getValue().get(0).entrySet().size() > 1) {
        writer.write(getSpaces(numberSpaces) + "{\n");
      }
      numberSpaces += NUMBER_SPACES;
      for (Map.Entry<String, String> entryThree : localMap.entrySet()) {
        counterMap = writeLocalElements(writer, entryThree, numberSpaces, counterMap);
      }
      mainCounter++;
      numberSpaces -= NUMBER_SPACES;
      if (entry.getValue().size() == mainCounter
          && entry.getValue().get(0).entrySet().size() > 1) {
        writer.write(getSpaces(numberSpaces) + "}\n");
        numberSpaces -= NUMBER_SPACES;
        writer.write(getSpaces(numberSpaces) + "],\n");
      } else if (localMap.entrySet().size() == counterMap
          && entry.getValue().get(0).entrySet().size() > 1) {
        writer.write(getSpaces(numberSpaces) + "},\n");
      }
    } catch (IOException ex) {
      throw new IOException(ex.getMessage());
    }
    return mainCounter;
  }

  /**
   * Get given number spaces.
   *
   * @param numberSpaces contains number necessary spaces.
   * @return String - contains given number spaces.
   */
  private String getSpaces(int numberSpaces) {
    String spaces = "";
    for (int i = 0; i < numberSpaces; i++) {
      spaces += " ";
    }
    return spaces;
  }
}