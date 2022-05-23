package com.java.lambda;

public class HelloWorldInterfaceImpl implements HelloWorldInterface{
    @Override
    public String sayHelloWorld() {
        return "Hello World";
    }

    public static void main(String args[])
    {
        HelloWorldInterfaceImpl helloWorld=new HelloWorldInterfaceImpl();
        System.out.println(helloWorld.sayHelloWorld());
    }
}
