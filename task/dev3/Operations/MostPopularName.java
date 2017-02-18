package task.dev3.Operations;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Do operations for search name.
 */
public class MostPopularName {
  public final String WOMAN = "woman";
  
  /**
   * Search the most popular womens name.
   * @param userList - list contains all added users.
   * @return String - the most popular female name.
   */  
  public String mostPopularFemaleName(List<User> userList) {
    int countI = 0;
    int countJ = 0;
    int indexMostPopularName = 0;

    for (int i = 0; i < userList.size(); i++) {
      countJ = 0;
      if (((userList.get(i)).getGender()).equals(WOMAN)) {  
        for (int j = 0; j < userList.size(); j++) {
          if (((userList.get(j)).getName()).equals((userList.get(i)).getName())) {
            countJ++;
          }
        }
        if (countI < countJ) {
          countI = countJ;
          indexMostPopularName = i;
        }
      }
    }
    String femaleName = ((userList.get(indexMostPopularName)).getName());
    return femaleName;
  } 
}