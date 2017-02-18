package task.dev3.Operations;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Do calculate operations.
 */
public class AverageAge {
  
  /**
   * Calculate users average age.
   * @param userList - list contains all added users.
   * @return double - average age all added users.
   */
  public double calculateAverageAge(List<User> userList) {
    double summUsersAge = 0; 
    
    for (int i = 0; i < userList.size();i++) {
      summUsersAge += (userList.get(i)).getAge(); 
    }
    return summUsersAge/userList.size();
  }
}