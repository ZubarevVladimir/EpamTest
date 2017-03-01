package dev5.Team.SetTeam;

import dev5.Team.Developers.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Владимир on 20.02.2017.
 */
public class MaxProductivityFixSum {

  public Map<Developer, Integer> setTeam(double sum, List<Developer> teamList) {
    Map<Developer, Integer> teamMap = new HashMap<>();
    int indexDevelopers = searchNecessaryDeveloper(teamList, sum);;
    int developerCounter = 0;
    while (sum > searchMinSalary(teamList)) {
      if (sum - teamList.get(indexDevelopers).getSalary() < 0) {
        teamMap.put(teamList.get(indexDevelopers), developerCounter);
        developerCounter = 0;
        indexDevelopers = searchNecessaryDeveloper(teamList, sum);
      }
      sum -= teamList.get(indexDevelopers).getSalary();
      developerCounter++;
      teamMap.put(teamList.get(indexDevelopers), developerCounter);
    }
    return teamMap;
  }

  private int searchNecessaryDeveloper(List<Developer> teamList, double sum) {
    List<Double> priceIndexList = new ArrayList<>();
    for (Developer developer : teamList) {
      priceIndexList.add(developer.getPriceIndex());
    }
    int indexDevelopers = 0;
    double minPriceIndex = teamList.get(0).getPriceIndex();
    for (int i = 0; i < priceIndexList.size(); i++) {
      if ((priceIndexList.get(i) < minPriceIndex) && (sum > teamList.get(i).getSalary())) {
        indexDevelopers = i;
      }
    }
    return indexDevelopers;
  }

  private double searchMinSalary(List<Developer> teamList) {
    double minSalary = teamList.get(0).getSalary();
    for (Developer developer : teamList) {
      if (minSalary > developer.getSalary()) {
        minSalary = developer.getSalary();
      }
    }
    return minSalary;
  }
}