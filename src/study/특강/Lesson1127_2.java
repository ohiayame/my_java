package study.특강;

import java.util.Scanner;

public class Lesson1127_2 {
    static final int STUDENTS = 3;

    static void printMenu() {
        // 메뉴 출력
        System.out.println("메뉴");
        System.out.println("1. 학생 성적 입력");
        System.out.println("2. 입력된 학생 목록 출력");
        System.out.println("3. 학생 삭제하기");
        System.out.println("4. 종료");
    }

    static int index(float[][] studentsGrade, float InputValue){
        // for) -> studentsGrade
        // 추가하는 학생배열 인덱스를 찾기
        int index = 0;
        for (int i = 0; i < studentsGrade.length; i++) {
            // 만약 배열이 없으면 (= null) 배열을 초기화해 입력 받기
            if (studentsGrade[i][0] == 0) {
                index = i;
                break;
            }else if(studentsGrade[i][0] == InputValue){
                index = i;
                break;
            }
        }
        return index;
    }
    static float[][] inputGrade(Scanner sc, float[][] studentsGrade){
        // 합계변수 초기화
        float sumGrade = 0.0f;
        String[] inputMsg = {"학번을 입력하세요: ", "국어 성적: ", "영어 성적: ", "수학 성적: "};
        int index = 0;

        // for) studentsGrade[i]
        // 3 까지 입력 받기
        for (int i = 0; i < inputMsg.length; i++) {
            // 열: [학번, 국어, 영어, 수학, (합계, 평균)]
            // 입력 받기
            System.out.print(inputMsg[i]);
            float InputValue = sc.nextFloat();

            // 몇번째 배열에 저장하는지 정하기
            if (i == 0) {
                index = index(studentsGrade, InputValue);
            }else {
                // 점수 더하기
                sumGrade += InputValue;
            }
        }

        // studentsGrade[i][4]
        // 합계 -> studentsGrade[i][1] + studentsGrade[i][2] + studentsGrade[i][3]
        studentsGrade[index][inputMsg.length] = sumGrade;

        // studentsGrade[i][5]
        // 평균 -> studentsGrade[i][4] // 3
        studentsGrade[index][inputMsg.length + 1] = sumGrade / STUDENTS;

        System.out.println("입력이 완료되었습니다.");
        return studentsGrade;

    }

    static void outputGrade(float[][] studentsGrade) {
        // 2. 입력된 학생 목록 출력
        String[] outputMsg = {"[학번: %.0f]", " 국어: %.1f,", " 영어: %.1f,", " 수학: %.1f,", " 합계: %.1f,", " 평균: %.2f"};
        // for) studentsGrade
        for (int i = 0; i < studentsGrade.length; i++) {
            // 만약 학번이 0 이고
            if (studentsGrade[i][0] == 0) {
                // 학생배열이 첫번째 배열인 경우 출력
                if (i == 0) {
                    //  출력
                    System.out.println("입력된 학생 정보가 없습니다.");
                }
                // brake
                break;
            } else {
                // 아니면 출력
                if (i == 0) {
                    System.out.println("학생 목록: ");
                }
                // 출력 : [학번] 국어: xx, 영어: xx, 수학: xx, 합계: xx, 평균: xx.xx
                for (int j = 0; j < studentsGrade[i].length; j++) {
                    System.out.printf(outputMsg[j], studentsGrade[i][j]);
                }
                System.out.println();
            }
        }
    }

    static float[][] delete(Scanner sc, float[][] studentsGrade, int studentInfomation) {
        // 3. 학생 삭제하기
        while (true) {
            int deleteIndex = -1;
            boolean flag = false;
            //while) 삭제할 학생의 학번을 입력받음
            while (true) {
                // 2 실행 -> 목록을 출력
                outputGrade(studentsGrade);
                //입력 받기
                System.out.print("삭제할 학생의 학번을 입력하세요(-1: 이전 메뉴로): ");
                float inputDelete = sc.nextFloat();
                // 삭제 탈출
                if (inputDelete == -1) {
                    // 입력 값이 -1 면
                    flag = true;
                    break;
                }

                // 삭제할 인덱스 찾기
                // for) studentsGrade
                for (int i = 0; i < studentsGrade.length; i++) {
                    // 있으면 studentsGrade[i][0] != 0 && studentsGrade[i][0] == 입력 값
                    if (studentsGrade[i][0] != 0 && studentsGrade[i][0] == inputDelete) {
                        deleteIndex = i;
                        break;
                    }
                }

                if (deleteIndex == -1) {
                    // 없으면 다시 입력
                    System.out.println("해당 학번이 존재하지 않습니다. 다시 입력해주세요.");
                } else {
                    break;
                }
            }
            if (flag) {
                break;
            }


            // for ) deleteIndex + i < studentsGrade.length
            for (int i = deleteIndex; i < studentsGrade.length - 1; i++) {
                studentsGrade[i] = studentsGrade[i + 1];

            }
            // 삭제 (초기화)
            // -> studentsGrade[deleteIndex] = null
            studentsGrade[studentsGrade.length-1] = new float[studentInfomation] ;

            System.out.println("삭제가 완료되었습니다");
        }
        return studentsGrade;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputMenu = 0;
        boolean flag = false;
        int studentInfomation = 6;

        float[][] studentsGrade = new float[STUDENTS][studentInfomation];

        while (true) {
            // 1) 메뉴 입력 받기
            printMenu();
            while (true) {
                System.out.print("선택: ");
                inputMenu = sc.nextInt();
                if (inputMenu >= 1 && inputMenu <= 4) {
                    break;
                }
                // 만약 1~4 이외면 재입력
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }

            // 2) switch
            switch (inputMenu) {
                case 1:
                    studentsGrade = inputGrade(sc, studentsGrade);
                    System.out.println();
                    break;
                case 2:
                    outputGrade(studentsGrade);
                    break;
                case 3:
                    studentsGrade = delete(sc, studentsGrade,studentInfomation);
                    System.out.println();
                    break;
                case 4:
                    flag = true;
                    break;
            }
            if (flag){
                break;
            }

        }
        System.out.println("프로그램 종료");

    }
}

