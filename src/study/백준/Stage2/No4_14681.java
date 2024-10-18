package study.백준.Stage2;

import java.util.Scanner;

public class No4_14681 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        int quadrant = 0;
        if(x < 0){
            if(y < 0){
                quadrant = 3;
            }else {
                quadrant = 2;
            }

        }else{
            if(y < 0){
                quadrant = 4;
            }else{
                quadrant = 1;
            }
        }
        System.out.println(quadrant);
        sc.close();
    }
}
//        if(X > 0 && Y > 0) {
//            System.out.println("1");
//        } else if(Y > 0){
//            System.out.println("2");
//        } else if(X < 0 && Y < 0) {
//            System.out.println("3");
//        } else {
//            System.out.println("4");
//        }

