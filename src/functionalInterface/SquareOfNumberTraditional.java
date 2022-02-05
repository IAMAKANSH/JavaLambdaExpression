package functionalInterface;

import java.util.Scanner;

public class SquareOfNumberTraditional implements SquareOfNumber{
    @Override
    public Integer getSquareOfNumber(int number) {
        return number*number;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer number= sc.nextInt();
        SquareOfNumberTraditional squareOfNumber=new SquareOfNumberTraditional();
        System.out.println(squareOfNumber.getSquareOfNumber(number));
    }
}
