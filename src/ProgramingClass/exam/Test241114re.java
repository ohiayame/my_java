package ProgramingClass.exam;

import java.util.Scanner;

public class Test241114re {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 게임 실행 횟수 변수 초기화
        int gameCount = 0;
        // game point
        int gamePoints = 0;
        // 종료 msg
        String gameMsg = "";
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
            sc.nextLine();


            // random-> 0~2 3개
            // 3번 반복 ->  배열에 대입
            for(int i = 0; i < 3; i++) {
                randomArray[i] = (int)(Math.random() * 3);
            }

            // 슬롯 출력
            System.out.println("---------------------------");
            // random 배열 출력
            for (int i : randomArray) {
                System.out.print("   " + charArray[i] + "   :");
            }
            System.out.println("\n---------------------------");


            // combo 변수 초기화
            int combo = 0;
            // combo하고있는 기호를 기록하는 변수 초기화
            int comboValue = 0;


            // 점수 확인
            // 랜덤의 값을 array의 2번째까지 순회해 연속성 확인
            for(int i = 0 ; i < randomArray.length-1 ; i ++) {
                // 랜덤의 값과 다음 랜덤의 값을 비교해서
                // 만약에 같으면 연속성 +1
                // 어떤 기호인지도 저장
                if (randomArray[i] == randomArray[i+1] ) {
                    combo ++;
                    comboValue = randomArray[i];
                }

            }
            if (combo > 0) {
                // 연속의 횟수와 기호에 따라 점수와 msg를 부여
                String msg = "획득";
                int point = 0;
                // 1 ) 연속된 연산자 2개
                if (combo == 1) {
                    switch (comboValue) {
                        // +
                        case 0:
                            point++;
                            break;
                        // -
                        case 1:
                            point--;
                            msg = "감점";
                            break;
                        // *
                        case 2:
                            point += 2;
                            break;
                    }

                }// 2 ) 연속된 연산자 3개
                else if (combo == 2) {
                    switch (comboValue) {
                        // +
                        case 0:
                            point += 3;
                            break;
                        // -
                        case 1:
                            point -= 3;
                            msg = "감점";
                            break;
                        // *
                        case 2:
                            point += 5;
                            break;
                    }
                }
                // 전체 포인트에 합산 -> combo 상세를 출력
                gamePoints += point;
                System.out.printf("%s %d Combo - 보너스 점수 %d점 %s", charArray[comboValue], (combo+1), gamePoints, msg);
            }
            // 개행
            System.out.println();


            // 현재 점수 출력
            System.out.println("현재 점수 : " + gamePoints);
            System.out.println();

            // 만약에 getPoints >=  5  getPoints <= - 5 종료
            if (gamePoints >=  5 || gamePoints <= - 5) {
                gameMsg = (gamePoints >=  5) ? "승리": "패배";
                break;
            }

        }

        // 최종 결과 출력
        System.out.println(gameMsg + "! 최종 점수 :" + gamePoints);

    }
}
