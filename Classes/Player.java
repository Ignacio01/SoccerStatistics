package Classes;

/**
 * Created by ignacioojanguren on 3/11/16.
 *
 * This class contains the data of a player
 *  A player has a name.
 *  A player plays in a team.
 *  A player plays in a position.
 *  If the player is holder.
 *
 * The methods in the class are the getters and setters.
 * Also Override the class toString()
 */
public class Player {

    private String name;
    private Team team;
    private String position;
    private boolean holder;

    public Player(String name, Team team, String position, boolean holder){
        this.name = name;
        this.team = team;
        this.position = position;
        this.holder = holder;
    }

    public void setName(String name){this.name = name;}
    public void setTeam(Team team){this.team = team;}
    public void setPosition(String position){this.position = position;}

    public void setHolder(boolean holder) {this.holder = holder;}

    public String getName(){return this.name;}
    public Team getTeam(){return this.team;}
    public String getPosition(){return this.position;}
    public boolean getHolder(){return this.holder;}

    @Override
    public String toString(){return this.name + " plays in " + this.team + " as a " + this.position;}

}
