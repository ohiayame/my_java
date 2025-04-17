package oop.test.bar;

class Bar {
    protected int x = 3;
    void getX(){
        System.out.println(x);
    }
}

public class printNum extends Bar {
    printNum() {
        getX();
    }
}


























