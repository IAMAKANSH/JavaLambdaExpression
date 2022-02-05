package model;

public class League {

    private  String leagueName;
    private  Integer noOfMatchesPlayed;
    private Integer noOfMatchesWon;
    private Integer noOfMatchesLost;
    private Integer noOfMatchesDraw;
    private Integer noOfGoalsScored;
    private Integer noOfGoalsConceded;
    private Integer points;

    public League() {
        this.noOfMatchesDraw=0;
        this.noOfMatchesPlayed=0;
        this.noOfGoalsConceded=0;
        this.noOfMatchesLost=0;
        this.noOfGoalsScored=0;
    }

    public League(String leagueName, Integer noOfMatchesPlayed, Integer noOfMatchesWon, Integer noOfMatchesLost, Integer noOfGoalsScored, Integer noOfGoalsConceded,
                  Integer noOfMatchesDraw) {
        this.leagueName = leagueName;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
        this.noOfMatchesWon = noOfMatchesWon;
        this.noOfMatchesLost = noOfMatchesLost;
        this.noOfGoalsScored = noOfGoalsScored;
        this.noOfGoalsConceded = noOfGoalsConceded;
        this.noOfMatchesDraw= noOfMatchesDraw;
        this.points=getPoints();
    }

    public String getLeagueName() {
        return leagueName;
    }

    public Integer getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public Integer getNoOfMatchesWon() {
        return noOfMatchesWon;
    }

    public Integer getNoOfMatchesLost() {
        return noOfMatchesLost;
    }

    public Integer getNoOfMatchesDraw() {
        return noOfMatchesDraw;
    }

    public Integer getNoOfGoalsScored() {
        return noOfGoalsScored;
    }

    public Integer getNoOfGoalsConceded() {
        return noOfGoalsConceded;
    }

    public Integer getPoints() {
        return this.noOfMatchesWon*3+this.noOfMatchesDraw;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setNoOfMatchesPlayed(Integer noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public void setNoOfMatchesWon(Integer noOfMatchesWon) {
        this.noOfMatchesWon = noOfMatchesWon;
    }

    public void setNoOfMatchesLost(Integer noOfMatchesLost) {
        this.noOfMatchesLost = noOfMatchesLost;
    }

    public void setNoOfMatchesDraw(Integer noOfMatchesDraw) {
        this.noOfMatchesDraw = noOfMatchesDraw;
    }

    public void setNoOfGoalsScored(Integer noOfGoalsScored) {
        this.noOfGoalsScored = noOfGoalsScored;
    }

    public void setNoOfGoalsConceded(Integer noOfGoalsConceded) {
        this.noOfGoalsConceded = noOfGoalsConceded;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueName='" + leagueName + '\'' +
                ", noOfMatchesPlayed=" + noOfMatchesPlayed +
                ", noOfMatchesWon=" + noOfMatchesWon +
                ", noOfMatchesLost=" + noOfMatchesLost +
                ", noOfMatchesDraw=" + noOfMatchesDraw +
                ", noOfGoalsScored=" + noOfGoalsScored +
                ", noOfGoalsConceded=" + noOfGoalsConceded +
                ", points=" + points +
                '}';
    }
}
