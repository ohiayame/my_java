package study.백준.Stage1;

import java.util.Scanner;

public class No10_2588 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int A = in.nextInt();
        String B = in.next();

        in.close();
        // -'0' : 아스키코드가 아닌 숫자 그대로의 값을 쓰기 위해
        System.out.println(A * (B.charAt(2) - '0'));
        System.out.println(A * (B.charAt(1) - '0'));
        System.out.println(A * (B.charAt(0) - '0'));
        System.out.println(A * Integer.parseInt(B));

    }
}
