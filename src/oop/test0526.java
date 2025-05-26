package oop;

import java.io.IOException;

class A{
    void prt() throws Exception { }
}
class B extends A {
    @Override
    void prt() throws IOException { } // 에러
}

public class test0526 {
    public static void main(String[] args) throws Exception {


        try{
            int bar = 1;
            if (bar == 1){
                throw new IOException("Error");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }
}
