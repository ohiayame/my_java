package study.특강;

import java.util.Scanner;

public class Lesson1101 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1) 키보드에서 입력 받기
        // n값(배열의 길이)을 저장하는 변수를 선언하여 초기화
        int n = 0;

        // 만약 n값(int) 1~10 이외 재입력
        while (true) {
            // 입력 받기
            System.out.print("배열의 길이 입력: ");
            n = sc.nextInt();
            // 조건 만족 -> 탈출
            if (1 <= n && n <= 10) {
                break;
            }
            System.out.println("다시 입력");
        }

        // 2 ) n개의 int형의 원소를 가지는 1차원 배열 생성
        int nArray[] = new int[n];

        // 3) 배열을 순회하여 값을 입력 받기(for)
        for (int i = 0; i < nArray.length; i++) {
            // 입력 받는 원소 값을 저장하는 변수를 선언하여 초기화
            int value = 0;
            // 만약 음수, 0 -> 재입력
            while (true){
                // 입력 받기
                System.out.print( i+1 + "번쩨 입력: ");
                 value = sc.nextInt();
                 // 양수 -> 탈출
                if (0 < value) {
                    break;
                }
                System.out.println("다시 입력");
            }
            // 입력 받은 원소 값을 삽입(i-> (배열의 인덱스)
            nArray[i] = value;
        }
        sc.close();

        // 4) 배열을 역순으로 출력 (배열 길이의 -1 -> 0 반복)
        for (int i = nArray.length -1; i >= 0; i--) {
            System.out.print(nArray[i] + ", ");
        }
    }
}
