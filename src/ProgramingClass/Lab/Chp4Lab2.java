package ProgramingClass.Lab;

import java.util.Scanner;

public class Chp4Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 숫자를 입력 받기
        int num = 0;
        while (true){
            System.out.print("1~7 사이의 숫자를 입력하세요: ");
            num = sc.nextInt();
            if (num >= 1 && num <= 7){
                break;
            }
            System.out.println("유효하지 않은 숫자입니다. 1~7 사이의 숫자를 입력하세요.");
        }
        // 요일과 주말인지를 선택
        String day = "";
        boolean isWeekend = false;
        switch (num){
            case 1:
                day = "월요일";
                break;
            case 2:
                day = "화요일";
                break;
            case 3:
                day = "수요일";
                break;
            case 4:
                day = "목요일";
                break;
            case 5:
                day = "금요일";
                break;
            case 6:
                day = "토요일";
                isWeekend = true;
                break;
            case 7:
                day = "일요일";
                isWeekend = true;
                break;
        }

        if (isWeekend){
            System.out.println(day + ", 주말");
        }else {
            System.out.println(day + ", 주중");
        }
    }
}
