package study.특강;

public class Lesson1101_2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 0~10
            int random = (int)(Math.random() * 11);
            // (Math.random() * (수의 범위)) + 최소 값;
            // 1~10
//            int random1 = (int)(Math.random() * 10) + 1;
//
            System.out.println(random);
//            System.out.println(random1);
//            System.out.println((int)random);
        }
    }
}
