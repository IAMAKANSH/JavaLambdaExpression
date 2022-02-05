package functionalInterface;

import java.util.Scanner;

public class FullNameLambda {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String firstName= sc.nextLine();
        String lastName= sc.nextLine();
        FullNameInterface fullNameInterface=(firstName1, lastName1) -> firstName1+ " "+lastName1;
        System.out.println(fullNameInterface.getFullName(firstName,lastName));
    }
}
