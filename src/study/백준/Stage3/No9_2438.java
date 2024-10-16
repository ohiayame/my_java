package study.백준.Stage3;

import java.util.Scanner;

public class No9_2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int stars = sc.nextInt();
        String star = "*";

        for (int i = 0; i < stars; i++) {
            System.out.println(star);
            star += "*";
        }
        sc.close();
    }
}
