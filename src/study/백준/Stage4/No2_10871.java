package study.백준.Stage4;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Scanner;

public class No2_10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int max = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int num  = sc.nextInt();
            if (num < max) {
                list.add(num);
            }
        }
        for (int k : list) {
            System.out.print(k + " ");
        }
    }
}