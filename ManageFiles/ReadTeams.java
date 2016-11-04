package ManageFiles;

import Classes.Team;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 3/11/16.
 */
public class ReadTeams {

    private File readFile;

    private static BufferedReader readContent(String fileName){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(fileName));
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return br;
    }

    public static ArrayList<Team> getTeams(String fileName){

        BufferedReader br = readContent(fileName);
        String line;
        String[] lineSplit = {"",""};
        String nameTeam;
        int position = 0;

        ArrayList<Team> teamsList = new ArrayList<Team>();
        Team team1;

        try{
            while( (line = br.readLine()) != null){
                lineSplit = line.split(";");
                nameTeam = lineSplit[0];
                try{
                    position = Integer.parseInt(lineSplit[1]);
                }catch(NumberFormatException nf){
                    nf.printStackTrace();
                }
                team1 = new Team(nameTeam, position);
                teamsList.add(team1);
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
        return teamsList;
    }



}
