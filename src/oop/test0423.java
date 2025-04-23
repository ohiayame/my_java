package oop;

abstract class Pos{
    abstract void prt();
    static void print(){
        System.out.println("Pos");
    }
}
class Kin extends Pos{
    void prt(){
        System.out.println("Kin");
    }
}

public class test0423 {
    public static void main(String[] args) {
        Pos p = new Kin();
        Pos.print();
        p.prt();
    }
}
