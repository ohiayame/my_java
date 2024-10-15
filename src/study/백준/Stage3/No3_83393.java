package study.백준.Stage3;

import java.util.Scanner;

public class No3_83393 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.close();
        int sumValue = 0;

        for (int i = 1; i <= num; i++) {
            sumValue += i;
        }
        System.out.println(sumValue);

    }
}