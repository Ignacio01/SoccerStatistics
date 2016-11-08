package ManageFiles;

import Classes.Player;
import Classes.Team;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 8/11/16.
 */
public class ReadGoals {

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


    public static ArrayList<Player> getGoals(String fileName,ArrayList<Team> teamsList){

        BufferedReader br = readContent(fileName);
        if(readContent(fileName) == null){return null;}
        String line, playerName = "", teamName = "", position = "";
        String[] lineSplit = {""};

        ArrayList<Player> playerList = new ArrayList<Player>();
        Player player;
        Team teamPlayer = null;

        try{
            while( (line = br.readLine()) != null){
                lineSplit = line.split(";");
                if(lineSplit[0].charAt(0) == '#'){teamName = lineSplit[0];}
                else{
                    for(Team team : teamsList){
                        if(teamName.contains(team.getName())){teamPlayer = team; break;}
                    }
                    playerName = lineSplit[0];
                    position = lineSplit[4];
                }
                player = new Player(playerName, teamPlayer, position);
                playerList.add(player);
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
        return playerList;
    }

}
