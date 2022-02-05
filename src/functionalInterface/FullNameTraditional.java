package functionalInterface;

import java.util.Scanner;

public class FullNameTraditional implements FullNameInterface{
    @Override
    public String getFullName(String firstName, String lastName) {
        return firstName+" "+lastName;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String firstName= sc.nextLine();
        String lastName= sc.nextLine();
        FullNameTraditional fullNameTraditional=new FullNameTraditional();
        System.out.println(fullNameTraditional.getFullName(firstName,lastName));
    }
}
