package study.백준.Stage3;

import java.util.Scanner;

public class No10_2439 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println(" ".repeat(n - i) + "*".repeat(i));
        }
    }
}
