package ProgramingClass;

import java.util.Scanner;

public class Switch {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("연산자: ");
//        String f = sc.nextLine();
//
//        System.out.print("숫자: ");
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//
//        int result = switch (f){
//            case "+" -> a + b;
//            case "-" -> a - b;
//            default -> 0;
//        };
//
//        System.out.println(result);
//
//        int value = 2;
//        int a = 0;  // 이런 경우에 여기에 변수를 미리 선언하면 접근가능
//        int num = switch (value) {
//            case 1-> {
//                int a = 10;  // 새로 선언된 변수
//                yield a;
//            }
//            case 2 -> {
//                // a는 사용할 수 없음
//                a = 3;
//                yield a;
//            }
////            default -> 0;
//        };
//        System.out.print(num);
    public static void main(String[] args) {

        // 정 수 입력 받기
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
        // switch 문
//        String lang = "";
//        switch (num) {
//            // 1 -> Python
//            case 1:
//                lang = "Python";
//                break;
//            // 2 -> Java
//            case 2:
//                lang = "Java";
//                break;
//            // 3 -> C++
//            case 3:
//                lang = "C++";
//                break;
//            // 4 -> javaScript
//            case 4:
//                lang = "javaScript";
//                break;
//            default:
//                lang = "None";
//                break;
//        }
//        System.out.println(lang);

        // switch expression 문
//        String lang = switch (num) {
//            case 1 -> "Python";
//            case 2 -> "Java";
//            case 3 -> "C++";
//            case 4 -> "JavaScript";
//            default -> "None";
//        };
//        System.out.println(lang);


//        // default가 없어도 되는 경우
//        boolean isActive = false;
//        String status = switch (isActive) {
//            case true -> "Active";
//            case false -> "Inactive";
//        };
//        System.out.println(status);

//        enum Selection {ycjung, richard;};
//        Selection mySelection = Selection.ycjung;
//        String bar = switch (mySelection){
//            case Selection.ycjung -> "Python";
//            case Selection.richard -> "Java";
//        };


        // a,b,c 입력받기
        Scanner sc = new Scanner(System.in);
        char grade = sc.next().charAt(0);
        // pass, fail 입력 받기
        String gradeString = sc.nextLine();
        // msg
//        String msg = "장학금 없음";

        String msg = switch (grade) {
            case 'a' -> {
                // a && pass -> 전액 + 추가 장학금
                if (gradeString.equals("pass")) {
                    yield "전액 + 추가 장학금";
                } // a && fail -> 전액
                else {
                    yield "전액";
                }
            }
            case 'b' -> {
                // b && pass -> 전액
                if (gradeString.equals("pass")) {
                    yield "전액";
                }// 나머지 조건 -> 장학금 없음
                else {
                    yield "장학금 없음";
                }
            }
            // 나머지 조건 -> 장학금 없음
            case 'c' -> "장학금 없음";
            // a,b,c 아니면 -> Unknown
            default -> "Unknown";
        };

        System.out.println(msg);
    }
}
