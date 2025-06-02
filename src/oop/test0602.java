package oop;

class Outer{
    int outer_val = 1;

    class Inner{
        int inner_val = 2;
        void prt(){
            System.out.println(outer_val);
        }
        void set_val (int val) {
            Outer.this.outer_val = val;
        }
    }
}
public class test0602 {
    public static void main(String[] args) {
        Outer outer1 = new Outer();
        Outer.Inner inner1 = outer1.new Inner();
        Outer.Inner inner2 = outer1.new Inner();

        inner1.set_val(3);
        inner2.prt();

        outer1 = null;
        inner1.set_val(5);
        inner2.prt();
    }
}
