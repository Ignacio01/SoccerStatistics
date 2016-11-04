package Classes;

/**
 * Created by ignacioojanguren on 3/11/16.
 * This class describes a team, and the most important values to know the position in the league.
 * What is needed is the name of the team, the points and the goals it has scored in total.
 * This class contains the getters and the setters.
 */
public class Team {
    private String name;
    private int points;
    private int numberGoals; //Will be calculated by adding all the goals from all the players in its team.

    public Team(String name, int position){
        this.name = name;
        this.points = position;
    }

    public void setName(String name){this.name = name;}
    public void setPosition(int position){this.points = position;}
    public String getName(){return this.name;}
    public int getPosition(){return this.points;}

    @Override
    public String toString(){return name + ", " + points + " points.";}
}
