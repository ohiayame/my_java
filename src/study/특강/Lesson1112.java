package study.특강;

import java.util.Scanner;

public class Lesson1112 {
    public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		// m * n matrix출력
//		// m, n 초기화
//		int m = 0;
//		int n = 0;
//
//		// while) 입력 값이 0 또는 음수 -> 재입력
//		while(true) {
//			// 입력 받기
//			System.out.print("m값을 입력하세요: ");
//			m = sc.nextInt();
//			System.out.print("n값을 입력하세요: ");
//			n = sc.nextInt();
//
//			//	탈출 조건 : 1 이상
//			if (m > 0 && n > 0) {
//				break;
//			}
//			System.out.println("양수를 입력하세요");
//		}
//
//		// 1)
//		// for (m 의 반복
//		for (int i = 0; i < m; i++) {
//			// for (n 의 반복
//			for (int j = 0; j < n; j++) {
//				// "*" 출력
//				System.out.print("*");
//			}
//		// 개행
//			System.out.println();
//		}
//
//		System.out.println("------------------");
//
//
//		// 2) 1와 동일한 알고리즘
//		// 추가 조건 :  \대각선 공백처리
//		// for (m 의 반복
//		for (int i = 0; i < m; i++) {
//			// for (n 의 반복
//			for (int j = 0; j < n; j++) {
//				// n의 반복의 회수와 m의 반복의 회수가 동일할 때 " "(공백) 출력
//				if (i == j) {
//					System.out.print(" ");
//				}else {
//				// "*" 출력
//				System.out.print("*");
//				}
//			}
//		// 개행
//			System.out.println();
//		}
//
//		System.out.println("------------------");
//
//
//		// 3) 2와 동일한 알고리즘
//		// 추가조건: / 대각선 공백처리
//		for ( int i = 0, reverseIndex = n - 1 ; i < m ; i++, reverseIndex-- ) {
//			for ( int j = 0; j < n ; j++ ) {
//				// j == (n-1) - i -> 공백
////				if ( i == j  ||  j == (n-1) - i ) {
//				if ( j == i  ||  j == reverseIndex ) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");
//				}
//			}
//			// 개행
//			System.out.println();
//		}
//
//

        // 4)
        // row 값만 입력 받기
        // *
        // **
        // *
        int row = 5;
        //  top : int row / 2 까지 *
        for (int i = 0 ; i < row ; i++ ) {
            for(int j = 0; j <= row/2; j++ ) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

}

