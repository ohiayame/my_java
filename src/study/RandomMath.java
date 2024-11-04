package study;

import java.util.Scanner;

public class RandomMath {
    // random 메소드 생성
    static int  random(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) {
        // 1~100 사이의 값을 렌덤ㅎ게 생성해 출력
//        int randomNum = random(0, 100);
//        System.out.println(randomNum);
        // n(양수)개의 배열을 생성해 50~100의 값을 렌덤하게 생성해 대입
        Scanner sc = new Scanner(System.in);
        int n = 0;
        // 음수면 다시 입력 받기
        while (true) {
            n = sc.nextInt();
            if (n > 0){
                break;
            }
        }
        // 중복 X random하게 값을 생성해 배열에 대입
        int array[] = new int[n];
        // 배열은 순회
        for (int i = 0; i < array.length; i++) {
            int randomValue = 0;
            // 중복이 있으면 다시
            while(true){
                boolean flag = true;
                randomValue = random(5, 10); // max값은 max-1의 값까지
                // 중복 체크
                for (int j = 0; j < array.length; j++) {
                    if (randomValue == array[j]) {
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }
            // 중복이 없으면 대입
            array[i] = randomValue;
        }
        // 출력
        for (int k : array) {
            System.out.print(k + " ");
        }
    }

}
