package study.특강;

import java.util.Scanner;

public class Exam1118 {
    // 입력 받기
    static int ArrayLenght(Scanner sc){
        while(true) {
            // 3~7 사이의 정수를 입력받기
            System.out.print("Enter the number of slots (3~7): ");
            int inputArrayLength = sc.nextInt();
            // Enter 방지
            sc.nextLine();

            // 유효하지 않으면 오류 메시지를 출력하고 재입력
            if (inputArrayLength >= 3 && inputArrayLength <= 7) {
                return inputArrayLength;
            }
            System.out.println("Invalid input. Please enter a number between 3 and 7");
        }
    }
    // 점수 부여
    static int ScoreCheck(char simbol, int combo){
        int score = 0;
        switch (simbol) {
            case '+':
                score += combo;
                break;
            case '-':
                score -= combo;
                break;
            case '*':
                score += combo+1;
                break;
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // (+, -, *)를 포함하는 char type 1차원 배열을 생성
        char[] simbolsArray = {'+', '-', '*'};

        // 입력 받은 길이의 랜덤값을 저장하는 char type 1차원 배열 생성
        char[] randomArray = new char[ArrayLenght(sc)];


        int gameScore = 0;   // 전체 게임 포인트 초기화
        String gameMsg = ""; // 게임 종려시 출력 msg초기화
        int gameCount = 0;   // 게임 반복 횟수

        // 게임 전체 반복
        while(true) {
            //반복 횟수를 출력
            System.out.println("--- Round " + ++gameCount + " ---");

            // 입력받기
            System.out.print("Press Enter to spin the slot machine: ");
            sc.nextLine();

            // for)
            // 랜덤으로 배열의 길이 만큼 반복
            for (int i = 0; i < randomArray.length; i++) {
                // 랜덤 값을 배열에 대입
                randomArray[i] = simbolsArray[(int)(Math.random() * 3)];
            }

            // 렌덤 배열 출력
            System.out.print("Result: [");
            for (int i = 0; i < randomArray.length; i++) {
                System.out.print(randomArray[i]);
                System.out.print((i == randomArray.length - 1) ? "]\n" : ", ");
            }


            // 점수 체크
            int combo = 0;
            int roundScore = 0;
            // for)
            // 렌덤 배열 -1 길이 반복
            for (int i = 0; i < randomArray.length -1; i++) {
                // 만약 다음 원소랑 동일하면 점수 부여
                if (randomArray[i] == randomArray[i+1]) {
                    combo++;
                    // 점수 추가
                    // combo할 때마다 점수를 추가
                    int score = ScoreCheck(randomArray[i], combo);

                    // 만약 3개 연속이면 combo초기화 , 다음 원소 건너뛰기
                    if (combo >= 2){
                        combo = 0;
                        i++;
                    }

                    roundScore += score;
                // 다른 문자면 combo초기화
                }else{
                    combo = 0;
                }
            }

            // roundScore를 전체 점수에 합산하고 각점수를 출력
            gameScore += roundScore;
            System.out.println("Group Scores: " + roundScore);
            System.out.println("Total Score: " + gameScore);

            // 승리/패배 조건
            if (gameScore >= 5 || gameScore <= -5) {
                gameMsg = (gameScore >= 5) ? "win!" : "lose..";
                break;
            }

        }
        // 최종 결과 출력
        System.out.println("Congratulations, you " + gameMsg);
    }
}
