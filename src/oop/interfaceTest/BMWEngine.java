package oop.interfaceTest;

public class BMWEngine implements EngineBracket {
    @Override
    public void start() {
        System.out.println("BMW 엔진이 강력하게 시동을 겁니다.");
    }

    @Override
    public void stop() {
        System.out.println("BMW 엔진이 빠르게 정지합니다.");
    }
}
