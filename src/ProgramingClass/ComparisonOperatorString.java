package ProgramingClass;

public class ComparisonOperatorString {
    public static void main(String[] args) {

        String str1 = new String("Hello");
        String str2 = "Hello";

        // 내용은 같아도 서로 다른 객체
        System.out.println(str1 == str2);  // flase

        // 같은 문자열 내용을 가지고 있음
        System.out.println(str1.equals(str2)); // true

        // 리터럴상수는 값이 변하지 않기 때문에 JVM이 값을 공유해 해석
        String str3 = "Hello";
        System.out.println(str2 == str3); // true
    }
}
