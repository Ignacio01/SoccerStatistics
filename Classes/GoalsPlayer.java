package Classes;

/**
 * Created by ignacioojanguren on 7/11/16.
 * This class allows us to create a class that will relate a player with the amount of goals scored, the total time a player
 * has played, and the average time it takes a player to score a gole measured in match time, where a match time is 90 min.
 */
public class GoalsPlayer {
    
    private Player player;
    private int goals;
    private int timePlayed;
    private String avgGoalGame;

    public GoalsPlayer(Player player, int goals, int timePlayed, String avgGoalGame){
        this.player = player;
        this.goals = goals;
        this.timePlayed = timePlayed;
        this.avgGoalGame = avgGoalGame;
    }

    public void setPlayer (Player player){this.player = player;}
    public void setGoals (int goals){this.goals = goals;}
    public void setTimePlayed (int timePlayed){this.timePlayed = timePlayed;}
    public void setAvgGoalGame (String avgGoalGame){this.avgGoalGame = avgGoalGame;}

    public int getGoals() {return goals;}
    public int getTimePlayed() {return timePlayed;}
    public Player getPlayer() {return player;}
    public String getAvgGoalGame() {return avgGoalGame;}
}
