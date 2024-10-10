package study.백준.Stage2;

import java.util.Scanner;

public class No6_2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();

        int time = sc.nextInt();

        if (m + time >= 60){
            int addH = (m + time) / 60;
            h += addH;
            m = (m + time) - (60 * addH);

        }else{
            m += time;
        }
        if (h >= 24) h -= 24;

        System.out.println(h + " " + m);
        sc.close();
    }
}
