package oop;

interface Cars{
    void drive();
}

interface Airplane{
    void drive();
}

interface Poss extends Cars, Airplane{

}
public class Kin implements Cars, Airplane{

}

class Kin implements Poss{
    @Override
    public void drive() {
        System.out.println("Kinn drive");
    }
}

public class test05072 {
}
