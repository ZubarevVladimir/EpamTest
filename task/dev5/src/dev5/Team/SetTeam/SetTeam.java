package dev5.Team.SetTeam;

import dev5.Team.SetTeam.Options.GetTeam;
import dev5.Team.Team.*;
import dev5.Team.Team.Developers.*;
import java.util.*;

/**
 * Contains manage-method.
 */
public class SetTeam {

  /**
   * Combine other classes for pick team according to given option.
   *
   * @param option String, which contains necessary option for pick team.
   * @return Map - contains developers with them optimal numbers according to given option.
   */
  public Map<Developer, Integer> setTeam(String option) {
    List<Developer> teamList = new ArrayList<>();
    Map<Developer, Integer> teamMap;
    TeamInitializer initializer = new TeamInitializer();
    initializer.setTeamList(teamList);
    GetTeam getter = new GetTeam();
    teamMap = getter.getNecessaryTeam(option, teamList);
    return teamMap;
  }
}

