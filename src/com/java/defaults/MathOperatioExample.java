package com.java.defaults;

public class MathOperatioExample  implements Calculator{

    public static void main(String[] args) {

        MathOperatioExample mathOperatioExample=new MathOperatioExample();
        System.out.println("Sum: "+mathOperatioExample.sum(10,15));
//        System.out.println("Divide: "+mathOperatioExample.division(4,2));
        System.out.println("-------------------");
        //our implementation using lambda expression for sum and divide
        Calculator calculator=(num1,num2)->num1%num2;
        System.out.println("Calculator overidding using Lambda: "+calculator.sum(3,2));

        System.out.println("Substract :: "+mathOperatioExample.substract(4,2));
        System.out.println("Multiply :: "+Calculator.multiply(2,2));
    }
    @Override
    public int sum(int num1, int num2) {
        return num1+num2;
    }

}
