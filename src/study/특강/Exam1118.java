package study.특강;

import java.util.Arrays;
import java.util.Scanner;

public class Exam1118 {
    // 입력 받기
    static int ArrayLength(Scanner sc) {
        while (true) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // (+, -, *)를 포함하는 char type 1차원 배열을 생성
        char[] symbolsArray = {'+', '-', '*'};

        // 입력 받은 길이의 랜덤값을 저장하는 char type 1차원 배열 생성
        //char[] randomArray = new char[ArrayLength(sc)];

        char[] randomArray = {'-', '-', '*', '*', '*', '*', '*'};

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
//            for (int i = 0; i < randomArray.length; i++) {
//                // 랜덤 값을 배열에 대입
//                randomArray[i] = symbolsArray[(int)(Math.random() * 3)];
//            }


            // 렌덤 배열 출력
            System.out.println("Result: " + Arrays.toString(randomArray));



            // 점수 체크
            int combo = 0;
            int roundScore = 0;
            // for)
            // 렌덤 배열 -1 길이 반복
            for (int i = 0; i < randomArray.length -1; i++) {
                // 만약 다음 원소랑 동일하면 점수 부여
                if (randomArray[i] == randomArray[i+1]) {
                    combo++; // 연속으로 동일하면 더하기 1

                    // 부여할 점수를 선택
                    switch (randomArray[i]) {
                        case '+':
                            roundScore += combo; // if combo == 1 ->  +1 , combo == 2 ->  +2
                            break;              // if combo == 2-> combo가 1일때 이미 +1됐기 때문에 2만 더하면 결과적으로 +3한것과 동일한 결과가 나옴
                        case '-':
                            roundScore -= combo;
                            break;
                        case '*':
                            roundScore += combo+1;
                            break;
                    }

                    // 만약 3개 연속이면 더이상 계산을 못하고 다음 원소는 이미 현재 원소와 동일함을 증명했기 때문에
                    // 다음 원소는 건너뛰고 combo를 초기화
                    if (combo >= 2){
                        combo = 0;

                        // 동일한 깂이 어네까지 연속되는지 검사하고 연속이 끝날때까지 건너뛰기
                        for (int c = i; c < randomArray.length - 1; c++) {
                            if (randomArray[i] == randomArray[i + 1] ) {
                                i++;
                            }else{
                                break;
                            }
                        }
                    }

                // 현재 원소와 다음 원소가 다르면 combo초기화
                }else{
                    combo = 0;
                }
            }

            // roundScore를 전체 점수에 합산하고 각점수를 출력
            gameScore += roundScore;
            System.out.println("Group Scores: " + roundScore);
            System.out.println("Total Score: " + gameScore);

            // 승리/패배 조건 : 전체 게임 score가 5이상 또는 -5이하
            if (gameScore >= 5 || gameScore <= -5) {
                gameMsg = (gameScore >= 5) ? "win!" : "lose..";
                break;
            }

        }// 게임 전체 while문 종료

        // 최종 결과 출력
        System.out.println("Congratulations, you " + gameMsg);
    }
}
