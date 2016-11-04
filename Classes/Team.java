package Classes;
import java.util.Comparator;

/**
 * Created by ignacioojanguren on 3/11/16.
 * This class describes a team, and the most important values to know the position in the league.
 * What is needed is the name of the team, the points and the goals it has scored in total.
 * This class contains the getters and the setters.
 */
public class Team implements Comparable<Team> {
    private String name;
    private Integer points;
    private int goalsFor; //Will be calculated by adding all the goals from all the players in its team.
    private int goalsAgainst;

    public Team(String name, int points, int goalsFor, int goalsAgainst){
        this.name = name;
        this.points = points;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public void setName(String name){this.name = name;}
    public void setPoints(int points){this.points = points;}
    public void setGoalsFor(int goalsFor){this.goalsFor = goalsFor;}
    public void setGoalsAgainst(int goalsAgainst){this.goalsAgainst = goalsAgainst;}
    public String getName(){return this.name;}
    public int getPoints(){return this.points;}
    public int getGoalsFor(){return this.goalsFor;}
    public int getGoalsAgainst(){return  this.goalsAgainst;}

    @Override
    public String toString(){return name + "; " + points + " points;  G.F. " + goalsFor + "; G.A. " + goalsAgainst;}

    @Override
    public int compareTo(Team team){
        int lastTeam = points.compareTo(team.getPoints());
        if(lastTeam != 0){
            lastTeam = team.points.compareTo(this.getPoints());
        }
        return lastTeam;
    }
}
