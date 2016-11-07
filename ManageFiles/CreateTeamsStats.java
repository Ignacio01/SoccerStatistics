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
 */
public class CreateTeamsStats {

    final static private String fileName = "File";

    /**
     * points, goals for, goals against
     * @param nameTeam
     * @param matches
     * @return
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

    public static Team obtainStats(String nameTeam, ArrayList<Match> matches){
        int goalsFor = CalculateMatches.calculateTotalGoals(nameTeam,matches);
        int goalsAgainst = CalculateMatches.calculateGoalsAgainst(nameTeam,matches);
        int victories = CreateTeamsStats.calculateVictories(nameTeam,matches);
        int ties = CreateTeamsStats.calculateTies(nameTeam,matches);
        int points = victories * 3 + ties;
        Team team = new Team(nameTeam, points, goalsFor, goalsAgainst);
        return team;
    }


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


    public static void getMatches(ArrayList<Match> matches){
        BufferedReader br = CreateTeamsStats.readContent();
        Team team;
        String teamName;
        try{
            PrintWriter writer = new PrintWriter
                    ("File", "UTF-8");
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
