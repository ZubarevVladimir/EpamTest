package task.dev3.Operations;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Do operations for search users.
 */
public class EldestUser {

  /**
   * Search the the eldest user.
   * @param userList - list contains all added users.
   * @return User - the eldest user in given list.
   */  
  public User eldestUser(List<User > userList) {
    int elderUsersId = 0; 
    for (int i = 0; i < userList.size();i++) {
      if ((userList.get(elderUsersId)).getAge()<(userList.get(i)).getAge()) {
        elderUsersId = i;
      } 
    }
    return userList.get(elderUsersId);
  }
}