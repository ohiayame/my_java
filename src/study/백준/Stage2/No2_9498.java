package study.백준.Stage2;

import java.util.Scanner;

public class No2_9498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 시험 성적
        int score = sc.nextInt();
        sc.close();
        char rank = 'F';

        if ((score >= 90) && (score <= 100)) {
             rank = 'A';
        }else if ((score >= 80) && (score < 90)){
            rank = 'B';
        }else if ((score >= 70) && (score < 80)){
            rank = 'C';
        }else if ((score >= 60) && (score < 70)){
            rank = 'D';
        }
        System.out.println(rank);
    }
}
