package study.특강;

import java.util.Scanner;

import static java.lang.System.exit;

public class TestStdMatrix2 {


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
    // 학생이 입력이 가능하면 true
    public static boolean createStdRecord(float[][] argStdMatrix, String[] argFieldName, int argStdNumber, Scanner sc) {
        // 만약에 학생 수가 배열보다 크면 종료
        if(argStdNumber >= argStdMatrix.length) {
            return false;
        }
        // 학생 정보 입력 받기
        System.out.println("\t학생 성적 입력");
        // argFieldName -> {"학번", "국어", "영어", "수학", "합계", "평균"}
        for(int i = 0 ; i < argFieldName.length - 2 ; i++) {
            System.out.print(argFieldName[i] + "을 입력하세요 : ");
            argStdMatrix[argStdNumber][i] = sc.nextFloat();
        }
        // 합계와 평균은 for문 외에서 계산
        argStdMatrix[argStdNumber][4] = argStdMatrix[argStdNumber][1] + argStdMatrix[argStdNumber][2] + argStdMatrix[argStdNumber][3];
        argStdMatrix[argStdNumber][5] = argStdMatrix[argStdNumber][4] / 3.0f;

        return true;
    }

    // 학생 목록 출력
    public static void printStdMatrix(float[][] argStdMatrix, String[] argFieldName, int argStdNumber) {
        for(int i = 0 ; i < argStdNumber ; i++) {
            for(int j = 0 ; j < argStdMatrix[i].length ; j++) {
                System.out.print(argFieldName[j] + ": " + argStdMatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean deleteStdRecord(float[][] argStdMatrix, int argStdNumber, Scanner sc){
        // 삭제할 학생의 학번 입력
        // 예외 처리
        // -1 메뉴로, 없는 학번 -> 재입력
        int deleteStdId = -1;
        int indexOfSelectedStd = -1;
        while(true) {
            System.out.print("\t삭제할 학생의 학번을 입력 하세요: ");
            deleteStdId = sc.nextInt();

            // -1
            if (deleteStdId == -1) {
                break;
            }else if (deleteStdId > 0) {
                for(int i = 0 ; i < argStdNumber ; i++) {
                    if((int)argStdMatrix[i][0] == deleteStdId) {
                        indexOfSelectedStd = i;
                        break;
                    }
                }
            }
            System.out.println("학번을 재입력 하세요");
        }
        if (deleteStdId == -1) {
            return false;
        }

        for(int i = indexOfSelectedStd ; i < argStdNumber ; i++) {
            for(int j = 0 ; j < argStdMatrix[i].length ; j++) {
                argStdMatrix[i][j] = argStdMatrix[i+1][j];
            }
        }

        for (int j = 0 ; j < argStdMatrix[0].length ; j++) {
            argStdMatrix[argStdMatrix.length-1][j] = 0.0f;
        }
        return true;
    }




    public static void main(String[] args) {
        final int NUM_OF_STUDENTS = 3;
        final int NUM_OF_FIELDS = 6;
        int inputValue = 0;
        int numOfStd = 0;

        float[][] stdMatrix = new float[NUM_OF_STUDENTS][NUM_OF_FIELDS];
        String[] fieldName = {"학번", "국어", "영어", "수학", "합계", "평균"};

        Scanner sc = new Scanner(System.in);

        while (true) {
            // 메뉴 출력
            displayMenu();

            // 입력 받기
            inputValue = sc.nextInt();

            // 1~4 아니면 다시 입력 (continue)
            if (!(inputValue >= 1 && inputValue <= 4)) {
                System.out.println("1~4 사이 정수를 입력하세요");
                continue;
            }
            // 4면 종료
            if (inputValue == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }


            // 1~3 면 해당 메뉴 실행
            // 메뉴 선택
            switch (inputValue) {
                // 학생 성적 입력
                case 1:
                    // 학생이 입력이 가능하면 true을 반환 -> 총 학생 수를 추가
                    if(createStdRecord(stdMatrix, fieldName, numOfStd, sc)) {
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
                    while(true) {
                        if (deleteStdRecord(stdMatrix, numOfStd, sc)) {
                            numOfStd--;
                        } else {
                            System.out.println("배열 크기 초과! 배열을 확장하세요");
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("Something went wrong");
                    exit(-1);
            }
        }

    }
}
