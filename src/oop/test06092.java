package oop;

public class test06092 {
    public static void main(String[] args) {

        //        1) class 이름없음 extends Object{}
        //        2) new 아름없음();
        Object obj = new Object(){};

        interface Test{};
        //        1) class 이름없음 implements Test{}
        //        2) new 아름없음();
        Test test = new Test() {};
    }
}
