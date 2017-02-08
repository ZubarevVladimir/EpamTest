package src.zubarev.randomoptions;

import java.util.*;

/**
 * This class Checks entered options likes some rules.
 */  
public class Checker {
  public static final char KEY_SYMBOL = '-';
  
/**
 * Checks entered options, this means next correcting rules:
 * 1. First symbol '-'. 
 * 2. Other symbols are lowercase Latin letters. 
 *
 * @param Get string array.  
 * @return Give string list to method getRandomOptions(List<String> str).
 */	
  public static void checkOptions(String[] args) {
    List<String> optionList = new ArrayList<String>();
	
	for (String str : args) {
	  char[] option = str.toCharArray(); // Convert string to char array.
	  boolean status = Controler.checkOptionName(option); // Check 2 rule.
	  if (option[0] == KEY_SYMBOL)  {
        if (status) {
		optionList.add(str);
		} 
	  }    
	}
	Randomizer.getRandomOptions(optionList);
  }
  
} 
