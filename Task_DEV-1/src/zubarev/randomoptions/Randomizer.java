package src.zubarev.randomoptions;

import java.util.*;
/**
 * This class take RAND_NUMBER options from given list.
 */
public class Randomizer {
  public static final int RAND_NUMBER = 3;	
  
/**
 * Take RAND_NUMBER options from optionList.
 * 
 * @param List<String> .
 * @return Give list with random options to method printOptionsList(List<String> optionList). 
 */	
  public static void getRandomOptions(List<String> optionList) {

    List<String> randomOptionsList = new ArrayList<String>();
    final Random random = new Random();
	Controler.checkSizeOptionsList(optionList.size());
    for (int i = 0; i < RAND_NUMBER; i++) {
      int index = random.nextInt(optionList.size());
      randomOptionsList.add(i, optionList.remove(index)); // Take random option and add to new list
    }
    Printer.printOptionsList(randomOptionsList);

  }
} 
