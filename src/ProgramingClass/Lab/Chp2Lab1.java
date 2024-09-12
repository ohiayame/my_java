package ProgramingClass.Lab;
// 사용자로부터 세가지 값을 입력받고, 각각의 값을 적절한 자료형에 저장한 뒤, 합계와 평균을 계산하여 출력

import java.util.Scanner;

public class Chp2Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    // 1) 나이(정수형) 입력 받기
        System.out.print("나이 입력하세요: ");
        int age = sc.nextInt();

    // 2) 키 (소수점 포함) 입력 받기
        System.out.print("키를 입력하세요: ");
        float height = sc.nextFloat();

    // 3) 신용점수 (정수형) 입력 받기
        System.out.print("신용점수를 입력하세요: ");
        int creditScore = sc.nextInt();

    // 4) 합계
        int intsum = age + creditScore;

    // 5) 평균
        float allsum = intsum + height;
        float avg = allsum / 3;

    // 6) 결과 출력
        System.out.println("합계: " + intsum);
        System.out.printf("평균: %.2f\n", avg);

        sc.close();
    }

}
