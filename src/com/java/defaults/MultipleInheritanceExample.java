package com.java.defaults;

public class MultipleInheritanceExample implements InterfaceA,InterfaceB,InterfaceC{

    public static void main(String[] args) {

        MultipleInheritanceExample multipleInheritanceExample=new MultipleInheritanceExample();
        multipleInheritanceExample.sumA(4,8); //it will call child
        multipleInheritanceExample.sumB(2,4);
        multipleInheritanceExample.sumC(1,2);

        //Resolve
        //Implemented Class first
        //sub interface  that extends that interface


    }
    public void sumA(int num1,int num2)
    {
        System.out.println("MultipleInheritanceExample.sumA "+(num1+num2));
    }

}
