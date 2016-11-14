package ManageFiles;

import Classes.GoalsPlayer;
import Classes.Player;
import Classes.Team;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ignacioojanguren on 8/11/16.
 */
public class ReadGoals {

    public ReadGoals(){
    }

    private static BufferedReader readContent(String fileName){
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
     * This class obtains from every player all the goals he has scored.
     * @param fileName
     * @param teamsList
     * @return
     */
    public static ArrayList<GoalsPlayer> getGoals(String fileName, ArrayList<Team> teamsList){

        BufferedReader br = readContent(fileName);
        BufferedReader brTeams = readContent("/Users/ignacioojanguren/IdeaProjects/StatisticsFutbol/src/text/nameTeams.txt");
        if(readContent(fileName) == null){return null;}
        String line, playerName = "", teamName = "", position = "", goals = "", minutesPlayed = "", avgGoal ="";
        String[] lineSplit = {""}, lineTeamSplit = {""};

        ArrayList<GoalsPlayer> goalsList = new ArrayList<GoalsPlayer>();
        HashMap<String,String> teamAbreviations = new HashMap<String,String>();
        GoalsPlayer goalPlayer;
        Player player;
        Team teamPlayer = null;

        try{
            while((line = brTeams.readLine()) != null){
                lineTeamSplit = line.split(";");
                teamAbreviations.put(lineTeamSplit[1], lineTeamSplit[0]);
            }

            while( (line = br.readLine()) != null){
                lineSplit = line.split(";");
                teamName = lineSplit[0];
                teamName = teamAbreviations.get(teamName);
                playerName = lineSplit[1];
                goals = lineSplit[2];
                minutesPlayed = lineSplit[3];
                avgGoal = lineSplit[4];
                for(Team team : teamsList) {
                    if (team.getName().equals(teamName)) {
                        teamPlayer = team;
                    }
                }
                player = new Player(playerName,teamPlayer,"unknown");
                goalPlayer = new GoalsPlayer(player, Integer.parseInt(goals), Integer.parseInt(minutesPlayed), avgGoal);
                goalsList.add(goalPlayer);
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }finally{
            try{
                if (br != null)br.close();
            }catch (IOException close){
                close.printStackTrace();
            }
        }
        return goalsList;
    }

    public static GoalsPlayer getPlayerGoals(String playerName, ArrayList<GoalsPlayer> playersGoals){
        for (GoalsPlayer goals : playersGoals){
            if(goals.getPlayer().getName().equals(playerName))return goals;
        }
        return null;
    }

}
