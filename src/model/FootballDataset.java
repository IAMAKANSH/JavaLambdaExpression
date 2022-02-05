package model;

import java.util.Arrays;
import java.util.List;

public class FootballDataset {

    public static List<FootballTeam> getAll()
    {
        FootballTeam barcelona=new FootballTeam("FC Barcelona", Arrays.asList("Luke Dijong",
                "Ter Stegan","Gerad Pique","Dani Alves","Eric Garcia","Lenglet","Ansu Fati","Dembele","Adama",
                "Busquets","Jodi Alba"),Arrays.asList(new League("LaLiga",10,9,1,25,18,0)),
                1);
        FootballTeam realMadrid=new FootballTeam("Real Madrid", Arrays.asList("Carvajal",
                "Curtosis","Alaba","Benzema","Hazard","Kroos","Modric","Casemiro","Vasquez",
                "Asensio","Junior"),Arrays.asList(new League("LaLiga",10,8,1,30,26,1)),
                3);
        FootballTeam atleticoMadrid=new FootballTeam("Atletice Madrid", Arrays.asList("Griezmann",
                "Oblak","Suarez","Lemar","Felix","Cararasco","Llorente","Lodi","Savic",
                "Herrera","Castilla"),Arrays.asList(new League("LaLiga",10,9,0,25,11,1)),
                2);
        FootballTeam psg=new FootballTeam("PSG", Arrays.asList("Lionel Messi",
                "Mbappe","Di Maria","Veratti","Ramos","Neymar","Icardi","Hakimi","Navas",
                "Kimpembe","Pereira"),Arrays.asList(new League("Ligue1",12,9,3,28,12,0)),
                4);
        FootballTeam machesterUnited=new FootballTeam("Manchester United", Arrays.asList("Ronaldo",
                "Varane","Greenword","Pogba","Felix","Bruno Fernandes","Lingard","Jones","Luke Shaw",
                "Sancho","DeGea"),Arrays.asList(new League("English Premier",10,5,4,10,32,1)),
                5);
        return Arrays.asList(barcelona,realMadrid,atleticoMadrid,psg,machesterUnited);
    }
}
