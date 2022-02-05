package model;

import java.util.List;

public class FootballTeam {

    private String name;
    private List<String> players;
    private List<League> leagues;
    private  Integer overallRanking;

    public FootballTeam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    public Integer getOverallRanking() {
        return overallRanking;
    }

    public void setOverallRanking(Integer overallRanking) {
        this.overallRanking = overallRanking;
    }

    public FootballTeam(String name, List<String> players, List<League> leagues, Integer overallRanking) {
        this.name = name;
        this.players = players;
        this.leagues = leagues;
        this.overallRanking = overallRanking;
    }

    @Override
    public String toString() {
        return "FootballTeam{" +
                "name='" + name + '\'' +
                ", players=" + players +
                ", leagues=" + leagues +
                ", overallRanking=" + overallRanking +
                '}';
    }
}
