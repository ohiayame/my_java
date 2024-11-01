package study.특강;

import java.util.Scanner;

public class Report1101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1) 정수 n을 입력 받기
        // n을 초기화
        int n = 0;
        // (while) 0 이하 -> 재입력
        while (true){
            System.out.print("배열의 길이를 입력: ");
            n = sc.nextInt();
            if (0 < n){
                break;
            }
            System.out.println("다시 입력!!");
        }
        // 2) n개의 정수형 원소를 가지는 1차원 배열을 생성
        int array[] = new int[n];

        // 3) (while) 난수 범위(start, end)를 정수형으로 입력 받기
        // start, end 초기화
        int start = 0;
        int end = 0;
        while (true) {
            // 입력 받기
            System.out.print("난수의 최소값을 입력:");
            start = sc.nextInt();
            System.out.print("난수의 최대값을 입력:");
            end = sc.nextInt();
            // 조건 : 배열의 길이(n) < (end - start + 1)
            if (n <= (end - start + 1)){
                break;
            }
            // 안되면 재입력
            System.out.println("다시 입력!!");
        }

        // 배열을 순회
        // start <= rand value <= end 범위의 난수를 발생 -> 배열에 저장
        for (int i = 0; i < array.length; i++) {
//        for (int value : array) {
            //  난수의 범위 설정: * (end - start + 1)) + start
            int randomNum = (int) (Math.random() * (end - start + 1) + start) ;
//            value = randomNum;
            array[i] = randomNum;

        }

        // 출력
        for (int i : array) {
            i = 3;
            System.out.print(i + " ");
        }

        for (int i : array) {
            System.out.print(i + " ");
        }



        // 출력
    }
}
