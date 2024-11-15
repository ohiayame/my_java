package study.특강;

import java.util.Scanner;

public class exam1115 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 연산자(+, -, *)를 포함하는 char type 1차원 배열을 생성
        char[] symbolArray = {'+', '-', '*',};
        int symbolValue = symbolArray.length;
        // random char type 1차원 배열
        char[] randomSelectChars = new char[symbolValue];

        // game 반복횟수 변수
        int gameCount = 0;
        // 포인트 변수
        int gamePoints = 0;
        // 최종 메시지 변수
        String gameMsg = "";

        // while) 게임 반복
        while (true) {
            // game 반복횟수 ++ -> 출력
            gameCount++;
            System.out.println(gameCount + "번째 게임");
            // String) 입력 받기
            System.out.print("게임을 시작하려면 아무 값이나 입력하세요");
            sc.nextLine();

            // 랜덤으로 3번 int 배열에 대입
            for (int i = 0; i < randomSelectChars.length; i++) {
                randomSelectChars[i] = symbolArray[(int) (Math.random() * randomSelectChars.length)];
            }

            // random 배열출력
            System.out.println("---------------------------");
            for (int i = 0; i < randomSelectChars.length; i++) {
                System.out.print("   " + randomSelectChars[i] + "   :");
            }
            System.out.println();
            System.out.println("---------------------------");

            // combo 횟수
            int combo = 0;
            // combo한 기호
            char comboChar = ' ';
            // for)
            for (int i = 0; i < randomSelectChars.length - 1; i++) {
                //  만약에 random 배열[i] == random 배열[i -1]:
                if (randomSelectChars[i] == randomSelectChars[i + 1]) {
                    // combo ++
                    combo++;
                    // combo한 기호 저장 = random 배열[i]
                    comboChar = randomSelectChars[i];
                }
            }

            // 만약 0 < combo 횟수
            if (combo > 0) {
                // 출력 메시지: 획득
                String msg = "획득";
                int point = 0;
                // switch) combo한 기호
                switch (comboChar) {
                    // chars = {'+', '-', '*'};
                    // case '+': combo 횟수 == 1? 포인트++ : 포인트+3
                    case '+':
                        point = (combo == 1) ? 1 : 3;
                        break;
                    // case '-': combo 횟수 == 1? 포인트-- : 포인트-3  메시지 -> 감점
                    case '-':
                        point = (combo == 1) ? -1 : -3;
                        msg = "감점";
                        break;
                    // case '*': combo 횟수 == 1? 포인트+2 : 포인트+5
                    case '*':
                        point = (combo == 1) ? 2 : 5;
                        break;
                }
                gamePoints += point;
                // combo 출력
                System.out.printf("%s %d Combo - 보너스 점수 %d점 %s", comboChar, combo + 1, point, msg);
            }
            // 개행
            System.out.println();


            // 현재 점수 출력
            System.out.println("현재 점수 :" + gamePoints);
            System.out.println();

            // 만약에 5 <= 포인트 <= -5  -> 프로그램 종료
            if (gamePoints <= -5 || gamePoints >= 5) {
                gameMsg = (gamePoints <= -5) ? "패배" : "승리";
                break;
            }

        }
        // 최종 메시지 출력
        System.out.println(gameMsg + "! 최종 점수 :" + gamePoints);
    }
}