package Classes;

/**
 * Created by ignacioojanguren on 3/11/16.
 */
public class Team {
    private String name;
    private int points;

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
