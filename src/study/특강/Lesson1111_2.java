package study.특강;

public class Lesson1111_2 {
    public static void main(String[] args) {
        // m, n 초기화
        int m = 0;
        int n = 0;

        // 만약 0 , 음수 -> 재입력
        while (true){
            // n, m 입력 받기
            m = 3;
            n = 3;
            if (m > 0 && n > 0) {
                break;
            }
        }
//        // m 반복
//        for (int i = 0; i < m; i++) {
//            // n 반복
//            for (int j = 0; j < n; j++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < m; i++) {
            // n 반복
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }
}
