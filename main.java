import Calculation.CalculateMatches;
import Calculation.CalculationsTeams;
import Calculation.Probabilities;
import Classes.GoalsPlayer;
import Classes.Match;
import Classes.Player;
import Classes.Team;
import ManageFiles.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ignacioojanguren on 3/11/16.
 */
public class main {

    final static String fileTeams = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/teams.txt";
    final static String fileMatch = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/match.txt";
    final static String fileGoals = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/finalGoalPlayers.txt";
    final static String fileComunioPlayers = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/playersComunio";

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
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

        /**
         * Obtain statistics of the players.
         */

        ReadGoals allGoals = new ReadGoals();
        ArrayList<GoalsPlayer> goalsPlayers = ReadGoals.getGoals(fileGoals,listTeams);
        ArrayList<String> playersComunio = ReadComunioTeam.getPlayers(fileComunioPlayers);
        GoalsPlayer playerGoals;
        Team teamPlayer;

        System.out.println("Reading your Comunio Team:");

        goalsPlayers = allGoals.getGoals(fileGoals,listTeams);
        for(String playerName : playersComunio){
            playerGoals = allGoals.getPlayerGoals(playerName, goalsPlayers);

            System.out.print("Probability of " + playerName + " scoring playing 90 min: ");
            if(playerGoals != null){
                teamPlayer = playerGoals.getPlayer().getTeam();
                System.out.print(Probabilities.calculatePlayerGoalsInTeam(playerGoals,teamPlayer) + "% \n");
            }else{
                System.out.print("hasn't scored \n");
            }
        }
    }
}
