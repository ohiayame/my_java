package study.특강;

import java.util.Scanner;

public class Test1108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 추가) 점수 체크 & 연속 점수
        int totalScore = 0;
        int continuescore = 0;

        // 전체 루프
        while (true) {
            // Scissors, Rock, Paper 중 하나 입력 받기
            // 입력 받기
            String input = sc.nextLine();

            // 입력 된 변수를 인덱스 값과 비교하기위해
            int userNum = switch (input) {
                // 입력에 따라 값을 부여
                // switch
                // Scissors -> 0, Rock -> 1, Paper -> 2
                case "Scissors" -> 0;
                case "Rock" -> 1;
                case "Paper" -> 2;
                case "quit" -> 3;
                default -> 4;
            };

            // 게임이 계속하는지 체크
            // 만약에 "quit" -> 프로그램 종료
            if (userNum == 3) {
                break;
            }else if (userNum == 4) {
                System.out.println("다시 입력 (Scissors, Rock, Paper)");
                continue;
            }


            // 렌덤으로 컴퓨터의 int 0~2 사이 값을 받기
            int computer = (int) (Math.random() * 3);
//            System.out.println(computer);


            // msg 초기화
            String msg = "";
            // 승리 ) 사용자 Scissors. 컴퓨터 Paper
            // 점수 +1
            if (userNum == 0 && computer == 2 ||
                userNum == 1 && computer == 0 ||
                userNum == 2 && computer == 1) {
                msg = "승리";
                totalScore += 1;
                continuescore +=1;
            }

            // 무승부) 사용자 Scissors. 컴퓨터 Scissors
            else if (userNum == computer) {
                msg = "무승부";
            }

            // 패배) 사용자 Scissors. 컴퓨터 Rock
            // 점스 -1
            else{
                msg = "패배";
                totalScore += 1;
                continuescore = 0;
            }


            String st[] = {"Scissors", "Rock", "Paper"};

            // 대결 결과 출력
            System.out.println(msg + "  사용자: " + st[userNum] + " 컴퓨터:" + st[computer]);

            // 만약 연속이면 추가로 2점 더 추가
            if (continuescore >= 2) {
                totalScore += 2;
            }
            // 현재 포인트 출력
            System.out.println("현재 포인트: " + totalScore);

            // -7점이하, 7점이상 종료
            if (-7 >= totalScore) {
                System.out.println("다음 기회에~~~");
                break;
            }else if (totalScore >= 7){
                System.out.println("축하합니다. 승리~~~");
                break;
            }


        }
    }
}



