package task.dev3;

import task.dev3.User.*;
import task.dev3.EnterUser.*;
import task.dev3.Operations.InformationPrinter;

import java.io.*;
import java.util.*;

/**
 * Class is entry point to work.
 */
public class EntryPoint {
  public static void main(String[] args) {
    List<User> userList = new ArrayList<User>();
    Scanner input = new Scanner(System.in);
    int choose = 0;
    int i = 0;
    
    while (i < 1) {
      System.out.println("Do you want to add user?\n" + "1 - Yes\n" + "2 - No");
      choose = input.nextInt();
      if (choose == 1) {
        User user = new User();
        EnterUser enter = new EnterUser();
        enter.setEnterUserInfo(user);
        userList.add(user);
      } else if (choose == 2) {
          InformationPrinter print = new InformationPrinter();
          print.printOptionsInfo(userList);
          i++;
      } else {
          System.out.println("Enter 'y' or 'n'");
      }
    }
  }
}
 
