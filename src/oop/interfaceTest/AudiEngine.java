package oop.interfaceTest;

public class AudiEngine implements EngineBracket {
    @Override
    public void start() {
        System.out.println("아우디 엔진이 정숙하게 시동됩니다.");
    }

    @Override
    public void stop() {
        System.out.println("아우디 엔진이 안정적으로 정지합니다.");
    }
}
