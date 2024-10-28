package study.특강;

import java.util.Scanner;

public class No1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 나이를 입력 받기
        System.out.print("사용자의 나이를 입력해주세요: ");
        int age = sc.nextInt();

        // 음수면 메소드 종료
        if (age <= 0){
            return;
        }

        // 대상을 선택
        String target = "";  //  = "" 는 없어도 되지만 있으면 좋음
        // 12세 이하
        if (age <= 12) {
            target = "어린이";
        // 13~ 18세
        }else if (age <= 18){
            target ="청소년";
        // 19세 이상
        }else{
            target = "성인";
        }

        // 결과를 출력
        System.out.println(target + " 이용권을 사용할 수 있습니다.");
        sc.close();
    }
}
