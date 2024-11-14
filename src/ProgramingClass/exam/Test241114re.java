package ProgramingClass.exam;

import java.util.Scanner;

public class Test241114re {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 게임 실행 횟수 변수 초기화
        int gameCount = 0;
        // game point
        int getPoints = 0;
        // 종료 msg
        String msg = "";
        // +-* char array 생성
        char[] charArray = {'+', '-' , '*'};

        // random으로 선택한 값을 저장하는 배열
        int[] randomArray = new int[3];


        // while)게임 전체 흐름
        while(true) {
            // 게임실행횟수 세우고 출력
            gameCount++;
            System.out.println(gameCount + "번째 게임");

            // 아무거나 입력 받기
            System.out.print("게임을 시작하려면 아무 값이나 입력하세요");
            String input = sc.nextLine();


            // random-> 0~2 3개
            // 3번 반복 ->  배열에 대입
            for(int i = 0; i < 3; i++) {
                randomArray[i] = (int)(Math.random() * 3);
            }

            // 슬롯 출력
            System.out.println("---------------------------");
            // random배열 출력
            for (int i : randomArray) {
                System.out.print("   " + charArray[i] + "   :");
            }
            System.out.println("\n---------------------------");


            // combo 변수 초기화
            int combo = 0;
            // combo하고있는 기호를 기록하는 변수 초기화
            int comboValue = 0;
            // chack
            int check = -1;

            // 점수 확인
            // 랜덤의 값을 순회해 연속성 확인
            for(int i = 0 ; i < randomArray.length ; i ++) {
                // 랜덤의 값과 지난번의 랜덤의 값을 비교해서
                // 만약에 같으면 연속성 +1
                // 어떤 기호인지도 저장
                if (randomArray[i] == check ) {
                    combo ++;
                    comboValue = randomArray[i];
                }// 연속적 아니면  지난번의 랜덤의 값을 갱신
                else {
                    check = randomArray[i];
                }
            }

            // 연속의 횟수와 기호에 따라 점수와 msg를 부여
            String getMsg = "";
            // 연속적이면 변동한 점수 출력
            if (combo > 0) {
                int scoreChange = 0;
                getMsg = "획득";

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
                String format = String.format("%s %d Combo - 보너스 점수 %d점 %s", charArray[comboValue], (combo+1), getPoints, getMsg);
                System.out.println(format);
            }else {
                System.out.println();
            }

            // 현재 점수 출력
            System.out.println("현재 점수 : " + getPoints );


            // 만약에 getPoints >=  5  getPoints <= - 5 종료
            if (getPoints >=  5 || getPoints <= - 5) {
                msg = (getPoints >=  5) ? "승리": "패배";
                break;
            }
            System.out.println();
        }

        // 최종 결과 출력
        System.out.println(msg + "! 최종 점수 :" + getPoints);

    }
}
