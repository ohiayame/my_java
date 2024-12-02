package study.특강;

import java.util.Scanner;

import static java.lang.System.exit;

public class TestStdMatrix2 {

    // 메뉴 출력
    public static void displayMenu() {
        System.out.println("메뉴");
        System.out.println("1. 학생 성적 입력");
        System.out.println("2. 학생 목록 출력");
        System.out.println("3. 학생 삭제");
        System.out.println("4. 종료");
        System.out.print("선택: ");
    }

    // 학생이 입력이 완료되면  true 반환
    public static boolean createStdRecord(float[][] argStdMatrix, String[] argFieldName, int argStdNumber, Scanner sc) {
        // 만약에 학생 수가 배열보다 크면 종료
        if(argStdNumber >= argStdMatrix.length) {
            return false;
        }
        // 학생 정보 입력 받기
        // argFieldName -> {"학번", "국어", "영어", "수학", "합계", "평균"}
        System.out.print(argFieldName[0] + "을 입력하세요 : ");
        argStdMatrix[argStdNumber][0] = sc.nextFloat();

        for(int i = 1 ; i < argFieldName.length - 2 ; i++) {
            System.out.print(argFieldName[i] + "성적 : ");
            argStdMatrix[argStdNumber][i] = sc.nextFloat();
        }
        // 합계와 평균은 for문 외에서 계산
        argStdMatrix[argStdNumber][4] = argStdMatrix[argStdNumber][1] + argStdMatrix[argStdNumber][2] + argStdMatrix[argStdNumber][3];
        argStdMatrix[argStdNumber][5] = argStdMatrix[argStdNumber][4] / 3.0f;

        return true;
    }

    // 학생 목록 출력
    public static void printStdMatrix(float[][] argStdMatrix, int argStdNumber) {
        String[] argFieldName = {"[학번: %.0f]", " 국어: %.1f,", " 영어: %.1f,", " 수학: %.1f,", " 합계: %.1f,", " 평균: %.2f"};

        System.out.println("학생 목록:");
        // 학생 수 만큼 반복
        for(int i = 0 ; i < argStdNumber ; i++) {
            for(int j = 0 ; j < argStdMatrix[i].length ; j++) {
                System.out.printf(argFieldName[j],argStdMatrix[i][j]);
            }
            System.out.println();
        }
    }

    // 학생 삭제
    public static boolean deleteStdRecord(float[][] argStdMatrix, int argStdNumber, Scanner sc){
        int deleteStdId = -1;
        int indexOfSelectedStd = -1;
        boolean flag = false;
        // 입력
        while(true) {
            System.out.print("삭제할 학생의 학번을 입력 하세요 (-1: 이전 메뉴로): ");
            deleteStdId = sc.nextInt();

            // -1 -> 삭제 프로그램 종료
            if (deleteStdId == -1) {
                return false;
            }
            // 입력 받은 학번과 동일한 학번이 있는지 검사
            // 해당 학생의 인덱스 값 저장
            for(int i = 0 ; i < argStdNumber ; i++) {
                if((int)argStdMatrix[i][0] == deleteStdId) {
                    indexOfSelectedStd = i;
                    flag = true;
                    break;
                }
            }
            // 동일한 학번을 찾으면 탈출
            if (flag) {
                break;
            }
            System.out.println("해당 학번이 존재하지 않습니다. 다시 입력해주세요");
        }
        // 입력 받은 학번의 학생을 지우기
        // 지우는 학생에서 모든 학생의 -1까지 반복
        // -> 다음 학생의 원소를 덮어쓰기
        for(int i = indexOfSelectedStd ; i < argStdNumber-1 ; i++) {
//            System.out.println("test"+ i);
            for(int j = 0 ; j < argStdMatrix[i].length ; j++) {
                argStdMatrix[i][j] = argStdMatrix[i+1][j];
            }
        }
        // 마지막 학생이 있었던 배열을 초기화
        for (int j = 0 ; j < argStdMatrix[0].length ; j++) {
            argStdMatrix[argStdNumber-1][j] = 0.0f;
        }
        return true;
    }


    public static void main(String[] args) {
        final int NUM_OF_STUDENTS = 3; // 학생 수
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
                    printStdMatrix(stdMatrix, numOfStd);
                    break;
                // 학생 삭제
                case 3:
                    while(true) {
                        printStdMatrix(stdMatrix, numOfStd);
                        if (deleteStdRecord(stdMatrix, numOfStd, sc)) {
                            System.out.println("삭제가 완료되었습니다.");
                            numOfStd--;
                        } else {
                            System.out.println("삭제 프로그램 종료");
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
