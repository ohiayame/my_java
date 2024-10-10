package study.백준.Stage3;

import java.util.Scanner;

public class No1_2739 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //  index값 , 언제까지 반복하는지 , 반복할 때 인덱스 값이 어떻게 증감하는지
        for (int i = 1; i < 10; i++) {
            System.out.println(n + " * " + i + " = " + n * i);
        }
    }
}
