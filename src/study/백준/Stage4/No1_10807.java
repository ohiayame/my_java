package study.백준.Stage4;

import java.util.Scanner;

public class No1_10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 입력 되는 숫자의 수
        int arr[] = new int[n]; // 리스트 선언

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }

        int foundNum = sc.nextInt(); // 찾으려는 번호
        int num = 0; // 번호가 리스트에 몇개잇는지 확인하는 변수

        for (int k : arr) {
            if (k == foundNum) {
                num += 1;
            }
        }
        System.out.println(num);
    }
}
