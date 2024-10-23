package study.특강;

import java.util.Scanner;

public class No1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("사용자의 나이를 입력해주세요: ");
        int age = sc.nextInt();
        String target;

        if (age <= 12) {
            target = "어린이";
        }else if (age <= 18){
            target ="청소년";
        }else{
            target = "성인";
        }

        System.out.println(target + " 이용권을 사용할 수 있습니다.");
        sc.close();
    }
}
