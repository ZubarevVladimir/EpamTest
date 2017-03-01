package dev5.Team.SetTeam;

import dev5.Team.Developers.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Владимир on 20.02.2017.
 */
public class MinDevelopersFixProductivity {

  static final String USELESS_QUALIFICATION = "junior";

  public Map<Developer, Integer> setTeam(int productivity, List<Developer> teamList) {
    Map<Developer, Integer> teamMap = new HashMap<>();
    teamList = deleteDeveloper(teamList, USELESS_QUALIFICATION);
    int indexDevelopers = searchNecessaryDeveloper(teamList, productivity);
    int developerCounter = 1;
    int minProductivity = searchMinProductivity(teamList);
    while (productivity >= minProductivity) {
      if ((productivity - (teamList.get(indexDevelopers).getProductivity())
          < minProductivity) && (productivity - teamList.get(indexDevelopers).getProductivity()
          != 0)) {
        teamMap.put(teamList.get(indexDevelopers), developerCounter);
        developerCounter = 0;
        indexDevelopers = searchNecessaryDeveloper(teamList, productivity);
        developerCounter++;
      } else if (productivity - teamList.get(indexDevelopers).getProductivity() == 0) {
        teamMap.put(teamList.get(indexDevelopers), developerCounter);
        break;
      } else if (
          (productivity - (2 * (teamList.get(indexDevelopers).getProductivity())) < minProductivity)
              && (productivity - (2 * teamList.get(indexDevelopers).getProductivity()) != 0)) {
        if (((productivity - (teamList.get(indexDevelopers).getProductivity())
            > minProductivity))) {
          productivity -= teamList.get(indexDevelopers).getProductivity();
          teamMap.put(teamList.get(indexDevelopers), developerCounter);
          teamList = deleteDeveloper(teamList, teamList.get(indexDevelopers).getQualification());
          indexDevelopers = searchNecessaryDeveloper(teamList, productivity);
          developerCounter = 0;
          developerCounter++;
        }
      } else {
        developerCounter++;
      }
      productivity -= teamList.get(indexDevelopers).getProductivity();
      teamMap.put(teamList.get(indexDevelopers), developerCounter);
    }
    return teamMap;
  }

  private List<Developer> deleteDeveloper(List<Developer> teamList, String qualification) {
    for (int i = teamList.size() - 1; i >= 0; i--) {
      if ((teamList.get(i).getQualification().toLowerCase().equals(qualification.toLowerCase()))) {
        teamList.remove(teamList.get(i));
      }
    }
    return teamList;
  }

  private int searchNecessaryDeveloper(List<Developer> teamList, int productivity) {
    List<Double> priceIndexList = new ArrayList<>();
    for (Developer developer : teamList) {
      priceIndexList.add(developer.getPriceIndex());
    }
    int indexDevelopers = 0;
    int maxProductivity = teamList.get(0).getProductivity();
    for (int i = 0; i < priceIndexList.size(); i++) {
      if ((teamList.get(i).getProductivity() > maxProductivity) && (
          productivity >= teamList.get(i)
              .getProductivity())) {
        maxProductivity = teamList.get(i).getProductivity();
        indexDevelopers = i;
      }
    }
    return indexDevelopers;
  }

  private int searchMinProductivity(List<Developer> teamList) {
    int minProductivity = teamList.get(1).getProductivity();
    for (Developer developer : teamList) {
      if (minProductivity > developer.getProductivity()) {
        minProductivity = developer.getProductivity();
      }
    }
    return minProductivity;
  }
}