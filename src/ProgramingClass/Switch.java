package ProgramingClass;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연산자: ");
        String f = sc.nextLine();

        System.out.print("숫자: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = switch (f){
            case "+" -> a + b;
            case "-" -> a - b;
            default -> 0;
        };

        System.out.println(result);

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
//            default -> 0;
//        };
//        System.out.print(num);

    }
}
