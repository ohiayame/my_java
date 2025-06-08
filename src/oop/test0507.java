package oop;

interface Scan {
    // public abstract void doScan();
    void doScan();

    // public static final int scanNum = 2;
    int scanNum = 2;

    default void prePaper() {
        powerOn();
        System.out.println("Prepaper");
    }
    default void preWater() {
        powerOn();
        System.out.println("Water");
    }
    private void powerOn(){
        System.out.println("power on");
    }

    static void prePower() {
        System.out.println("Power");
    }
}
class Equipment implements Scan {
    public void doScan() {
        System.out.println("Equipment scan");
        Scan.prePower();
    }

    @Override
    public void prePaper() {
        Scan.super.prePaper();
        System.out.println("Equipment- Prepaper");
    }
}

class Device implements Scan {
    int scanNum = 10;
    @Override
    public void doScan() {
        System.out.println(Scan.scanNum);
    }
}

public class test0507 {
}
