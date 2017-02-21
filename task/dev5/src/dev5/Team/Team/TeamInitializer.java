package dev5.Team.Team;

import dev5.Team.Team.Developers.Developer;
import dev5.Team.Team.Developers.Junior;
import dev5.Team.Team.Developers.Lead;
import dev5.Team.Team.Developers.Middle;
import dev5.Team.Team.Developers.Senior;
import java.util.List;

/**
 * Created by Владимир on 21.02.2017.
 */
public class TeamInitializer {

  public List<Developer> setTeamList(List<Developer> teamList) {
    Junior junior = new Junior(1, 500);
    Middle middle = new Middle(2, 980);
    Senior senior = new Senior(3, 1450);
    Lead lead = new Lead(4, 1900);
    teamList.add(junior);
    teamList.add(middle);
    teamList.add(senior);
    teamList.add(lead);
    return teamList;
  }
}

