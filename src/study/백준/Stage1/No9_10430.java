package study.백준.Stage1;

import java.util.Scanner;

public class No9_10430 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        in.close();
        // (A+B)%C
        System.out.println((a+b) % c);
        // ((A%C) + (B%C))%C
        System.out.println(((a % c) + (b % c)) % c);
        // (A×B)%C
        System.out.println((a * b) % c);
        // ((A%C) × (B%C))%C
        System.out.println(((a % c) * (b % c)) % c);
    }
}
