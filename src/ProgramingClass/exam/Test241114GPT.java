package ProgramingClass.exam;

import java.util.Scanner;

public class Test241114GPT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int gameCount = 0; // 게임 실행 횟수
        int getPoints = 0; // 게임 점수
        String msg = ""; // 종료 메시지
        char[] charArray = {'+', '-', '*'}; // 기호 배열
        int[] randomArray = new int[3]; // 랜덤 기호 배열

        while (true) {
            gameCount++;
            System.out.println(gameCount + "번째 게임");
            System.out.print("게임을 시작하려면 아무 값이나 입력하세요: ");
            sc.nextLine();

            // 랜덤 기호 배열 생성
            for (int i = 0; i < 3; i++) {
                randomArray[i] = (int) (Math.random() * 3);
            }

            // 슬롯 출력
            System.out.println("---------------------------");
            for (int i : randomArray) {
                System.out.print("   " + charArray[i] + "   ");
            }
            System.out.println("\n---------------------------");

            // 연속 기호 확인
            int combo = 0;
            int comboValue = -1;
            for (int i = 1; i < randomArray.length; i++) {
                if (randomArray[i] == randomArray[i - 1]) {
                    combo++;
                    comboValue = randomArray[i];
                } else {
                    combo = 0; // 연속성 초기화
                }
            }

            // 점수 계산
            if (combo > 0) {
                int scoreChange = 0;
                String getMsg = "획득";

                switch (comboValue) {
                    case 0: // '+'
                        scoreChange = combo == 1 ? 1 : 3;
                        break;
                    case 1: // '-'
                        scoreChange = combo == 1 ? -1 : -3;
                        getMsg = "감점";
                        break;
                    case 2: // '*'
                        scoreChange = combo == 1 ? 2 : 5;
                        break;
                }

                getPoints += scoreChange;
                System.out.printf("%c %d Combo - 보너스 점수 %d점 %s\n", charArray[comboValue], combo + 1, scoreChange, getMsg);
            } else {
                System.out.println("연속된 기호가 없습니다.");
            }

            // 현재 점수 출력
            System.out.println("현재 점수: " + getPoints);

            // 종료 조건
            if (getPoints >= 5 || getPoints <= -5) {
                msg = (getPoints >= 5) ? "승리" : "패배";
                break;
            }

            System.out.println();
        }

        // 최종 결과 출력
        System.out.println(msg + "! 최종 점수: " + getPoints);
    }
}