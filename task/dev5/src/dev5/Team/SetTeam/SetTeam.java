package dev5.Team.SetTeam;

import dev5.Team.SetTeam.Options.MaxProductivityFixSum;
import dev5.Team.SetTeam.Options.MinDevelopersFixProductivity;
import dev5.Team.SetTeam.Options.MinSumFixProductivity;
import dev5.Team.Team.*;
import dev5.Team.Team.Developers.*;
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
    TeamInitializer initializer = new TeamInitializer();
    initializer.setTeamList(teamList);
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
}
