package src.zubarev.randomoptions;

import java.util.*;

/** 
 *This class output random options.
 */
public class Printer {
	
/**
 * Output given string in optionList.
 *
 * Params  Give list optionList with output information. 
 */	
  public static void printOptionsList(List<String> optionList) {
    for (String str : optionList) {
      System.out.println(str);
    }	
  }
}