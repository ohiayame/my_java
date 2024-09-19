package ProgramingClass.Lab;

import java.util.Scanner;

public class Chp2Lab4 {
    public static void main(String[] args) {
        // Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 1) 나이(정수형) 입력 받기 : int
        System.out.print("나이 입력하세요: ");
        int age = sc.nextInt();

        // 2) 몸무게(실수형) 입력 받기 : double
        System.out.print("몸무게를 입력하세요: ");
        double kg = sc.nextDouble();

        // 3) 나이를 double로 명시적 형변환하여 몸무게와 더한 결과를 출력
        double sumDouble = (double) age + kg;
        System.out.println("나이를 double로 변환한 후 몸무게와 더한 결과: " + sumDouble);

        // 4) 몸무게를 int로 명시적 형변환하여 나이와 더한 결과를 출력
        int sumInt = age + (int)kg;
        System.out.println("몸무게를 int로 변환한 후 몸무게와 더한 결과: " + sumInt);

        sc.close();  // 사용이 끝난 후 Scanner 객체를 닫아 자원을 해제
    }
}
