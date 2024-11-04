package study.특강;

import java.util.Scanner;

public class Lesson1104 {
    public static void main(String[] args) {
        // 가위 바위 보 게임
        Scanner sc = new Scanner(System.in);
        // quit이 입력 될때 까지 무한 반복
        boolean flag = false;
        // 전체 프로그램 반복
        while (true) {
            // input값을 초기화
            int userInput = 0;
            // Scissors, Rock, Paper 입력 받기 (예외 다시 입력)
            while(true){
                System.out.println("Scissors, Rock, Paper 중 하나를 입력 하세요");
                String userstr = sc.nextLine();
                if (userstr.equals("Scissors") || userstr.equals("Rock") || userstr.equals("Paper")) {
                    // 번호를 할당
                    userInput = switch (userstr) {
                        case "Scissors" -> 0;
                        case "Rock" -> 1;
                        case "Paper" -> 2;
                        default -> userInput;
                    };
                    break;

                } // quit이 입력되면 프로그렘 종료
                else if (userstr.equals("quit")) {
                    flag = true;
                    break;
                }
                System.out.println("잘못된 입력 값 입니다, Scissors, Rock, Paper 중 하나를 입력 하세요");
            }
            if (flag) {
                break;
            }
            // 컴퓨터 random로 가위바위보 중 하나 선택
            String sciRockPaer[]  = {"Scissors", "Rock", "Papers"};
            // 0~2 렌덤
            int computerInput  = (int)(Math.random() * 3);
            // 승패
            String msg = "";
            // 승리)
            if (computerInput -1 == userInput) {
                msg ="승리!!!";
            }
            // 패배)
            else if (computerInput -2 == userInput) {
                msg = "패배";
            }
            // 무승부)
            else if (computerInput == userInput) {
                msg = "무승부";
            }

            // 결과 출력
            System.out.println("computerInput is " + sciRockPaer[computerInput] + " -> " + msg);
        }

    }
}
