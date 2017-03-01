package dev5.Team.SetTeam.Options;

import dev5.Team.Team.Developers.Developer;
import java.util.*;

/**
 * Contains linking method.
 */
public class GetTeam {

  /**
   * Call calculates methods for pick team according to given option.
   *
   * @param option String, which contains necessary option for pick team.
   * @param teamList list, which contains all developers with different qualifications.
   * @return Map - contains developers with them optimal numbers according to given option.
   */
  public Map<Developer, Integer> getNecessaryTeam(String option, List<Developer> teamList) {
    Map<Developer, Integer> teamMap = new HashMap<>();
    MinSumFixProductivity setterTwo = new MinSumFixProductivity();
    MaxProductivityFixSum setterOne = new MaxProductivityFixSum();
    MinDevelopersFixProductivity setterThree = new MinDevelopersFixProductivity();
    if (option.equals("1")) {
      System.out.println("Enter sum: ");
      int sum;
      for (; ; ) {
        try {
          Scanner input = new Scanner(System.in);
          sum = input.nextInt();
          break;
        } catch (InputMismatchException ex) {
          System.out.println("Enter correct sum");
        }
      }
      teamMap = setterOne.setTeam(sum, teamList);
    } else if (option.equals("2")) {
      System.out.println("Enter productivity: ");
      int productivity;
      for (; ; ) {
        try {
          Scanner input = new Scanner(System.in);
          productivity = input.nextInt();
          break;
        } catch (InputMismatchException ex) {
          System.out.println("Enter correct productivity");
        }
      }
      teamMap = setterTwo.setTeam(productivity, teamList);
    } else if (option.equals("3")) {
      System.out.println("Enter productivity: ");
      int productivity;
      for (; ; ) {
        try {
          Scanner input = new Scanner(System.in);
          productivity = input.nextInt();
          break;
        } catch (InputMismatchException ex) {
          System.out.println("Enter correct productivity");
        }
      }
      teamMap = setterThree.setTeam(productivity, teamList);
    }
    return teamMap;
  }
}
