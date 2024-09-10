
package ProgramingClass;

public class ConstantExample {
    public static void main(String[] args) {
        // 리터럴 상수 (Literal Constant)
        // '3.14159' 는 리터럴 상수로, 그 자체로 값의 의미를 가짐
        double piLiteral = 3.14159;
        System.out.println("리터럴 상수 piLiteral: " + piLiteral);

        // 일반 상수 (Named Constant)
        // 'final' 키워드를 사용해여 상수를 선언
        // 이름이 있는 상수는 한번 초기화된 후에 값을 변경할 수 있음
        final double PI = 3.14159;

        // PI = 3.14; // 오류 : 상수의 값을 변경하려고 시도 하면 컴파일 오류 발생

        System.out.println("일반 상수 PI: " + PI );

        // 리터럴 상수의 또 다른 예 (문자열)
        char letter = 'A'; // 'A'는 문자 리터럴 상수
        String greeting = "Hello, World!";  // "Hello, World!"는 문자열 리터럴 상수

        System.out.println("문자 리터럴 상수 letter: " + letter);
        System.out.println("문자열 리터럴 상수 greeting:" + greeting);

        // 일반 상수 예제 (불변 문자열)
        final String GREETING_MESSAGE = "Welcome to Java!";

        System.out.println("일반 상수 GREETING_MESSAGE: " + GREETING_MESSAGE);

        // 불리언 리터럴 상수 예제
        boolean isJavaFun = true; // 'true' 불리언 리터럴 상수
        System.out.println("불리언 리터럴 상수 isJavaFun: " + isJavaFun);
    }
}
