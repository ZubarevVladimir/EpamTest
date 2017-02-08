package src.zubarev.randomoptions;

import java.util.*;

public class Randomizer {
  public static final int RAND_NUMBER = 3;	
  

  public static void getRandomOptions(List<String> optionList) {

    List<String> randomOptionsList = new ArrayList<String>();
    final Random random = new Random();
	Controler.checkSizeOptionsList(optionList.size());
    for (int i = 0; i < RAND_NUMBER; i++) {
      int index = random.nextInt(optionList.size()); 
    }
    Printer.printOptionsList(randomOptionsList);

  }
} 
