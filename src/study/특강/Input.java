package study.특강;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//
//        // short
//        short barShort = sc.nextShort();
//        // int
//        int barInt = sc.nextInt();
//        // long
//        long barLong = sc.nextLong();
//        // float
//        float barFloat = sc.nextFloat();
//        // double
//        double barDouble = sc.nextDouble();
//        // char
//        char barChar = sc.next().charAt(0);
//        // String
//        String barString = sc.nextLine();
//        // boolean
//        boolean barBoolean = sc.nextBoolean();

//        String bar = sc.next();
//        System.out.println(bar);
//
////        sc.nextLine();
//
//        String foo = sc.nextLine();
//        System.out.println(foo);


//        String inA = sc.nextLine();
//        String inB = sc.nextLine();
//
//        if (inA.equalsIgnoreCase(inB)){
//            System.out.println("참");
//        }else {
//            System.out.println("거짓");
//        }

//        String inC = sc.nextLine();
//        if ("hello".equals(inC)){
//            System.out.println("참");
//        }else{
//            System.out.println("거짓");
//        }

        // 알파벳 한글자 입력 받기
        char c = sc.next().charAt(0);

        // 소문자인지 확인 isLowerCase()
        if (Character.isLowerCase(c)) {
            // toUpperCase() 대문자로 반환
            System.out.println(Character.toUpperCase(c));
        }
        // 대문자인지 확인 isUpperCase()
        else if (Character.isUpperCase(c)) {
            // toLowerCase() 소문자로 반환
            System.out.println(Character.toLowerCase(c));
        }
    }
}








