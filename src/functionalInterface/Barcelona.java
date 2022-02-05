package functionalInterface;

public class Barcelona implements FootballClubInterface{
    @Override
    public String getFootballClubName() {
        return "FC Barcelona";
    }

    public static void main(String[] args) {

        Barcelona bc=new Barcelona();
        System.out.println(bc.getFootballClubName());
    }
}
