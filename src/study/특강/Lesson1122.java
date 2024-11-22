package study.특강;

import java.util.Arrays;

public class Lesson1122 {
    public static void main(String[] args) {
        // 2차원 배열 선언
        char[][] msgArray = new char[4][];
        // 2차원 배열의 각 배열을 초기화
        msgArray[0] = new char[5];
        msgArray[1] = new char[3];
        msgArray[2] = new char[1];
        msgArray[3] = new char[4];

        // 배열마다 character를 지정
        // 1번째 배열
        msgArray[0][0] = 'h';
        msgArray[0][1] = 'e';
        msgArray[0][2] = 'l';
        msgArray[0][3] = 'l';
        msgArray[0][4] = 'o';
        // 2번째 배열
        msgArray[1][0] = 'H';
        msgArray[1][1] = 'o';
        msgArray[1][2] = 'w';
        // 3번째 배열
        msgArray[2][0] = 'a';
        // 4번째 배열
        msgArray[3][0] = 't';
        msgArray[3][1] = 'o';
        msgArray[3][2] = 'p';
        msgArray[3][3] = 's';

        // 2차원배열 순회
        // 배열의 i번째 배열
        for(int i = 0; i < msgArray.length; i++) {
            // i번째 배열의 j번째 원소 출력
            for (int j = 0; j < msgArray[i].length; j++) {
                System.out.print(msgArray[i][j] + " ");
            }
            // 개행
            System.out.println();
        }

        // char형만 원소를 추출해서 출력 할 수 있음
        System.out.println(msgArray[0]);

        for (char[] msg : msgArray){
            System.out.println(msg);

        }

        for(int i = 0; i < msgArray.length; i++) {
            System.out.println(Arrays.toString(msgArray[i]));
        }


    }
}
