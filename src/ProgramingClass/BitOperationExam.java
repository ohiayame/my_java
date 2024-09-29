package ProgramingClass;

public class BitOperationExam {
    public static void main(String[] args) {
        int a = 6;  // 0110
        int b = 3;  // 0011

        // 1. 비트 and 연산 (둘 다 1인 경우에만 1)
        int resultAnd = a & b;  // 0110 & 0011 = 0010 (= 2)
        System.out.println("a & b = " + resultAnd);

        // 2. 비트 or 연산 (둘 중 하나라도  1인 경우에 1)
        int resultOr = a | b; // 0110 | 0011 = 0111 (= 7)
        System.out.println("a | b = " + resultOr);

        // 3. 비트 xor 연산 (둘이 다르면 1, 같으면 0)
        int resultXor = a ^ b; // 0110 ^ 0011 = 0101 (= 5)
        System.out.println("a ^ b = " + resultXor);

        // 4. 비트 NOT 연상 (각 비트를 반전, 0를 1로, 1을 0으로)
        int resultNot = ~a;  // ~0110 = 1001 (2's complement에서 -7)
        System.out.println("~a = " + resultNot);

        // 5. 비트 왼쪽 시프트 (왼쪽으로 비트 이동, 값이 2배로 증가
        int resultLeftShift = a << 1; // 0110 << 1 = 1100 (= 12)
        System.out.println("a << 1 = " + resultLeftShift);

        // 6. 미트 오른족 시프트 (오른쪽으로 미트 이동, 값이 2로 나눠짐)
        int resultRightShift = a >> 1;  // 0110 >> 1 = 0011 (= 3)
        System.out.println("a >> 1 = " + resultRightShift);

    }
}
