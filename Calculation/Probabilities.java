package Calculation;

import Classes.GoalsPlayer;
import Classes.Player;
import Classes.Team;

/**
 * Created by ignacioojanguren on 8/11/16.
 */
public class Probabilities {

    /**
     * This method calculates the probability a player has to score.
     * It is not a very accurate calculation, as the percentage is only calculated given the total goals of the
     * team how many goals has that player scored.
     * This is not very accurate, because even if a player hasn't scored, the player has a probability to score a goal.
     * @param goalsPlayer
     *  This class contains the goals of a player and the name of the player that scored the goals.
     * @param team
     *  The class team contains all the goals that team has scored.
     * @return
     *  Returns a doube with the probability a player has to score.
     */
    public static double calculatePlayerGoalsInTeam(GoalsPlayer goalsPlayer, Team team){
        double probability = 0;
        int minutesPlayed = goalsPlayer.getTimePlayed(), numberGoals = goalsPlayer.getGoals(), goalsTeam = team.getGoalsFor();

        probability = (numberGoals * 100) / goalsTeam;

        return probability;
    }

    public static double calculatePlayerScoresToTeam(Player player, Team team, GoalsPlayer goalsPlayer){
        return 0.0;
    }

}
