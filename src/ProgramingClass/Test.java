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
}
