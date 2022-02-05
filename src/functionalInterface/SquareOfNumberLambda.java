package functionalInterface;

import java.util.Scanner;

public class SquareOfNumberLambda {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Integer req= sc.nextInt();
        SquareOfNumber squareOfNumber=number -> number*number;
        System.out.println(squareOfNumber.getSquareOfNumber(req));
    }
}
