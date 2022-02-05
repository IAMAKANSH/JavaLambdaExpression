package consumer;

import model.FootballDataset;
import model.FootballTeam;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {

    public static void main(String[] args) {

        List<FootballTeam> footballTeams= FootballDataset.getAll();

        //Looping though all the team and printing out the values of football team
        Consumer<FootballTeam> footballTeamConsumer=footballTeam -> System.out.println(footballTeam);

        for (FootballTeam result:
             footballTeams) {
            footballTeamConsumer.accept(result);

        }

        System.out.println("--------------------------------------------------------------------");

        //Looping through all the team and only printing football team
        Consumer<FootballTeam> footballTeamConsumer1=footballTeam -> System.out.println(footballTeam.getName());
        for (FootballTeam result:
                footballTeams) {
            footballTeamConsumer1.accept(result);

        }

        //Looping through all the football team and print out football team name and printing
        Consumer<FootballTeam>  footballTeamConsumer2=footballTeam -> System.out.println(footballTeam.getOverallRanking());
        footballTeams.forEach(footballTeamConsumer1.andThen(footballTeamConsumer2));

        //Looping through all the football team and print out football team name and league stats
        Consumer<FootballTeam>  footballTeamConsumer3=footballTeam -> System.out.println(footballTeam.getLeagues());
        footballTeams.forEach(footballTeamConsumer1.andThen(footballTeamConsumer3));

    }
}
