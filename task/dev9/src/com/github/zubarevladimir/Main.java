package com.github.zubarevladimir;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Contains entry-point method.
 */
public class Main {

  /**
   * Entry point metod.
   *
   * @param args contain file name.
   */
  public static void main(String[] args) {
    try {
      ReadFilesText readFilesText = new ReadFilesText();
      String text = readFilesText.readFileToString(args[0]);
      IniMapInitializer initializer = new IniMapInitializer();
      ReadString reader = new ReadString();
      System.out.print("Enter section: ");
      String section = reader.readString();
      System.out.print("Enter key: ");
      String key = reader.readString();
      Searcher searcher = new Searcher();
      List<String> valueArray = searcher.searchValue(initializer.iniMap(text), section, key);
      System.out.print("Value: \n");
      for (String s : valueArray) {
        System.out.println(s);
      }
    } catch (NoSuchElementException ex) {
      System.out.println(ex.getMessage());
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    } catch (IllegalArgumentException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
