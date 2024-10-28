package study.특강;

import java.util.Scanner;

public class No1_2 {
    private static int inputInt(Scanner sc, String prompt) {
        System.out.print(prompt);  // 사용자에게 메시지를 출력
        int length = sc.nextInt(); // 사용자가 입력한 정수를 저장
        System.out.println("입력 값: " + length); // 입력한 값을 출력
        return length;             // 입력한 값을 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.print("첫 번째 변의 길이를 입력하세요: ");
//        int lineA = sc.nextInt();
//        System.out.print("두 번째 변의 길이를 입력하세요: ");
//        int lineB = sc.nextInt();
//        System.out.print("세 번째 변의 길이를 입력하세요: ");
//        int lineC = sc.nextInt();
        int lineA = inputInt(sc, "첫 번째 변의 길이를 입력해주세요: ");
        int lineB = inputInt(sc, "두 번째 변의 길이를 입력해주세요: ");
        int lineC = inputInt(sc, "세 번째 변의 길이를 입력해주세요: ");


        // 삼각형을 만들 수 없으면 메소드 종료 (두변의 길이 합이 나머지 한변의 길이보다 작거나 같다)
        //if (lineA + lineB <= lineC || lineB + lineC <= lineA || lineC + lineA <= lineB) {
        // 한 조건 안에서 abc의 순서를 정돈
        if (lineA + lineB <= lineC || lineA + lineC <= lineB || lineB + lineC <= lineA) {
            System.out.println("입력하신 변의 길이로는 삼각형을 만들 수 없습니다.");
            System.out.println("삼각형을 만들기 위해서는 어떤 두 변의 길이의 합이 다른 한 변의 길이보다 커야 합니다.");
            return;
        }

        // 삼각형을 만들 수 있음
        String triangle = "";
        // 세변의 길이가 모두같다
        if (lineA == lineB && lineA == lineC) {
            triangle = "정삼각형";
        }
        // 세변중 두변의 길이가 같다
        //else if (lineA == lineB || lineB == lineC || lineC == lineA) {
        else if (lineA == lineB || lineA == lineC || lineB == lineC) {
            triangle = "이등변삼각형";
        }
        // 세변의 길이가 모두 다르다
        else{
            triangle = "부등변삼각형";
        }

        System.out.println("입력하신 변의 길이로는 " + triangle + "을 만들 수 있습니다.");

        sc.close();
    }
}
