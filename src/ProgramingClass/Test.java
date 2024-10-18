package ProgramingClass;

public class Test {
    static void gugudan() {
        for (int dan = 2; dan <= 9; dan++) {
            for (int num = 1; num <= 9; num++) {
                System.out.println(dan + "*" + num + "=" + num * dan);
            }
            System.out.println();
        }
    }

    static void aToZ() {
        for (char startChar = 'a'; startChar <= 'z'; startChar++) {
            System.out.print(startChar);
        }
        System.out.println();
    }

    static void matrix() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 32; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // 사용자로부터 정수를 입력
        int inputValue = 3;

        // if series
        // 1 이면 구구단 출력
        if (inputValue == 1) {
            Test.gugudan();
            // 2 이면 a ~ z 출력
        } else if (inputValue == 2) {
            Test.aToZ();
            // 3 이면 8 X 32 "*" 출력
        } else if (inputValue == 3) {
            Test.matrix();
        }

        // switch
        switch (inputValue) {
            case 1:
                Test.gugudan();
                break;
            case 2:
                Test.aToZ();
                break;
            case 3:
                Test.matrix();
                break;
        }
    }
}
