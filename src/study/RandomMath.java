package study;

import java.util.Scanner;

public class RandomMath {
    // random 메소드 생성
    static int  random(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) {
        // 1~100 사이의 값을 렌덤ㅎ게 생성해 출력
        int randomNum = random(0, 100);
        System.out.println(randomNum);
        // n(양수)개의 배열을 생성해 50~100의 값을 렌덤하게 생성해 대입
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (true) {
            n = sc.nextInt();
            if (n > 0){
                break;
            }
        }
        // 중복 X
        int array[] = new int[n];
        for (int i = 0; i < array.length; i++) {
            int randomValue = 0;
            boolean flag = true;
            while(true){
                randomValue = random(50, 100);
                for (int j = 0; j < array.length; j++) {
                    if (randomValue == array[j]) {
                        flag = false;
                    }
                }
                if (flag) {
                    break;
                }
            }

            array[i] = randomValue;
        }
        for (int k : array) {
            System.out.print(k + " ");
        }
    }

}
