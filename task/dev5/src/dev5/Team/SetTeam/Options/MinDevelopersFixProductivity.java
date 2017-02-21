package dev5.Team.SetTeam.Options;

import dev5.Team.Team.Developers.Developer;
import java.util.*;

/**
 * Contains methods for pick team with minimal number developers without some developers
 * qualification in fixed productivity.
 */
public class MinDevelopersFixProductivity {

  static final String USELESS_QUALIFICATION = "junior";

  /**
   * Pick optimal team, which has got minimal number developers according to given productivity.
   *
   * @param productivity value, which need get in accordance with condition.
   * @param teamList list, which contains all developers with different qualifications.
   * @return Map - contains team according to option.
   */
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

  /**
   * Delete given developers qualification in given list.
   *
   * @param teamList list, which contains all developers with different qualifications.
   * @param qualification deleted qualification.
   * @return List list without developers with given qualification.
   */
  private List<Developer> deleteDeveloper(List<Developer> teamList, String qualification) {
    for (int i = teamList.size() - 1; i >= 0; i--) {
      if ((teamList.get(i).getQualification().toLowerCase().equals(qualification.toLowerCase()))) {
        teamList.remove(teamList.get(i));
      }
    }
    return teamList;
  }

  /**
   * Search developer, which has the best and acceptable productivity.
   *
   * @param teamList list, which contains all developers with different qualifications.
   * @param productivity value for compare. Search developer with productivity more than it value.
   * @return int - index searched developer in given list.
   */
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

  /**
   * Search minimal developers productivity in given list.
   *
   * @param teamList list, which contains all developers with different qualifications.
   * @return int minimal developers productivity in given list.
   */
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