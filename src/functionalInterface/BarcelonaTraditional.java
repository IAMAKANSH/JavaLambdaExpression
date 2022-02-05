package functionalInterface;

public class BarcelonaTraditional implements FootballClubInterface{
    @Override
    public String getFootballClubName() {
        return "FC Barcelona";
    }

    public static void main(String[] args) {

        BarcelonaTraditional bc=new BarcelonaTraditional();
        System.out.println(bc.getFootballClubName());
    }
}
