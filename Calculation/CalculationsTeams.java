package Calculation;

import Classes.Team;

import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 3/11/16.
 *
 * This class contains all the possible calculations we can do with the teams, like:
 *  Getting the first team.
 *  Sorting the teams by points.
 *
 */
public class CalculationsTeams {

    /**
     * This class returns the team that is winning by points.
     * @param teams
     *  getTeams.
     * @return
     *  Returns the Teams that has the maximum amount of points and goals.
     */
    public static Team topTeam(ArrayList<Team> teams){
        Team topTeam = new Team("", 0);

        for(Team team: teams){
            if(topTeam.getPosition() < team.getPosition()){
                topTeam = team;
            }
        }
        return topTeam;
    }

}
