package com.epam.rd.java.basic.practice2;

public class Demo {
    public static void main(String[] args) {
        StackImpl stack=new StackImpl();
        stack.push(34);
        stack.push(56);
        Object s=stack.top();
        System.out.println(s);
    }
}
