package dev5.Team.SetTeam;

import dev5.Team.SetTeam.Options.GetTeam;
import dev5.Team.SetTeam.Options.MaxProductivityFixSum;
import dev5.Team.SetTeam.Options.MinDevelopersFixProductivity;
import dev5.Team.SetTeam.Options.MinSumFixProductivity;
import dev5.Team.Team.*;
import dev5.Team.Team.Developers.*;
import java.util.*;

/**
 * Created by Владимир on 20.02.2017.
 */
public class SetTeam {

  public Map<Developer, Integer> setTeam(String option) {
    List<Developer> teamList = new ArrayList<>();
    Map<Developer, Integer> teamMap;
    TeamInitializer initializer = new TeamInitializer();
    initializer.setTeamList(teamList);
    GetTeam getter = new GetTeam();
    teamMap = getter.getNecessaryTeam(option,teamList);
    return teamMap;
  }
}

