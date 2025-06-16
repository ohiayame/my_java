package oop;
interface MyInterface {
    void prt(String s);
}

public class test0616 {
    static  void doSomething(MyInterface mi) {
        mi.prt("hello world");
    }

    public static void main(String[] args) {
        MyInterface obj = (msg) -> System.out.println(msg);

        doSomething(obj);

    }
}
