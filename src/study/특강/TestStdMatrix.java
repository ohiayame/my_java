package study.특강;

import java.util.Scanner;

import static java.lang.System.exit;

public class TestStdMatrix {
    public static void printStdMatrix(float[][] argStdMatrix, int argStdNumber) {
        for(int i = 0 ; i < argStdNumber ; i++) {
            for(int j = 0 ; j < argStdMatrix[i].length ; j++) {
                System.out.print(argStdMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void printStdMatrix(float[][] argStdMatrix, String[] argFieldName, int argStdNumber) {
        for(int i = 0 ; i < argStdNumber ; i++) {
            for(int j = 0 ; j < argStdMatrix[i].length ; j++) {
                System.out.print(argFieldName[j] + ": " + argStdMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void displayMenu() {
        System.out.println("-------------------");
        System.out.println("\tMenu");
        System.out.println("\t1. 학생 성적 입력");
        System.out.println("\t2. 학생 목록 출력");
        System.out.println("\t3. 학생 삭제");
        System.out.println("\t4. 종료");
        System.out.println("-------------------");
        System.out.print("메뉴 선택: ");
    }

    public static boolean createStdRecord(float[][] argStdMatrix, int argStdNumber, Scanner scanner) {

        if(argStdNumber >= argStdMatrix.length) {
            return false;
        }

        System.out.println("\t학생 성적 입력");

        System.out.print("학번을 입력하세요 : ");
        argStdMatrix[argStdNumber][0] = scanner.nextFloat();

        System.out.print("국어 성적을 입력하세요 : ");
        argStdMatrix[argStdNumber][1] = scanner.nextFloat();

        System.out.print("영어 성적을 입력하세요 : ");
        argStdMatrix[argStdNumber][2] = scanner.nextFloat();

        System.out.print("수학 성적을 입력하세요 : ");
        argStdMatrix[argStdNumber][3] = scanner.nextFloat();

        argStdMatrix[argStdNumber][4] = argStdMatrix[argStdNumber][1] + argStdMatrix[argStdNumber][2] + argStdMatrix[argStdNumber][3];
        argStdMatrix[argStdNumber][5] = argStdMatrix[argStdNumber][4] / 3.0f;

        return true;
    }

    public static boolean createStdRecord(float[][] argStdMatrix, String[] argFieldName, int argStdNumber, Scanner scanner) {

        if(argStdNumber >= argStdMatrix.length) {
            return false;
        }
        System.out.println("\t학생 성적 입력");

        for(int i = 0 ; i < argFieldName.length - 2 ; i++) {
            System.out.print(argFieldName[i] + "을 입력하세요 : ");
            argStdMatrix[argStdNumber][i] = scanner.nextFloat();
        }

        argStdMatrix[argStdNumber][4] = argStdMatrix[argStdNumber][1] + argStdMatrix[argStdNumber][2] + argStdMatrix[argStdNumber][3];
        argStdMatrix[argStdNumber][5] = argStdMatrix[argStdNumber][4] / 3.0f;

        return true;
    }

    public static void main(String[] args) {

        final int NUM_OF_STUDENTS = 3;
        final int NUM_OF_FIELDS = 6;
        int inputValue = 0;
        int numOfStd = 0;

        float[][] stdMatrix = new float[NUM_OF_STUDENTS][NUM_OF_FIELDS];
        String[] fieldName = {"학번", "국어", "영어", "수학", "합계", "평균"};

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            inputValue = scanner.nextInt();

            if (!(inputValue >= 1 && inputValue <= 4)) {
                System.out.println("1~4 사이 정수를 입력하세요");
                continue;
            }

            if (inputValue == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // 메뉴 선택
            exit_switch:
            switch (inputValue) {
                // 학생 성적 입력
                case 1:
                    if(createStdRecord(stdMatrix, fieldName, numOfStd, scanner)) {
                        numOfStd++;
                    } else {
                        System.out.println("배열 크기 초과! 배열을 확장하세요");
                    }
                    break;
                // 학생 목록 출력
                case 2:
                    printStdMatrix(stdMatrix, fieldName, numOfStd);
                    break;
                // 학생 삭제
                case 3:
                    // 삭제할 학생의 학번 입력
                    // 예외 처리
                    // -1 메뉴로, 없는 학번 -> 재입력
                    boolean isBack = false;
                    int deleteStdId = -1;
                    while(true) {
                        System.out.print("\t삭제할 학생의 학번을 입력 하세요: ");
                        deleteStdId = scanner.nextInt();

                        // -1
                        if (deleteStdId == -1) {
                            break exit_switch;
                        }

                        if (deleteStdId > 0) {
                            break;
                        }
                        System.out.println("학번을 재입력 하세요");
                    }


                    int indexOfSelectedStd = -1;

                    for(int i = 0 ; i < numOfStd ; i++) {
                        if((int)stdMatrix[i][0] == deleteStdId) {
                            indexOfSelectedStd = i;
                        }
                    }

                    // 수정 필요
//                    if(indexOfSelectedStd == -1) {
//                        // 다시 재입력
//
//                    }

                    for(int i = 0 ; i < numOfStd ; i++) {
                        for(int j = 0 ; j < stdMatrix[i].length ; j++) {}
                    }

                    numOfStd--;
                    break;
                default:
                    System.out.println("Something went wrong");
                    exit(-1);
            }
        }

    }
}
