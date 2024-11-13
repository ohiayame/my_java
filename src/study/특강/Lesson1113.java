package study.특강;

import java.util.Scanner;

public class Lesson1113 {
    // 메뉴를 선택하세요 (게임실행 횟수출력)
    static void Manu(){
        System.out.println("=====================");

        // 1. M X N Matrix를 출력
        System.out.println("1. M X N Matrix를 출력");
        // 2. 좌상단->우하단 대각선 삭제 후 M X N Matrix 출력
        System.out.println("2. 좌상단->우하단 대각선 삭제 후 M X N Matrix 출력");
        // 3. 좌상단->우하단 + 우상단->좌하단 대각선 삭제 후 M X N Matrix 출력
        System.out.println("3. 좌상단->우하단 + 우상단->좌하단 대각선 삭제 후 M X N Matrix 출력");
        // 4. 종료
        System.out.println("4. 종료");
        System.out.println("=====================");
    }

    static int[] checkInputValueRange(Scanner sc) {
        // mn 를 입력 받아
        // 사용자로부터 M, N 정수를 입력 받기
        int[] inputValues = new int[2];

        while (true) {
            System.out.print("M값을 입력하세요: ");
            inputValues[0] = sc.nextInt();
            System.out.print("N값을 입력하세요: ");
            inputValues[1] = sc.nextInt();

            // 예외처리 : M과 N이 0 또는 음의 정수인 경우, 재입력
            if (inputValues[0] > 0 && inputValues[1] > 0) {
                break;
            }
        }

        return inputValues;
    }

    static void printMatrix(int argSelectedMenu, int[] argInputValues) {
        // 전달 받은 값의 결과를 실행
        switch (argSelectedMenu) {
            // 1번 : 사용자로부터 M, N 정수를 입력 받아, M X N Matrix를 출력하세요
            case 1:
                // 예) M : 3, N : 2
                //   * *
                //   * *
                //   * *
                for (int i = 0; i < argInputValues[0]; i++) {
                    for (int j = 0; j < argInputValues[1]; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            // 2번: 좌상단->우하단 대각선 삭제 후 M X N Matrix 출력
            case 2:
                //     * *
                //   *   *
                //   * *
                for (int i = 0; i < argInputValues[0]; i++) {
                    for (int j = 0; j < argInputValues[1]; j++) {
                        if (i == j){
                            System.out.print(" ");
                        }else {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;

            // 3번: 좌상단->우하단 + 우상단->좌하단 대각선 삭제 후 M X N Matrix 출력
            case 3:
                //     *
                //   *   *
                //     *
                for (int i = 0, returnNum = argInputValues[1]-1 ; i < argInputValues[0]; i++, returnNum--) {
                    for (int j = 0; j < argInputValues[1]; j++) {
                        if (i == j || j == returnNum) {
                            System.out.print(" ");
                        }else {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // isGameOver
        boolean isGameOver = false;
        // 게임횟수
        int gameCount = 0;

        // while) 전체 실행
        while (true) {
            gameCount++;
            // 1) 메뉴 출력
            Manu();
            System.out.println("* 현재 실행 횟수: " + gameCount);

            int menuNum = 0;
            // 메뉴를 입력 받아 해당 프로그램 실행 후 다시 메뉴 출력
            while(true){
                System.out.print("메뉴를 선택하세요: ");
                menuNum = sc.nextInt();
                // 1~4이외 재입력(메뉴출력 X)
                if (0 < menuNum && menuNum <= 4 ) {
                    break;
                }
                System.out.println("다시 입력");
            }
            // 2) 입력에 따라 코드 실행
            int[] inputValue = null;
            switch (menuNum) {
                // 입력된 값의 메뉴 실행
                // 1번 메소드 호출
                case 1,2,3:
                    inputValue = checkInputValueRange(sc);
                    printMatrix(menuNum, inputValue);
                    break;

                // 4. 종료
                case 4:
                    isGameOver = true;
                    break;
            }

            if (isGameOver) {
                System.out.println("!!!  Game Over  !!!");
                break;
            }

        }
        System.out.println("총 실행 횟수 " + gameCount + "번! *프로그램 종료");
    }
}
