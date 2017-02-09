package src.zubarev.randomoptions;

import java.io.*;
 
/**
 * This class is entry point to work.
 */
public class RandomOptions {
  public static void main(String[] args) {
    Controler.checkNullLength(args);
    Checker.checkOptions(args);
  }
}