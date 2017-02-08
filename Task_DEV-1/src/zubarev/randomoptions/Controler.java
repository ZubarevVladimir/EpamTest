package src.zubarev.randomoptions;

import java.util.*;

  /**
   * This class include control methods for correct programming work.
   */ 
public class Controler {
 
  /**
   * Method check length entered string.
   * If length 0, method stop programm and seng Error message.
   *
   * @param Get string array.
   * @return Nothing if length not 0, Error message and stoping programm if 0.
   */	
  public static void checkNullLength(String[] args) {
    if (args.length != 0) {}
	else {
	  System.out.println("ERROR! There is no options!");
	  System.exit(0);
	} 
  }
  
  /**
   * Check option's like rule: symbols are lowercase Latin letters. 
   *
   * @param Get Char array.
   * @return Boolen variable True if option answer rule, False if no.
   */	
  public static boolean checkOptionName(char[] optionName) {
	boolean status = true;
 
	for (int i = 1; i < optionName.length; i++) {
	  if ((optionName[i] < 'a') || (optionName[i] > 'z')) { // Rule : lowercase Latin letters
		status = false;
		break;
	  } else {
	    }
	}		
	return valid;
  }

  /**
   * Compare real size with necessary size string. 
   *
   * @param Get real size.
   * @return Nothing if real size is more than necessary , Error message if less.
   */ 
  public static void checkSizeOptionsList(int size) {
    if (Randomizer.RAND_NUMBER <= size) {}
	else {
	 System.out.println("ERROR! There is not enough options!\n" + "Enter more options.");
	  System.exit(0);
	} 
  }  
}


