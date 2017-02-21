package dev5.Team.SetTeam;

import dev5.Team.Developers.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Владимир on 20.02.2017.
 */
public class SetTeam {

  public Map<Developer, Integer> setTeam(String option) {
    List<Developer> teamList = new ArrayList<>();
    Map<Developer, Integer> teamMap = new HashMap<>();
    initializeTeamList(teamList);
    MinSumFixProductivity setterTwo = new MinSumFixProductivity();
    MaxProductivityFixSum setterOne = new MaxProductivityFixSum();
    MinDevelopersFixProductivity setterThree = new MinDevelopersFixProductivity();
    Scanner in = new Scanner(System.in);
    if (option.equals("1")) {
      System.out.println("Enter sum: ");
      double sum = in.nextDouble();
      teamMap = setterOne.setTeam(sum, teamList);
    } else if (option.equals("2")) {
      System.out.println("Enter productivity: ");
      int productivity = in.nextInt();
      teamMap = setterTwo.setTeam(productivity, teamList);
    } else if (option.equals("3")) {
      System.out.println("Enter productivity: ");
      int productivity = in.nextInt();
      teamMap = setterThree.setTeam(productivity, teamList);
    }
    return teamMap;
  }

  private void printTeamList(List<Developer> teamList) {
    for (Developer developer : teamList) {
      developer.printDevelopersInfo();
    }
  }

  private List<Developer> initializeTeamList(List<Developer> teamList) {
    Developer junior = new Developer("Junior", 1, 500);
    Developer middle = new Developer("Middle", 2, 980);
    Developer senior = new Developer("Senior", 3, 1450);
    Developer lead = new Developer("Lead", 4, 1900);
    teamList.add(junior);
    teamList.add(middle);
    teamList.add(senior);
    teamList.add(lead);
    return teamList;
  }
}
