package study.특강;

import java.util.Scanner;

public class Lesson1030 {
//    public static void main(String[] args) {
//        // 키보드로 부터 정수 n을 입력 받아 n개의 int형 원소를 가지는 1차언 배열 작성
//        Scanner sc = new Scanner(System.in); // while문 안에 scanner를 선언 해버리면 scanner 중복해서 생성됨
//        // 입력받는 int형 변수를 초기화 (int n;로 선언해버리면 만약에 초기화를 안하고 사용하려고 한 경우 애러)
//        int n = 0;   // while문 밖에 미리 선언 안하면 while문이 끝났을때 날라감(지역변수의 생명주기 -> 선언된 {}(브럭)안에서만 사용 가능)
//
//        // 1) 입력 알고리즘
//        while (true){
//            // 입력 받기
//             n = sc.nextInt();
//            // 탈출 조건: N 값 1~10
//            if (1 <= n && 10 >= n){
//                break;
//            }
//        }
//        sc.close();
//
//        // 2) n개의 int형 원소를 가지는 1차언 배열 작성
//        int[] array = new int[n];
//    }

    public static void main(String[] args) {
        // 1) 생성된 N개의 원소에 정수 값을 입력하는 구문
        // N를 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // N개의 원소를 가지는 배열을 생성
        int[] array = new int[n];

        // 배열의 길이 만큼(N개) 반복해서 값을 입력받아 인덱스 값을 이용해 값을 대입
        for (int i = 0; i < array.length; i++) { // 배열을 순회할 때는 array.length가 적절함
            // 입력 받기
            System.out.print(i+1 + "번째: ");
            int value = sc.nextInt();
            array[i] = value;
        }
        sc.close();

        // 2) 입력된 원소를 한개 씩 출력하는 for-each 문을 작성
        // 배열을 순회해서 원소를 한개씩 출력
        for (int i : array) {
            System.out.print(i + ", ");
        }

        // 3) 배열 내 최대값과 최소값을 출력
        // 최대값과 최소값을 배열의 첫번째 값으로 초기화
        int maxNum = array[0];
        int minNum = array[0];
        // 원소의 합을 저장하는 변수를 초기화
        int sum = 0;
        // for 문으로 최대값과 최소값을 비교
        for (int value : array) {
            // 첫번째 원소를 최대값 변수, 최소값 변수에 대입
            if (value > maxNum) {
                maxNum = value;
            }else if (value < minNum) {
                minNum = value;
            }
            // 원소의 값을 더하기 (누적값: 累積値)
            sum += value;
        }

        // 4) 평균을 출략
        // 모든 원소를 더한 값을 배열의 크기로 나누고 평균을 계산
        float avg = (float)sum / array.length;

        System.out.println("최댓값: " + maxNum);
        System.out.println("최소값: " + minNum);
        System.out.printf("평균: %.2f ", avg); // 소수점 자리수를 지정
    }
}