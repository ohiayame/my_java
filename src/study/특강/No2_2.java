package study.특강;

import java.util.Scanner;

public class No2_2 {
    public static void calculate_average(float math_score , float science_score, float english_score ){
        float all_score =  math_score + science_score + english_score;
        float avg = all_score / 3;
        char grade;

        if (avg >= 90){
            grade = 'A';
        }
        else if (avg >= 80){
            grade = 'B';
        }
        else if (avg >= 70){
            grade = 'C';
        }
        else if (avg >= 60){
            grade = 'D';
        }
        else{
            grade = 'F';
        }

        System.out.println("평균 점수는 " + avg + "이고, 학점은 " + grade + "입니다.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("수학 점수를 입력하세요: ");
        float math_score = sc.nextFloat();

        System.out.print("과학 점수를 입력하세요: ");
        float science_score = sc.nextFloat();

        System.out.print("영어 점수를 입력하세요: ");
        float english_score = sc.nextFloat();

        calculate_average(math_score, science_score, english_score);
    }
}
