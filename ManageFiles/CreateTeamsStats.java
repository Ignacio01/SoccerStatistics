package ManageFiles;

import Calculation.CalculateMatches;
import Calculation.CalculationsTeams;
import Classes.Match;
import Classes.Team;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ignacioojanguren on 7/11/16.
 *
 * This class calculates the statistics of a team.
 * To be able to create the statistics of every team, first it needs to analyze the results from all the matches
 * played until today. Once the points, goals for and goals against are calculated, it overides the file teamInfo with the
 * new values of new matches.
 */
public class CreateTeamsStats {

    final static private String fileName = "/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/nameTeams.txt";

    /**
     * CalculateVictories calculate the number of victories of a team.
     * Given the victories we will be able to calculation the points win.
     * @param nameTeam
     *  nameTeam is the name of the team we want to calculate the number of victories
     * @param matches
     *  Arraylist that contains all the information from all the matches played until today
     * @return
     *  returns an integer with the number of victories a team has.
     */
    public static int calculateVictories(String nameTeam, ArrayList<Match> matches){
        int victories = 0;
        for(Match match: matches){
            if(match.getLocalTeam().getName().equals(nameTeam)){
                if(match.getGoalLocal()>match.getGoalVisitant()){victories++;}
            }
            if(match.getVisitantTeam().getName().equals(nameTeam)){
                if(match.getGoalVisitant()>match.getGoalLocal()){victories++;}
            }
        }
        return victories;
    }

    /**
     * Similar to calculateVictories; however, it calculates the number of ties a team had, with this we will be
     * able how many points the team has due to ties.
     * @param nameTeam
     *  Name of the team we want to calculate the ties.
     * @param matches
     *  Arraylist containing all the information with all the matches played until today
     * @return
     *  Returns an integer with the number of ties a team has
     */
    public static int calculateTies(String nameTeam, ArrayList<Match> matches){
        int ties = 0;
        for(Match match: matches){
            if(match.getLocalTeam().getName().equals(nameTeam)){
                if(match.getGoalLocal() == match.getGoalVisitant()){ties++;}
            }
            if(match.getVisitantTeam().getName().equals(nameTeam)){
                if(match.getGoalVisitant()==match.getGoalLocal()){ties++;}
            }
        }
        return ties;
    }

    /**
     * This method returns all the statistic a Team can have. A team has points, goalsFor, goalsAgainst.
     * This method will allow us to recalculate the points of a team and goal everytime a game is played.
     * @param nameTeam
     *  Name of the team we want to calculate the statistics
     * @param matches
     *  Arraylist with the information of all the matches played
     * @return
     *  Returns a class team with all the information needed of the team.
     */
    public static Team obtainStats(String nameTeam, ArrayList<Match> matches){
        int goalsFor = CalculateMatches.calculateTotalGoals(nameTeam,matches);
        int goalsAgainst = CalculateMatches.calculateGoalsAgainst(nameTeam,matches);
        int victories = CreateTeamsStats.calculateVictories(nameTeam,matches);
        int ties = CreateTeamsStats.calculateTies(nameTeam,matches);
        int points = victories * 3 + ties;
        Team team = new Team(nameTeam, points, goalsFor, goalsAgainst);
        return team;
    }

    /**
     *  This class contains the buffered reader to allow to read the Final file declared at the begining of this class
     * @return
     *  returns the bufferedReader so getMatches can make operations on the readings.
     */
    private static BufferedReader readContent(){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(fileName));
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            return null;
        }
        return br;
    }

    /**
     * This class will read all the teams playing in La liga, contained in the file teamsInfo.txt
     * Given all the teams, the program will obtain the stats of each of them by calculating their statistics.
     * @param matches
     *  Arraylist containing all the information from all the matches
     * @postcondition
     *  The new results in points and goals will be writen in the document teams.txt
     */
    public static void getMatches(ArrayList<Match> matches){
        BufferedReader br = CreateTeamsStats.readContent();
        Team team;
        String teamName;
        try{
            PrintWriter writer = new PrintWriter
                    ("/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/teams.txt", "UTF-8");
            while( (teamName = br.readLine()) != null){
                team = obtainStats(teamName, matches);
                writer.write(team.getName()+";"+team.getPoints()+";"+team.getGoalsFor()+";"+ team.getGoalsAgainst() + "\n");
            }
            writer.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                if (br != null)br.close();
            }catch (IOException close){
                close.printStackTrace();
            }
        }
    }
}
