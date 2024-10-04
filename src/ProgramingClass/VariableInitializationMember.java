package ProgramingClass;

public class VariableInitializationMember {
    int num; //  기본 초기값 0  1usage
    boolean flag;  //  기본 초기값 false  1usage
    String text;  // 기본 초기값 null  1usage

    public static void main(String[] args) {
        VariableInitializationMember example  = new VariableInitializationMember();

        // 기초 초기값 출력
        System.out.println(example.num);  // 0
        System.out.println(example.flag);  // false
        System.out.println(example.text);  // null

        int bar;  // 지역 변수 선언, 초기화되지 않음
//        System.out.println(example.num);  // 컴파일 오류 발생: 변수 num이 초기화되지 않음

        bar = 10; // 초기화
        System.out.println(bar);  // 출력  10
    }
}
