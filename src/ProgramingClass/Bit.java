package ProgramingClass;

public class Bit {
    public static void main(String[] args) {
//        int flags = 0b00001010; // 현재 상태: 2번째, 4번째 비트가 켜짐
//        flags |= (1 << 2);
//        System.out.println(Long.toBinaryString(flags)); // 1110
//
//        int value = 0b00001010;
//        value ^= (1 << 2);
//        System.out.println(Long.toBinaryString(value)); // 1110
//
//        int num = 0b10101100; // 8비트 숫자
//        if ((num & (1 << 2)) != 0) {
//            // 3번째 비트가 1이면 실행
//            System.out.println(Integer.toBinaryString(num));
//
//        }
//        long flag = 0b111;
//        flag &= ~(1L << 1);  // &가 없으면 -> 1111111111111111111111111111111111111111111111111111111111111101
//        System.out.println(Long.toBinaryString(flag)); // 101


        int bar = 0b10101111101010101010101010101010;
        int mask = 0x00ff0000;
        System.out.println(Integer.toBinaryString(bar&mask)); // 1010 1010

        // Get
        int foo = 0b01001010111000100000000010111011;
        int masking = 0b01000000000000000000000000000000;
        System.out.println(Integer.toBinaryString(foo&masking)); // 1000000000000000000000000000000

        int bitPosition = 30;
        int smartMask = 1 << bitPosition;
        boolean result = (foo & smartMask) != 0;
        System.out.println(result); // true

        // Set
        int setPosition = 31;
        int re = foo & ~(1 << setPosition);
        System.out.println(Long.toBinaryString(re)); // true

        int a = 2; // 10
        int b = a & ~(1 << 1); //  10 ->  01 ->  10 &  01 -> 00
        int c = a & ~(1 << 2); // 100 -> 011 -> 010 & 011 -> 10
        int d = a & ~(0 << 1); //  00 ->  11 ->  10 &  11 -> 10
        int e = a & ~(0 << 2); // 000 -> 111 -> 010 & 111 -> 10
        int f = a & (0 << 1);  //  00 ->         10 &  00 -> 00
        int g = a & (1 << 1);  //  10 ->         10 &  10 -> 10
        System.out.println(Long.toBinaryString(g));

        int kin = 0b1000;
        System.out.println(kin);  // 8
        System.out.println(kin>>2); // 4
        System.out.println(kin<<1);// 16

        int m = 0b10000000000000000000000000000000;
        int i = m >> 1;
        System.out.println(Integer.toBinaryString(i) + " : " + i);  // -1073741824 부호를 유지
        int t = m >>> 1;
        System.out.println(Integer.toBinaryString(t) + " : " + t);  // 1073741824
    }
}
