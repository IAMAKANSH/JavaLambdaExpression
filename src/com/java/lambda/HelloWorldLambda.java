package com.java.lambda;

public class HelloWorldLambda {
    public static void main(String[] args) {
        //implementing sayHelloWorld Using Lambda
        //First Way
        HelloWorldInterface helloWorldInterface=() ->{
            return "Hello World";
        };
        //Second Way
        HelloWorldInterface helloWorldInterface1=() -> "Return Hello World";

        System.out.println(helloWorldInterface.sayHelloWorld());
        System.out.println(helloWorldInterface1.sayHelloWorld());

        //Increment By 5
        IncrementByFive incrementByFive=(x) ->x+5;
        System.out.println(incrementByFive.incrementByFive(2));

        //Concat two strings

        ConcatenateInterface concatenateInterface=(x,y) -> x+y;
        System.out.println(concatenateInterface.concat("5","6"));
    }
}
