import Calculation.CalculationsTeams;
import Classes.Team;
import ManageFiles.ReadTeams;

import java.util.ArrayList;

/**
 * Created by ignacioojanguren on 3/11/16.
 */
public class main {
    final static String fileTeams = "FILE";
    public static void main(String[] args){
        ArrayList<Team> listTeams = ReadTeams.getTeams(fileTeams);
        System.out.println("The team leading the league is:");
        System.out.println(CalculationsTeams.topTeam(listTeams).toString());

        CalculationsTeams.sortTeamsPoints(listTeams);
        CalculationsTeams.printTeams(listTeams);

    }
}
