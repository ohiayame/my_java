package study;

import java.util.*;

public class Basaball {
    public static void main(String[] args) {
        Random random = new Random();
        // 리스트 생성   ArrayList index처리 할 수 있는 리스트 , <Integer>  Integer 타입의 데이터만 저장
        List<Integer> cp_li = new ArrayList<Integer>();

        // 난수 생성
        while (cp_li.size() < 3){
            int cp_num = random.nextInt(10);
            if (!cp_li.contains(cp_num)){  //cp_li에 같은 원소가 없으면
                cp_li.add(cp_num);  // 원소를 추가
            }
        }

        int game_out = 0;
        int game_count = 0;
        Scanner scanner = new Scanner(System.in); // 입력일 받기 위한 객체 생성

        while (true){
            game_count++; // 원래 값에 더하기 1
            System.out.println("시도" + game_out + ": 입력한 숫자 - "); // 출력
            String[] player_input = scanner.nextLine().split(" ");  // 문자열로 입력 받고 공백을 기준으로 나누기
            List<Integer> player_li = new ArrayList<>(); // 리스트 생성

            for (String num : player_input) {
                player_li.add(Integer.parseInt(num)); // 문자형에서 정수형으로 변환 (Integer.parseInt())하고 리스트에 추가
            }

            // 결과 출력
            int game_strike = 0;
            int game_ball = 0;

            for (int i = 0; i < 3; i++) {    // int i = 0; -> 초기 값,  i < 3; -> 반복 조건, i++ -> 값을 1씩 증가
                for (int j = 0; j < 3; j++) {
                    if (Objects.equals(cp_li.get(i), player_li.get(j))) {  // get()  -> 리스트의 해당 인덱스 값을 가져오기
                        if (i == j) {
                            game_strike++;
                        } else {
                            game_ball++;
                        }
                    }
                }
            }

            if (game_strike == 0 && game_ball == 0) {  // && -> and
                game_out++;
            }
// 0909
            if (game_out > 0) {
                System.out.println("결과 " + game_strike + " Strike, " + game_ball + " Ball, " + game_out + " Out");
            } else {
                System.out.println("결과 " + game_strike + " Strike, " + game_ball + " Ball");
            }

            // 1) 패배 (5번 시도) 2) 패배 (아웃 2번)
            if (game_count == 5)  {
                if (game_out == 2){
                    System.out.println("게임 종료: 패배 (2 아웃)");
                    break;
                }
                System.out.println("게임 종료: 패배(시도횟수 5번 초과)");
                break;
            }

            // 3) 승리 (strike 3)
            if (game_strike == 3) {
                System.out.println("\n게임 종료: 승리");
                break;
            }
        }

        System.out.print("정답: ");
        for (int num : cp_li) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}