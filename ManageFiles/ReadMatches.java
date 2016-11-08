package ManageFiles;

import Calculation.CalculationsTeams;
import Classes.Match;
import Classes.Team;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ignacioojanguren on 4/11/16.
 */
public class ReadMatches {

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
    public static ArrayList<Match> getMatches(String fileName, ArrayList<Team> teams){

        BufferedReader br = readContent(fileName);
        if(readContent(fileName) == null){return null;}
        String line;
        String[] lineSplit = {""};
        Date dateMatch = null;
        String season = "", result = "";
        String[]resultMatch;
        Team localTeam = null,visitantTeam = null;
        int goalLocal = 0, goalVisitant = 0;


        ArrayList<Match> matchsList = new ArrayList<Match>();
        Match match;

        try{
            while( (line = br.readLine()) != null){
                if(line.charAt(0) != '#'){
                    lineSplit = line.split(";");
                    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    try{

                        dateMatch = formatter.parse(lineSplit[0]);
                        season = lineSplit[1];
                        localTeam = CalculationsTeams.findTeam(lineSplit[2],teams);
                        visitantTeam = CalculationsTeams.findTeam(lineSplit[3],teams);
                        result = lineSplit[4];
                        resultMatch = result.split("-");
                        goalLocal = Integer.parseInt(resultMatch[0].trim());
                        goalVisitant = Integer.parseInt(resultMatch[1].trim());

                    }catch(NumberFormatException nf){
                        nf.printStackTrace();
                    }catch (ParseException parse){
                        parse.printStackTrace();
                    }
                    if(goalLocal != 100 && goalVisitant != 100){
                        match = new Match(dateMatch,season,localTeam,visitantTeam,goalLocal,goalVisitant);
                        matchsList.add(match);
                    }

                }
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
        return matchsList;
    }
}
