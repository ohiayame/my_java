package oop.interfaceTest;

public class LandRover {
    private EngineBracket engine;

    // 생성자 주입
    public LandRover(EngineBracket engine) {
        this.engine = engine;
    }

    // 시동 및 주행
    public void drive() {
        engine.start();
        System.out.println("랜드로버가 주행을 시작합니다.");
    }

    // 정지
    public void stop() {
        engine.stop();
        System.out.println("랜드로버가 정차합니다.");
    }
}
