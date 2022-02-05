package functionalInterface;

public class BarcelonaLambda {

    public static void main(String[] args) {
        //implementing the football club using lambda
        FootballClubInterface clubInterface=()->{
            return "FC Barcelona";
        };
        System.out.println(clubInterface);

        //Simplify even further
        FootballClubInterface clubInterface1=() -> "FC Barcelona B";
        System.out.println(clubInterface1);
    }
}
