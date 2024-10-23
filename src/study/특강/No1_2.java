package study.특강;

import java.util.Scanner;

public class No1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 변의 길이를 입력하세요: ");
        int lineA = sc.nextInt();
        System.out.print("두 번째 변의 길이를 입력하세요: ");
        int lineB = sc.nextInt();
        System.out.print("세 번째 변의 길이를 입력하세요: ");
        int lineC = sc.nextInt();

        // 세변의 길이가 모두같다
        if (lineA == lineB && lineA == lineC) {
            System.out.println("입력하신 변의 길이로는 정삼각형을 만들 수 있습니다.");
        }// 두변의 길이 합이 나머지 한변의 길이보다 작거나 같다
        else if (lineA + lineB <= lineC || lineB + lineC <= lineA || lineC + lineA <= lineB) {
            System.out.println("입력하신 변의 길이로는 삼각형을 만들 수 없습니다.");
            System.out.println("삼각형을 만들기 위해서는 어떤 두 변의 길이의 합이 다른 한 변의 길이보다 커야 합니다.");
        }// 세변중 두변의 길이가 같다
        else if (lineA == lineB || lineB == lineC || lineC == lineA) {
            System.out.println("입력하신 변의 길이로는 이등변삼각형을 만들 수 있습니다.");
        }// 세변의 길이가 모두 다르다
        else{
            System.out.println("입력하신 변의 길이로는 부등변삼각형을 만들 수 있습니다.");
        }
        sc.close();
    }
}
