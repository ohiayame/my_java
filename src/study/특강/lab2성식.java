package study.특강;
import java.util.Scanner;
public class lab2성식 {


    static void printMenu() {
        System.out.println("메뉴");
        System.out.println("1. 학생 성적 입력");
        System.out.println("2. 입력된 학생 목록 출력");
        System.out.println("3. 학생 삭제하기");
        System.out.println("4. 종료");
    }

    public static void main(String[] args) {

        // 변수 정의
        final int NUM_OF_FIELDS = 6;
        final int NUM_OF_ROWS = 3;

        int numOfStd = 0;
        boolean isExit = true;

        // 배열 생성
        float[][] stdMatrix = new float[NUM_OF_ROWS][NUM_OF_FIELDS];

        Scanner sc = new Scanner(System.in);

        // 메뉴 출력
        while (isExit) {

            // 메뉴 출력
            printMenu();

            // 메뉴 입력 받기
            System.out.print("선택: ");
            int numChoice =  sc.nextInt();

            // 메뉴에 따른 선택
            switch (numChoice) {
                case 1:
                    // 1번 - 성적 입력
                    // 학번, 국어, 영어, 수학 입력받기
                    System.out.print("학번을 입력하세요: ");
                    stdMatrix[numOfStd][0] = sc.nextFloat();
                    System.out.print("국어 성적: ");
                    stdMatrix[numOfStd][1] = sc.nextFloat();
                    System.out.print("영어 성적: ");
                    stdMatrix[numOfStd][2] = sc.nextFloat();
                    System.out.print("수학 성적: ");
                    stdMatrix[numOfStd][3] = sc.nextFloat();
                    stdMatrix[numOfStd][4] = stdMatrix[numOfStd][1] + stdMatrix[numOfStd][2] + stdMatrix[numOfStd][3];
                    stdMatrix[numOfStd][5] = stdMatrix[numOfStd][4] / 3.0f;

                    // 학생수 + 1
                    numOfStd++;

                    // 메세지 출력
                    System.out.println("입력이 완료되었습니다.");
                    System.out.println();
                    break;

                case 2:
                    // 2번 - 입력된 학생 목록 출력
                    for (int i = 0; i < numOfStd; i++) {
                        System.out.println("[학번: " + (int) stdMatrix[i][0] + "]" +
                                " 국어: " + stdMatrix[i][1] +
                                ", 영어: " + stdMatrix[i][2] +
                                ", 수학: " + stdMatrix[i][3] +
                                ", 합계: " + stdMatrix[i][4] +
                                ", 평균: " + stdMatrix[i][5]);
                    }
                    System.out.println();
                    break;

                case 3:
                    // 3번 - 학생 삭제하기
                    // 인덱스 변수 지정
                    int indexDelNum = -1;
                    boolean goToMenu = false;

                    while (true) {
                        // 학생 목록 출력
                        System.out.println("학생 목록: ");
                        for (int i = 0; i < numOfStd; i++) {
                            System.out.println("[학번: " + (int) stdMatrix[i][0] + "]" +
                                    " 국어: " + stdMatrix[i][1] +
                                    ", 영어: " + stdMatrix[i][2] +
                                    ", 수학: " + stdMatrix[i][3] +
                                    ", 합계: " + stdMatrix[i][4] +
                                    ", 평균: " + stdMatrix[i][5]);

                        }
                        System.out.println();

                        // 지우고 싶은 학번 입력 받기
                        System.out.print("삭제할 학생의 학번을 입력하세요 (-1: 이전 메뉴로): ");
                        float inputNum = sc.nextFloat();

                        // -1이면 이전 메뉴로 돌아가기
                        if (inputNum == -1) {
                            goToMenu = true;
                            break;
                        }

                        // 학번이 몇번째 인덱스에 있는지 확인
                        for (int i = 0; i < numOfStd; i++) {
                            if (stdMatrix[i][0] == inputNum) {
                                // checkNum을 인덱스 번호로
                                indexDelNum = i;
                                break;
                            }
                        }
                        // 학번이 없을 경우
                        if (indexDelNum == -1) {
                            System.out.println("해당 학번이 존재하지 않습니다. 다시 입력해주세요.");
                        }
                        else {
                            break;
                        }
                    }

                    // -1 입력 받았을 경우
                    if (goToMenu) {
                        break;
                    }

                    // 학번 삭제
                    for (int i = indexDelNum; i < numOfStd - 1; i++) {
                        stdMatrix[i] = stdMatrix[i + 1];
                    }

                    // 학생수 -1
                    numOfStd--;

                    // 마지막 새로 할당
                    stdMatrix[numOfStd]= new float[6];

                    System.out.println("삭제가 완료되었습니다.");
                    System.out.println();
                    break;

                case 4:
                    // 4번 - 종료
                    System.out.println("프로그램을 종료합니다.");
                    isExit = false;
                    break;

                default:
                    System.out.println("잘못된 입력 입니다.");
                    System.out.println();
            }
        }
    }
}