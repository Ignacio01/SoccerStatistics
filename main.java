import Calculation.CalculateMatches;
import Calculation.CalculationsTeams;
import Classes.Match;
import Classes.Team;
import ManageFiles.ReadMatches;
import ManageFiles.ReadTeams;

import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 3/11/16.
 */
public class main {
    final static String fileTeams = "File";
    final static String fileMatch = "File";
    public static void main(String[] args){
        ArrayList<Team> listTeams = ReadTeams.getTeams(fileTeams);
        System.out.println("The team leading the league is:");
        System.out.println(CalculationsTeams.topTeam(listTeams).toString());

        CalculationsTeams.sortTeamsPoints(listTeams);
        CalculationsTeams.printTeams(listTeams);

        ArrayList<Match> listMatches = ReadMatches.getMatches(fileMatch,listTeams);
        System.out.println("Barcelona goals at home: " + CalculateMatches.calculateGoalsLocal("Barcelona",listMatches));
        System.out.println("Barcelona goals not at home: " + CalculateMatches.calculateGoalsVisitant("Barcelona",listMatches));
    }
}
