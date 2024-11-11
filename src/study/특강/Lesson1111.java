package study.특강;

import java.util.Scanner;

public class Lesson1111 {
    // 가위바위보 게임
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 추가 조건) score 계산, 연속 성공 보너스
        int score = 0;
        int continueScore = 0;
        // 게임 승부결과를 저장하는 변수 초기화
        String result = "";
        String st[] = {"Scissors", "Rock", "Paper"};

        // while) 전체 반복
        while(true) {
            // Scissors, Rock, Paper 입력 받기
            // 입력 받는 값(int)을 초기화
            int userInput = 0;
            // 입력 받기
            System.out.print("Scissors, Rock, Paper 중 하나를 입력하세요: ");
            String input = sc.nextLine();

            // switch) 받은 값을 0~4로 할당
            userInput = switch (input) {
                // 0~2 -> Scissors, Rock, Paper
                case "Scissors", "s" -> 0;
                case "Rock", "r" -> 1;
                case "Paper", "p" -> 2;
                // 3 -> Exit
                case "Exit" -> 3;
                // defult -> 4
                default -> 4;
            };
            // 3면) Exit -> 프로그램 종료
            if (userInput == 3){
                break;
            }
            // 4면) Scissors, Rock, Paper이외 -> 재입력(처음부터) continue
            else if (userInput == 4){
                continue;
            }

            // 컴퓨터 -> Scissors, Rock, Paper 렌덤(0~2를 렌덤으로 설정)
            int computer = (int)(Math.random() * 3);

            // 컴퓨터 값과 입력값 비교
            String msg = "";
            // if 승리)
            if(userInput == 0 && computer == 2
            || userInput == 1 && computer == 0
            || userInput == 2 && computer == 1){
                msg = "승리";
                // score +1
                score ++;
                // 연속 score +1
                continueScore ++;
            }
            // else if 무승부)
            else if (userInput == computer){
                msg = "무승부";
                continueScore = 0;
            }
            // else 패배)
            else{
                msg = "패배";
                // score -1
                score --;
                continueScore = 0;
            }

            // if) 연속 승리면(연속 횟수 >= 2)
            // 추가 점수 += 2 아니면 리세트
            if (continueScore >= 2) {
                score += 2;
            }


            // 대결 결과 출력
            System.out.println(msg + "  사용자: " + st[userInput] + " 컴퓨터:" + st[computer]);

            // 현재 score 출력
            System.out.println("현재 점수: " + score);

            // if)  -7 >= score >= 7 -> 프로그램 종료
            if (score >= 7 || score <= -7){
                result = (score >= 7) ? "승리": "패배";
                break;
            }
        }
        // while 반복이 끝나고 최종 결과 출력
        System.out.println("최종 결과: " + result);
    }
}
