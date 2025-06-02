package oop;
interface myInterface{ void prt();}

class Outer{
    int outer_val = 1;

    myInterface prtSomething(){
        class test implements myInterface{

            public void prt() {
                int local_val = 1;
                System.out.println(outer_val + local_val);
            }
        }
        return new test();
    }
}

public class test06023 {
    public static void main(String[] args) {
        myInterface ifs = new Outer().prtSomething();
        ifs.prt();
    }
}
