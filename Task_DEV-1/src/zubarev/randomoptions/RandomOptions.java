package src.zubarev.randomoptions;

import java.io.*;
 
public class RandomOptions {
  public static void main(String[] args) {
    Controler.checkNullLength(args);
    Checker.checkOptions(args);
  }
}