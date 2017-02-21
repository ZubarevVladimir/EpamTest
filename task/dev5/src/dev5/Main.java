package dev5;

import dev5.Team.Team.Developers.Developer;
import dev5.Team.SetTeam.SetTeam;
import java.util.Map;
import java.util.Scanner;

/**
 * Contains entry point method.
 */
public class Main {

  /**
   * Entry point to work.
   */
  public static void main(String[] args) {
    Map<Developer, Integer> teamMap;
    for (; ;) {
      System.out
          .println("Choose option for pick team:\n" + "1. Maximum productivity in current sum.\n"
              + "2. Minimum sum in current productivity.\n"
              + "3. Minimum qualification in current productivity.");
      Scanner in = new Scanner(System.in);
      String option = in.nextLine();
      if (option.equals("1") || option.equals("2") || option.equals("3")) {
        SetTeam setter = new SetTeam();
        teamMap = setter.setTeam(option);
        break;
      } else {
        System.out.println("Incorrect option");
      }
    }
    System.out.println("Your team:");
    for (Map.Entry<Developer, Integer> entry : teamMap.entrySet()) {
      System.out.println(entry.getKey().getQualification() + " " + entry.getValue());
    }
  }
}