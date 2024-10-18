package study.백준.Stage3;

import java.util.Scanner;

public class No4_25304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int allPrice = sc.nextInt();

        int value = sc.nextInt();
        for (int i = 0; i < value; i++) {
            int price = sc.nextInt();
            int num = sc.nextInt();

            allPrice -= (price * num);
        }
        String result = allPrice == 0 ? "Yes" : "No";
        System.out.println(result);
    }
}
