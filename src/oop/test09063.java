package oop;

import javax.swing.*;

interface Test{
    void print();
}

public class test09063 {
    public static void main(String[] args) {

        Test test = new Test() {
            @Override
            public void print() {
                System.out.println("Hello World");
            }

        };
        test.print();
    }
}



