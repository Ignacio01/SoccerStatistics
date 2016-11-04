package Calculation;

import Classes.Team;

import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 3/11/16.
 */
public class CalculationsTeams {

    public static Team topTeams(ArrayList<Team> teams){
        Team topTeam = new Team("", 0);

        for(Team team: teams){
            if(topTeam.getPosition() < team.getPosition()){
                topTeam = team;
            }
        }
        return topTeam;
    }

}
