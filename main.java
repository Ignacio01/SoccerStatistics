import Calculation.CalculateMatches;
import Calculation.CalculationsTeams;
import Classes.Match;
import Classes.Team;
import ManageFiles.CreateTeamsStats;
import ManageFiles.ReadMatches;
import ManageFiles.ReadTeams;

import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 3/11/16.
 */
public class main {
    final static String fileTeams = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/teams.txt";
    final static String fileMatch = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/match.txt";
    final static String fileGoals = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/finalGoalPlayers.txt";
    public static void main(String[] args){
        ArrayList<Team> listTeams = ReadTeams.getTeams(fileTeams);
        System.out.println("The team leading the league is:");
        System.out.println(CalculationsTeams.topTeam(listTeams).toString());

        ArrayList<Match> listMatches = ReadMatches.getMatches(fileMatch,listTeams);

        /* Recalculate points
        CreateTeamsStats.getMatches(listMatches);*/

        CalculationsTeams.sortTeamsPoints(listTeams);
        CalculationsTeams.printTeams(listTeams);

        System.out.println("Barcelona goals at home: " + CalculateMatches.calculateGoalsLocal("Barcelona",listMatches));
        System.out.println("Barcelona goals not at home: " + CalculateMatches.calculateGoalsVisitant("Barcelona",listMatches));
        System.out.println("Total goals Barcelona: " + CalculateMatches.calculateTotalGoals("Barcelona",listMatches));
        System.out.println("Total goals against Barcelona: " + CalculateMatches.calculateGoalsAgainst("Barcelona",listMatches));
        System.out.println("Victories Barcelona: " + CreateTeamsStats.calculateVictories("Barcelona", listMatches));
        System.out.println("Ties Barcelona: " + CreateTeamsStats.calculateTies("Barcelona", listMatches));



        System.out.println("Probability Messi has to Score: ");
    }
}
