package com.github.zubarevladimir;

import com.github.zubarevladimir.File.Path;
import com.github.zubarevladimir.File.ReadFilesText;
import com.github.zubarevladimir.Json.JsonMapInitializer;
import com.github.zubarevladimir.Json.JsonMapWriter;

/**
 * Contains entry-point method.
 */
public class Main {

  /**
   * Entry point method.
   *
   * @param args contain file name.
   */
  public static void main(String[] args) {
    try {
      ReadFilesText readFilesText = new ReadFilesText();
      JsonMapInitializer initializer = new JsonMapInitializer();
      JsonMapWriter writer = new JsonMapWriter();
      String config = readFilesText.readFileToString("config.json");
      Path getter = new Path();
      String inputPath = getter.getPath(config, "input");
      String outputPath = getter.getPath(config, "output");
      String text = readFilesText.readFileToString(inputPath);
      writer.fileWriter(initializer.jsonMap(text), outputPath);
      System.out.printf("Write file: %s\nRead file: %s\nAll correct!\n", inputPath, outputPath);
    }  catch (Exception ex) {
      System.out.println("Incorrect work:\n"+ex.getMessage());
    }
  }
}
