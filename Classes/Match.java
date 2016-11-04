package Classes;

import java.util.Date;

/**
 * Created by ignacioojanguren on 3/11/16.
 *
 * Match class contains the values from a match
 *  DateMatch is when the game is played.
 *  Season means the year of the league ex 2016-2017
 *  LocalTeam is the team that plays in their home
 *  VisitTeam is the team that plays in the other's team home
 *  Results is the final result of the match.
 *
 * This class contains the getters and setters to obtain the previous valious.
 */
public class Match {
    private Date dateMatch;
    private String season;
    private Team localTeam;
    private Team visitantTeam;
    private String result;

    public Match(Date dateMatch, String season, Team localTeam, Team visitantTeam, String result){
        this.dateMatch = dateMatch;
        this.season = season;
        this.localTeam = localTeam;
        this.visitantTeam = visitantTeam;
        this.result = result;
    }

    public Date getDateMatch() {return dateMatch;}
    public Team getLocalTeam() {return localTeam;}
    public String getResult() {return result;}
    public String getSeason() {return season;}
    public Team getVisitantTeam() {return visitantTeam;}
    public void setDateMatch(Date dateMatch) {this.dateMatch = dateMatch;}
    public void setLocalTeam(Team localTeam) {this.localTeam = localTeam;}
    public void setResult(String result) {this.result = result;}
    public void setSeason(String season) {this.season = season;}
    public void setVisitantTeam(Team visitantTeam) {this.visitantTeam = visitantTeam;}

    @Override
    public String toString(){return dateMatch + ";" + season + ";" + localTeam + ";" + visitantTeam + ";" +result;}
}
