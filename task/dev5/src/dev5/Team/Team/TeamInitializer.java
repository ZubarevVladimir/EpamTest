package dev5.Team.Team;

import dev5.Team.Team.Developers.Developer;
import dev5.Team.Team.Developers.Junior;
import dev5.Team.Team.Developers.Lead;
import dev5.Team.Team.Developers.Middle;
import dev5.Team.Team.Developers.Senior;
import java.util.List;

/**
 * Contains method for initialize developers list.
 */
public class TeamInitializer {

  /**
   * Add developers in given list.
   *
   * @param teamList list, which contains all developers with different qualifications.
   */
  public void setTeamList(List<Developer> teamList) {
    Junior junior = new Junior(1, 500);
    Middle middle = new Middle(2, 980);
    Senior senior = new Senior(3, 1450);
    Lead lead = new Lead(4, 1900);
    teamList.add(junior);
    teamList.add(middle);
    teamList.add(senior);
    teamList.add(lead);
  }
}

