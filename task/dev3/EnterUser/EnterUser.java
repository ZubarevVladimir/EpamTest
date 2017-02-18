package task.dev3.EnterUser;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Class set entered information.
 */
public class EnterUser {

  /**
   * Call other method for giv information about user and set it.
   * @param user - user, which need to initialize.
   */  
  public void setEnterUserInfo(User user) {
    Scanner in = new Scanner(System.in);
    EnterUserName newName = new EnterUserName();
    EnterUserSurname newSurname = new EnterUserSurname();
    EnterUserGender newGender = new EnterUserGender();
    EnterUserAge newAge = new EnterUserAge();
    user.setName(newName.enterUserName(in));
    user.setSurname(newSurname.enterUserSurname(in));
    user.setGender(newGender.enterUserGender(in));
    user.setAge(newAge.enterUserAge(in));
  }
}
  