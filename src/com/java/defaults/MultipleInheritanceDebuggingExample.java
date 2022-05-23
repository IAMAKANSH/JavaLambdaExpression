package com.java.defaults;

public class MultipleInheritanceDebuggingExample implements InterfaceA,InterfaceD{

    //We can overide that same method inside the implementation class

    public void sumA(int num1,int num2)
    {
        System.out.println("MultipleInheritanceDebuggingExample sumA::"+(num1+num2));
    }

}
