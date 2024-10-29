package ProgramingClass.Lab;

import java.util.Scanner;

public class Chp4Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 양수의 나이를 입력 받기
        int age = 0;
        while(true){
            System.out.print("나이를 입력하세요: ");
            age = sc.nextInt();

            if (age < 0){
                System.out.println("나이를 음수가 될 수 없습니다. 다시 입력하세요");
            }else{
                break;
            }
        }
        // 연령대를 선택
        String grade ="";
        if (age <= 12) {
            grade = "어린이";
        }else if (age <= 17) {
            grade = "청소년";
        }else if (age <= 64) {
            grade = "성인";
        }else{
            grade = "노인";
        }

        System.out.println(grade);
    }
}
