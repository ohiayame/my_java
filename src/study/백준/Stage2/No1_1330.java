package study.백준.Stage2;

import java.util.Scanner;

public class No1_1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        if (a < b){
            System.out.println("<");
        } else if (a == b) {
            System.out.println("==");
        }else {
            System.out.println(">");
        }
    }
}
