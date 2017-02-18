package task.dev3.Operations;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Class do operations for search namesakes.
 */
public class SimilarSurname {
  
  /**
   * Search namesakes and add them in list.
   * @param userList - list contains all added users.
   * @return List - list, contains people with similar surnames.
   */
  public List similarSurname(List<User> userList) {
    List<User> usersList = new ArrayList<User>();
    List<User> similarSurnameList = new ArrayList<User>();
    int count = 0;
    
    for (int k = 0; k < userList.size(); k++) {
      usersList.add(userList.get(k));
    }
    for (int i = 0; i < usersList.size(); i++) {
      String surname = (usersList.get(i)).getSurname();
      count = 0;
      int j = i + 1;
      while (j < usersList.size()) {
        if (surname.equals((usersList.get(j)).getSurname())) {
          count++;
          similarSurnameList.add(usersList.remove(j));
        } else {
            j ++;
        }
      }
      if (count > 0) {
        similarSurnameList.add(usersList.get(i));
      }
    }
    return similarSurnameList;
  }
}