package Calculation;

import Classes.Match;
import Classes.Team;
import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 4/11/16.
 */
public class CalculateMatches {

    /*public static double percentageVictory(Team team1, Team team2){

    }*/

    public static int calculateGoalsLocal(String teamName,ArrayList<Match> matches){
        int totalGoals = 0;
        for(Match match : matches){
            if(match.getLocalTeam().getName().equals(teamName)){
                totalGoals += match.getGoalLocal();
            }
        }
        return totalGoals;
    }

    public static int calculateGoalsVisitant(String teamName,ArrayList<Match> matches){
        int totalGoals = 0;
        for(Match match : matches){
            /*if(match.getVisitantTeam() == null){
                System.out.println(match.toString());
            }*/
            if(match.getVisitantTeam().getName().equals(teamName)){
                totalGoals += match.getGoalVisitant();
            }
        }
        return totalGoals;
    }

}
