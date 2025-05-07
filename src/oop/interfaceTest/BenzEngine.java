package oop.interfaceTest;

public class BenzEngine implements EngineBracket {
    @Override
    public void start() {
        System.out.println("벤츠 엔진이 조용하게 시동을 겁니다.");
    }

    @Override
    public void stop() {
        System.out.println("벤츠 엔진이 부드럽게 정지합니다.");
    }
}
