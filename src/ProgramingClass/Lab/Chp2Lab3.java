package ProgramingClass.Lab;

public class Chp2Lab3 {
    public static void main(String[] args) {
        // 반지름 -> double타입, 값 5.0 : 초기화
        double radius = 5.0;
        // 원주율 -> 상수로 선언, 값 3.14159 : 초기화
        final double PI = 3.14159;

        // 원의 면적 : π * 반지름^2
        double area = PI * radius * radius;
        // 결과 출력  소수점 둘째 자리까지 -> printf(" %.2f", 해당 변수)
        System.out.printf("원의 면적: %.2f", area);
    }
}
