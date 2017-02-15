package task.dev3.Operations;

import task.dev3.User.*;

import java.io.*;
import java.util.*;

/**
 * Print options information.
 */
public class InformationPrinter {

  /**
   * Call methods for print options information.
   * @param userList - list contains all added users.
   */
  public void printOptionsInfo(List<User> userList) {
    printAverageAge(userList);
    printEldestUser(userList);
    printMostPopularFemaleName(userList);
    printSimilarSurname(userList);
  }

  /**
   * Print users average age.
   * @param userList - list contains all added users.
   */
  private void printAverageAge(List<User> userList) {
    AverageAge age = new AverageAge();
    System.out.println("Average user's age: " + age.calculateAverageAge(userList));
  }

  /**
   * Print information about eldest user.
   * @param userList - list contains all added users.
   */
  private void printEldestUser(List<User> userList) {
    EldestUser user = new EldestUser();
    System.out.print("The oldest user: ");
    (user.eldestUser(userList)).printUsersInfo();
  }
  
  /**
   * Print the most popular womans name.
   * @param userList - list contains all added users.
   */
  private void printMostPopularFemaleName(List<User> userList) {
    MostPopularName name = new MostPopularName();
    System.out.print("Most popular woman name: ");
    System.out.println(name.mostPopularFemaleName(userList));
  }

  /**
   * Print information about namesakes.
   * @param userList - list contains all added users.
   */
  private void printSimilarSurname(List<User> userList) {
    SimilarSurname surname = new SimilarSurname();
    List<User> similarSurnameList = new ArrayList<User>();
    similarSurnameList = surname.similarSurname(userList);
    System.out.println("People with similar surnames: ");
    for (int i = 0; i < similarSurnameList.size(); i++) {
      System.out.print("   ");
      (similarSurnameList.get(i)).printUsersInfo();
    }
  }
}