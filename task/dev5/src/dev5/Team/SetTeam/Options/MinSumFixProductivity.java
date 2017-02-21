package dev5.Team.SetTeam.Options;

import dev5.Team.Team.Developers.Developer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Владимир on 20.02.2017.
 */
public class MinSumFixProductivity {

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
