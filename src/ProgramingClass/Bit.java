package ProgramingClass;

public class Bit {
    public static void main(String[] args) {
        int flags = 0b00001010; // 현재 상태: 2번째, 4번째 비트가 켜짐
        flags |= (1 << 2);
        System.out.println(Long.toBinaryString(flags)); // 1110

        int value = 0b00001010;
        value ^= (1 << 2);
        System.out.println(Long.toBinaryString(value)); // 1110

        int num = 0b10101100; // 8비트 숫자
        if ((num & (1 << 2)) != 0) {
            // 3번째 비트가 1이면 실행
            System.out.println(Integer.toBinaryString(num));

        }
        long flag = 0b111;
        flag &= ~(1L << 1);  // &가 없으면 -> 1111111111111111111111111111111111111111111111111111111111111101
        System.out.println(Long.toBinaryString(flag)); // 101
    }
}
