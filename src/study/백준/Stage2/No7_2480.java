package study.백준.Stage2;

import java.util.Scanner;

public class No7_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int m = 0;

        if (a == b){
            if (a == c){
                m = 10000 + (a * 1000);
            }else{
                m = 1000 + (a * 100);
            }
        }else if (b == c){
            m = 1000 + (c * 100);
        }else if (a == c) {
            m = 1000 + (a * 100);
        }else{
            int max = Math.max(a, Math.max(b, c));
            m = max * 100;
        }
        System.out.println(m);
        sc.close();
    }
}
