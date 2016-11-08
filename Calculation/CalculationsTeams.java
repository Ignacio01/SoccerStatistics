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

<<<<<<< HEAD
    /**
     * Order the teams from the file teams.txt in order in function of the points they have
     * @param teams
     *  Arraylist which contains all the teams in the league 2016-2017
     * @return
     *  returns the arraylist of the teams but sorted by the points they have
     */
=======
>>>>>>> master
    public static ArrayList<Team> sortTeamsPoints(ArrayList<Team> teams){
        Collections.sort(teams);
        return teams;
    }

<<<<<<< HEAD
    /**
     * FindTeam allows you to find the information of the team you want to search
     * @param nameTeam
     *  This is the name of the team you want to search.
     * @param teams
     *  ArrayList that contains all the teams
     * @return
     *  Returns the class of the Team you wanted to find.
     */
=======
>>>>>>> master
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

<<<<<<< HEAD
    /**
     * This class prints all the team in the console
     * @param teams
     *  You pass the arraylist of all the teams
     * @postcondition
     *  All the teams stored in the arraylist have been printed on the console.
     */
=======
>>>>>>> master
    public static void printTeams(ArrayList<Team> teams){
        int counter = 1;
        for (Team team: teams){
            System.out.println(counter + ") " + team.toString());
            counter++;
        }
    }

}
