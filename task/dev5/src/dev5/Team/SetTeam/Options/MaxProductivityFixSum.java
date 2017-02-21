package dev5.Team.SetTeam.Options;

import dev5.Team.Team.Developers.Developer;
import java.util.*;

/**
 * Contains methods for pick team with maximal productivity according to given sum.
 */
public class MaxProductivityFixSum {

  /**
   * Choose optimal team, which has got maximal productivity according to given money.
   *
   * @param sum maximal total developers salary.
   * @param teamList list, which contains all developers with different qualifications.
   * @return Map - contains team according to option.
   */
  public Map<Developer, Integer> setTeam(int sum, List<Developer> teamList) {
    Map<Developer, Integer> teamMap = new HashMap<>();
    int indexDevelopers = searchNecessaryDeveloper(teamList, sum);
    int minSalary = searchMinSalary(teamList);
    int developerCounter = 0;
    while (sum > minSalary) {
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

  /**
   * Search developer, which has the best price/productivity division and acceptable salary.
   *
   * @param teamList list, which contains all developers with different qualifications.
   * @param sum maximal salary for searched developers .
   * @return int - index searched developer in given list.
   */
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

  /**
   * Search minimal developers salary in given list.
   *
   * @param teamList list, which contains all developers with different qualifications.
   * @return int minimal developers salary in given list.
   */
  private int searchMinSalary(List<Developer> teamList) {
    int minSalary = teamList.get(0).getSalary();
    for (Developer developer : teamList) {
      if (minSalary > developer.getSalary()) {
        minSalary = developer.getSalary();
      }
    }
    return minSalary;
  }
}