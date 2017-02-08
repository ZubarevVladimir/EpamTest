package src.zubarev.randomoptions;

import java.util.*;

public class Controler {
 	
  public static void checkNullLength(String[] args) {
    if (args.length != 0) {}
	else {
	  System.out.println("ERROR! There is no options!");
	  System.exit(0);
	} 
  }
  
  public static boolean checkOptionName(char[] optionName) {
	boolean status = true;
 
	for (int i = 1; i < optionName.length; i++) {
	  if ((optionName[i] < 'a') || (optionName[i] > 'z')) { 
		status = false;
		break;
	  } else {
	    }
	}		
	return valid;
  }

  public static void checkSizeOptionsList(int size) {
    if (Randomizer.RAND_NUMBER <= size) {}
	else {
	 System.out.println("ERROR! There is not enough options!\n" + "Enter more options.");
	  System.exit(0);
	} 
  }  
}


