package oop;

interface bracket {void prt();}
class Bar{
    bracket getObject() {
        class Test implements bracket {
            public void prt() {}
        }
        Test test = new Test();
        return test;
    }
}
public class test0528 {
    public static void main(String[] args) {
        bracket b = new Bar().getObject();
    }
}
