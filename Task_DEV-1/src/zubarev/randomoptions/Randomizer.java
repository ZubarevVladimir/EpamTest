package src.zubarev.randomoptions;
 
import java.util.*;
 
public class Randomizer {
  public static final int RAND_NUMBER = 5;
  
  public static void getRandomOptions(List<String> optionList) {
    List<String> randomOptionsList = new ArrayList<String>();
    final Random random = new Random();
    for (int i = 0; i < RAND_NUMBER; i++) {
      int index = random.nextInt(optionList.size());
    System.out.println(index);
      randomOptionsList.add(i, optionList.remove(index));
    }
    Printer.printOptionsList(randomOptionsList);
 }
} 