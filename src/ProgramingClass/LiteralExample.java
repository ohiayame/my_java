package ProgramingClass;

public class LiteralExample {
    public static void main(String[] args) {


        // 정수 리터럴 접두사 사용 예제

        // 10진수 정수 리터럴(Decimal)
        int decimalNumber = 42; // 10진수로 42

        // 2진수 정수 리터럴(binary) - 접두사 '0b'
        int binaryNumber = 0b101010; // 2진수로 101010, 10진수로 42

        // 8진수 정수 리터럴 (octal) - 접두사 '0'
        int octalNumber = 052; //16진수로 52, 10진수로 42

        // 16진수 정수 리터럴 (hexadecimal) - 접두사 '0x'
        int hexadecimalNumber = 0x2A; //16진수로 2A, 10진수로 42

        // 출력
        System.out.println("Decimal Number: " + decimalNumber);
        System.out.println("Binary Number: " + binaryNumber);
        System.out.println("Octal Number: " + octalNumber);
        System.out.println("Hexadecimal Number: " + hexadecimalNumber);

        // 부동소수점 리터럴 접미사 사용 예제

        // 부동소수점 리터럴 (float 타입) - 접미사 'f' 또는 'F'
        float floatNumber = 3.14f; // 또는 3.14F

        // 부동소수점 리터럴 (double 타입) - 접미사 'd' 또는 'D'
        double doubleNumber = 2.71828; // 접미사 생략 가능, 또는 2.71828d 도는 2.71828D

        // 출력
        System.out.println("Float Number: " + floatNumber);
        System.out.println("Double Number: " + doubleNumber);

        // 문자와 문자열 리터럴 예제

        // 문자 리터럴
        char letter = 'A'; // 단일 문자 리터럴

        // 문자열 리터럴
        String greeting = "Hello, World!"; // 문자열 리터럴

        // 출력
        System.out.println("Character: " + letter);
        System.out.println("String: " + greeting);

        // 물리언 리터럴 예제

        //불리언 리터럴
        boolean isJavaFun = true;
        boolean isFishTasty = false;

        // 출력
        System.out.println("Is Java Fun? " + isJavaFun);
        System.out.println("Is Fish Tasty? " + isFishTasty);
    }
}
