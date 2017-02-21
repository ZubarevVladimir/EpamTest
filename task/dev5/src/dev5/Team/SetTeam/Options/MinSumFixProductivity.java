package dev5.Team.SetTeam.Options;

import dev5.Team.Team.Developers.Developer;
import java.util.*;

/**
 * Contains methods for pick team with minimal total salary accroding to given sum.
 */
public class MinSumFixProductivity {

  /**
   * Pick optimal team, which the cheapest according to given productivity.
   *
   * @param productivity value, which need get in accordance with condition.
   * @param teamList list, which contains all developers with different qualifications.
   * @return Map - contains team according to option.
   */
  public Map<Developer, Integer> setTeam(int productivity, List<Developer> teamList) {
    Map<Developer, Integer> teamMap = new HashMap<>();
    int indexDevelopers;
    indexDevelopers = searchNecessaryDeveloper(teamList, productivity);
    int developerCounter = 0;
    while (productivity >= searchMinProductivity(teamList)) {
      if (productivity - teamList.get(indexDevelopers).getProductivity() < 0) {
        teamMap.put(teamList.get(indexDevelopers), developerCounter);
        developerCounter = 0;
        indexDevelopers = searchNecessaryDeveloper(teamList, productivity);
      }
      productivity -= teamList.get(indexDevelopers).getProductivity();
      developerCounter++;
      teamMap.put(teamList.get(indexDevelopers), developerCounter);
    }
    return teamMap;
  }

  /**
   * Search developer, which has the best price/productivity division and acceptable productivity.
   *
   * @param teamList list, which contains all developers with different qualifications.
   * @param productivity value for compare. Search developer with productivity more than it value.
   * @return int - index searched developer in given list.
   */
  private int searchNecessaryDeveloper(List<Developer> teamList, double productivity) {
    List<Double> priceIndexList = new ArrayList<>();
    for (Developer developer : teamList) {
      priceIndexList.add(developer.getPriceIndex());
    }
    int indexDevelopers = 0;
    double minPriceIndex = teamList.get(0).getPriceIndex();
    for (int i = 0; i < priceIndexList.size(); i++) {
      if ((priceIndexList.get(i) < minPriceIndex) && (productivity >= teamList.get(i)
          .getProductivity())) {
        indexDevelopers = i;
      }
    }
    return indexDevelopers;
  }

  /**
   * Search minimal developers productivity in given list.
   *
   * @param teamList list, which contains all developers with different qualifications.
   * @return int minimal developers productivity in given list.
   */
  private int searchMinProductivity(List<Developer> teamList) {
    int minProductivity = teamList.get(0).getProductivity();
    for (Developer developer : teamList) {
      if (minProductivity > developer.getProductivity()) {
        minProductivity = developer.getProductivity();
      }
    }
    return minProductivity;
  }
}
