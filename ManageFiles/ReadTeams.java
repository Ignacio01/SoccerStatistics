package ManageFiles;

import Classes.Team;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 3/11/16.
 *
 * This class allows to read the file that contains all the teams.
 * The file of the teams is teams.txt which contains the name of the team and the points separated by a ";"
 * The teams are sorted alphabetically by their name
 *
 * Ex:
 *  Barcelona; 22
 *  Real Madrid; 24
 */
public class ReadTeams {

    private File readFile;

    /**
     * ReadContent opens the file that the program is going to read
     * @param fileName
     *  local file that the program is going to read
     * @return
     *  Returns a bufferedReader in case the file was found.
     *  Returns null in case the file was empty.
     */
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
     * GetTeams breaks down the file txt that contains the teams, and creates an arrayList
     * with the teams stored in the txt file. This class will call readContent to open the file txt
     *
     * @param fileName
     *  Is the name of the file to be open, this name will be passed to the class readContent.
     * @return
     *  returns an arraylist of all the Teams in the list with their respective points.
     */
    public static ArrayList<Team> getTeams(String fileName){

        BufferedReader br = readContent(fileName);
        if(readContent(fileName) == null){return null;}
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
