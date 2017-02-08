package src.zubarev.randomoptions;

import java.util.*;

public class Checker {
  public static final char KEY_SYMBOL = '-';
  
  public static void checkOptions(String[] args) {
    List<String> optionList = new ArrayList<String>();
	for (String str : args) {
	  char[] option = str.toCharArray();
	  if (option[0] == KEY_SYMBOL) {
	    optionList.add(str);
	  }
	}	
	Randomizer.getRandomOptions(optionList);
  }
} 