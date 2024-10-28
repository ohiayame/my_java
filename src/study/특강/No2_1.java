package study.특강;

import java.util.Scanner;

public class No2_1 {
    // 제곱미터를 평방피트로 변환
    public static float convert_to_square_feet(float square_meters){
        float square_feet = square_meters * 10.7639f;
    return square_feet;
    }
    //  제곱미터를 에이커로 변환
    public static double convert_to_acres(double square_meters){
        double acres = square_meters / 4046.86;
        return acres;
    }

    public static void main(String[] ages){
        Scanner sc = new Scanner(System.in);

        System.out.print("토지의 면적을 제곱미터(m²) 단위로 입력하세요: ");
        int square_meters = sc.nextInt();

        // 입력 값 양수
        if (square_meters >= 0){
            // 제곱미터를 평방피트로 변환
            float square_feet = No2_1.convert_to_square_feet(square_meters);
            //  제곱미터를 에이커로 변환
            double acres = No2_1.convert_to_acres(square_meters);

            System.out.println(square_meters + " 제곱미터는 " + square_feet + "평방피트입니다.");
            System.out.println(square_meters + " 제곱미터는 " + acres + "에이커입니다.");
        }// 입력 값 음수
        else{
            System.out.println("잘못된 입력입니다.");
        }

        sc.close();
    }
}
