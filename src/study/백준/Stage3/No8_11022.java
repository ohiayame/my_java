package study.백준.Stage3;

import java.util.Scanner;

public class No8_11022 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String arr[] = new String[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[i] = a + " + " + b + " = " + (a+b);
        }
        for (int l = 0; l < n; l++) {
            System.out.println("Case #" + (l + 1) + ": " + arr[l]);
        }
    }
}
