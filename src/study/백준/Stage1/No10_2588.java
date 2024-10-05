package study.백준.Stage1;

import java.util.Scanner;

public class No10_2588 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String s = in.next();
        in.close();

        System.out.println(n * (s.charAt(2) - '0')); // 숫자 문자열.charAt(인덱스) - '0' => 아스키 코드의 해당 숫자
        System.out.println(n * (s.charAt(1) - '0'));
        System.out.println(n * (s.charAt(0) - '0'));
        System.out.println(n * Integer.parseInt(s)); // Integer.parseInt( ) => 전체를 정수로 변환
    }
}
