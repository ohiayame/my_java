package oop;
interface  Test{ void print(); }
class Outerr{
    int outer_val = 1;

    Test prt(){
        int local_val = 2;

        class Inner implements Test {
            public void print() {
                System.out.println(outer_val);
                System.out.println(local_val);
            }
        }
        return new Inner();
    }
}

public class test0604 {
    public static void main(String[] args) {
        Outerr outer = new Outerr();
        Test test = outer.prt();
        test.print();
    }
}
