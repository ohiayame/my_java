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

    // 입력 받은 학번과 동일한 학번이 있는지 검사
    public static int searchIndex(float[][] argStdMatrix, int argStdNumber, int argValue){

        // 해당 학생의 인덱스 값 저장
        //int index = -1;
        for(int i = 0 ; i < argStdNumber ; i++) {
            if((int)argStdMatrix[i][0] == argValue) {

                return i;
//                index = i;
//                break;
            }
        }
        return -1;
    }
//    public static boolean checkOverlap(){
//
//    }

    public static int overlapInput(Scanner sc){
        System.out.print("중복된 입력이 있습니다.\n덮어쓰기를 희망합니까?(Y: 덮어쓰기 진행, q: 메뉴로 돌아가기)");
        char overlapInput = sc.next().charAt(0);
        switch(overlapInput){
            case 'Y':
                return 0;
            case 'q':
                System.out.println("입력이 취소되었습니다. 메뉴로 돌아갑니다.");
                return 1;
            default:
                System.out.println("잘못된 입력입니다.");
                return 2;
        }
    }

    // 학생이 입력이 완료되면  true 반환
    public static boolean createStdRecord(float[][] argStdMatrix, int argStdNumber, Scanner sc) {
        boolean isOverlap = false;
        int stdNumber = -1;
        String[] fieldName = {"학번", "국어", "영어", "수학", "합계", "평균"};

        while(true){
            // 학생 정보 입력 받기
            // argFieldName -> {"학번", "국어", "영어", "수학", "합계", "평균"}
            System.out.print(fieldName[0] + "을 입력하세요 : ");
            stdNumber = sc.nextInt();

            // 동일한 학번이 있는지 검사
            int index = searchIndex(argStdMatrix, argStdNumber, stdNumber);

            // 중복이 없으면(-1) 배열을 생성
            if (index == -1 ){
                // 배열 생성
                argStdMatrix[argStdNumber] = new float[fieldName.length];
                break;
            }
            // 중복이 있으면 저장할 인덱스를 변경 또는 메뉴로 돌아가기
            else{
                int result = overlapInput(sc);
                if (result == 0) {
                    argStdNumber = index;
                    isOverlap = true;
                    break;
                }else if (result == 1) {
                    return false;
                }
            }
        }

        // 학번 저장
        argStdMatrix[argStdNumber][0] = (float)stdNumber;

        // 성적 입력 받고 저장
        for(int i = 1 ; i < fieldName.length - 2 ; i++) {
            System.out.print(fieldName[i] + "성적 : ");
            argStdMatrix[argStdNumber][i] = sc.nextFloat();
        }
        // 합계와 평균은 for문 외에서 계산해서 저장
        argStdMatrix[argStdNumber][4] = argStdMatrix[argStdNumber][1] + argStdMatrix[argStdNumber][2] + argStdMatrix[argStdNumber][3];
        argStdMatrix[argStdNumber][5] = argStdMatrix[argStdNumber][4] / 3.0f;

        // 덮어쓰기면 학생 수 증가 안함
        if(isOverlap) {
            System.out.println("덮어쓰기가 완료되었습니다.");
            return false;
        }else {
            System.out.println("입력이 완료되었습니다.");
            return true;
        }
    }

    // 학생 목록 출력
    public static void printStdMatrix(float[][] argStdMatrix, int argStdNumber) {
        String[] formatFieldName = {"[학번: %.0f]", " 국어: %.1f,", " 영어: %.1f,", " 수학: %.1f,", " 합계: %.1f,", " 평균: %.2f"};

        System.out.println("학생 목록:");
        // 학생 수 만큼 반복
        for(int i = 0 ; i < argStdNumber ; i++) {
            for(int j = 0 ; j < argStdMatrix[i].length ; j++) {
                System.out.printf(formatFieldName[j],argStdMatrix[i][j]);
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

            indexOfSelectedStd = searchIndex(argStdMatrix, argStdNumber, deleteStdId);

            // 동일한 학번을 찾으면 탈출
            if (indexOfSelectedStd != -1) {
                break;
            }
            System.out.println("해당 학번이 존재하지 않습니다. 다시 입력해주세요");
        }
        // 입력 받은 학번의 학생을 지우기
        // 지우는 학생에서 모든 학생의 -1까지 반복
        // -> 다음 학생의 원소를 덮어쓰기
        for(int i = indexOfSelectedStd ; i < argStdNumber-1 ; i++) {
            argStdMatrix[i] = argStdMatrix[i+1];
        }

        // 마지막 학생이 있었던 배열을 초기화
        argStdMatrix[argStdNumber-1] = null;

        return true;
    }

    public static float[][] expansionMatrix(float[][] argStdMatrix) {
        // 현재 배열 크기를 2배로 확장
        float[][] newStdMatrix = new float[argStdMatrix.length * 2][];
        // 복사
        for(int i = 0 ; i < argStdMatrix.length ; i++) {
            newStdMatrix[i] = argStdMatrix[i];
        }

        return newStdMatrix;
    }



    public static void main(String[] args) {
        int students = 3; // 학생 수
        int inputValue = 0;
        int numOfStd = 0;

        float[][] stdMatrix = new float[students][];


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
                    // 확장 (메소드안에서 확장하면 반영 안됨)
                    if(numOfStd >= stdMatrix.length) {
                        stdMatrix = expansionMatrix(stdMatrix);
                        System.out.println("배열이 확장되었습니다. 새로운 크기: " + stdMatrix.length + "행");
                    }
                    // 학생이 입력이 가능하면 true을 반환 -> 총 학생 수를 추가
                    if (createStdRecord(stdMatrix, numOfStd, sc)) {
                        numOfStd++;
                    }
                    break;

                // 학생 목록 출력
                case 2:
                    printStdMatrix(stdMatrix, numOfStd);
                    break;
                // 학생 삭제
                case 3:
                    // -1가 입력 될때 까지 반복
                    while(true) {
                        // 학생정보 출력
                        printStdMatrix(stdMatrix, numOfStd);
                        //deleteStdRecord() -> 삭제 되면 true, 임력이 -1면 false
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
            System.out.println();
        }

    }
}
