package Calculation;

import Classes.Team;
import java.util.ArrayList;
import java.util.Collections;

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
     *  Arraylist that contains all the teams. This arraylist is obtained in the class ReadTeams and the method
     *  getTeams.
     * @return
     *  Returns the Teams that has the maximum amount of points and goals.
     */
    public static Team topTeam(ArrayList<Team> teams){
        Team topTeam = new Team("", 0, 0, 0);

        for(Team team: teams){
            if(topTeam.getPoints() < team.getPoints()){
                topTeam = team;
            }
        }
        return topTeam;
    }

    public static ArrayList<Team> sortTeamsPoints(ArrayList<Team> teams){
        Collections.sort(teams);
        return teams;
    }

    public static Team findTeam(String nameTeam, ArrayList<Team> teams){
        for(Team team: teams){
            if(team.getName().equals(nameTeam)){
                return team;
            }
        }
        return null;
    }

    /*public static double calculateProbabilityScoring(ArrayList<Team> teams, String nameTeam, Match nextMatch){
        double probability;


    }*/

    public static void printTeams(ArrayList<Team> teams){
        int counter = 1;
        for (Team team: teams){
            System.out.println(counter + ") " + team.toString());
            counter++;
        }
    }

}
