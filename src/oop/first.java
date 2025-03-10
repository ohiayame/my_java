package oop;

// 외부 클래스 (Main 클래스 외부에 선언됨)
class Car {
    String brand;

    // 생성자
    Car(String brand) {
        this.brand = brand;
    }

    // 메서드
    void drive() {
        System.out.println(brand + "가(이) 달립니다!");
    }
}

// 메인 클래스
public class first {
    public static void main(String[] args) {
        // ✅ 외부 클래스의 객체 생성 (메인 스레드에서 실행)
        Car myCar = new Car("Hyundai");
        Car yourCar = new Car("Honda");

        // ✅ 외부 클래스의 메서드 호출
        myCar.drive(); // 출력: Hyundai가(이) 달립니다!
        yourCar.drive(); // 출력: Honda가(이) 달립니다!
    }
}
