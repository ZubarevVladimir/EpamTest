package task_dev2;

import java.io.*;
import java.util.*;

/**
 * This class contains method for check work programm.
 * There is static methods, because work with this methods without create exeplar more useful 
 * than create exemplar in other classes and methods, i think...
 */
public class Checker {
	
  /**
   * Method check length given string and if it's 0 send error message and stop programm
   */
  public static void notNullInputArgs(String args) {
    if ((args.length() == 0) || (args.equals(".") || (args.equals("e")))) {
      System.out.println("ERROR! Please, enter expression");
      System.exit(0); 
    }
  }

  public static void notNullInputArgs(List args) {
    if ((args.size() < 3)) {
      System.out.println("ERROR! Please, enter expression.");
      System.exit(0); 
    }
  }
  
 /**
  * Check that given List not contain operators beside,
  * and not complies send message and stop programm 
  */
  public static void checkExpression(List<String> listExpression) {  
    for (int i = 1; i<listExpression.size(); i += 2) {
      String elementI = listExpression.get(i);
      if (((listExpression.get(i)).equals("*")) || (((listExpression.get(i)).equals("/")) ||
         (((listExpression.get(i)).equals("+")) || ((listExpression.get(i)).equals("-"))))) {
        if (((listExpression.get(i-1)).equals("*")) || (((listExpression.get(i-1)).equals("/")) ||
           (((listExpression.get(i-1)).equals("+")) || ((listExpression.get(i-1)).equals("-"))))) {
          System.out.println("ERROR! You enter incorrect expression");
		  System.exit(0);
        }
      }  
    } 

  }
  
 /**
  * Check that given List complise,
  * if not, send error message and stop programm
  */
  public static void checkExpressionNext(List<String> listExpression) { 
    for (int k = 0; k<listExpression.size(); k += 2) {
      int countExp = 0;
	  int countPoint = 0;
	  String listElement = listExpression.get(k);
      char[] number = listElement.toCharArray();
      for (int j = 0; j < number.length; j++) {
        if ((((number[j] < '0') || (number[j] > '9')) != ((number[j] == 'e') || 
		    (number[j] == 'E') || (number[j] == '-') || (number[j] == '.') || 
		    (number[j] == '+')))) {
          System.out.println("ERROR! You enter incorrect expression.");
          System.exit(0);          
        } else if ((number[j] == '.')) { // Check that number has got only one double part
			countPoint++;
			if (countPoint > 1){ 
		      System.out.println("ERROR! You enter incorrect expression.");
              System.exit(0);	
			}		
		} else if (((number[j] == 'e') || (number[j] == 'E'))) { // Check that number has got only one exponent part
			countExp++;
			if (countExp > 1){
		      System.out.println("ERROR! You enter incorrect expression.");
              System.exit(0);	
			}
		}
		if ((number[j] == '.')) { // Check that exponent has't got double part
			if (countExp >= 1) {
		      System.out.println("ERROR! Exponent is incorrect.");
              System.exit(0);				
			}			
		}
		if (number[0] == 'e' || number[0] == 'E') {  // Check there is number before exponent
		  System.out.println("ERROR! You enter incorrect expression.");
          System.exit(0);  
		}
		if ((number[j] == 'e') || (number[j] == 'E')) { // Check the exponent has number after +/-
		  if ((number[j+1] == '+') || (number[j+1] == '-')) {		  
	        if (number.length == j+2) {
		      System.out.println("ERROR! You enter incorrect expression.");
              System.exit(0);	  
		  }   
		  }
		}
	  }
	}
  }
}