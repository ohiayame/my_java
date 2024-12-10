package ProgramingClass.exam;




import java.util.Iterator;
import java.util.Scanner;

public class Test241210 {
    static void printMenu(int argNumOfMetrix) {
        System.out.println("===== 메뉴 =====");
        System.out.println("현재 메트릭스 수: " + argNumOfMetrix);
        System.out.println("1. 매트릭스 생성");
        System.out.println("2. 생성된 매트릭스 출력");
        System.out.println("3. 2차원 배열로 변환 후 출력");
        System.out.println("4. 매트릭스 삭제");
        System.out.println("5. 종료");
        System.out.print("메뉴 선택:");
    }

    // 매트릭스 생성
    static int[][] createMatrix(Scanner sc, int argId) {
        int row = 0, col = 0;
        // row, col 입력 받기
        while(true) {
            System.out.print("메트릭승의 행(row) 수를 입력하세요(1~10): ");
            row = sc.nextInt();
            System.out.print("메트릭승의 열(col) 수를 입력하세요(1~10): ");
            col = sc.nextInt();
            // 1~10 이외면 재 입력
            if(row >=1 && row <= 10  &&  col >=1 && col <= 10) {
                break;
            }
            System.out.println("다시 입력하세요(1~10)");
        }
        // 매트릭스 생성
        int[][] matrix = new int[row][col];

        // 배열 반복 원소 대입
        int tempLen = matrix.length * matrix[0].length;
        // 첫번째 : id 저장(idCount)
        matrix[0][0] = argId;
        for  (int i = 1; i < tempLen; i++) {
            matrix[i / matrix[0].length][i % matrix[0].length] =  (argId * 10) + i;
        }


        return matrix;
    }

    static int[][][] sizeUp(int[][][] argTensor) {
        int oldSize = argTensor.length;
        // 2배로 확장
        int[][][] newTensor = new int[oldSize * 2][][];

        // 복사
        for (int i = 0; i < argTensor.length; i++) {
            newTensor[i] = argTensor[i];
        }
        return newTensor;
    }

    // 출력
    // Matrix
    static void printMatrix(int[][][] argTensor, int argNumOfMetrix) {
        for (int i = 0 ; i < argNumOfMetrix; i ++) {
            System.out.printf("\n매트릭스 (ID: %d): \n", argTensor[i][0][0]);
            for (int row = 0; row < argTensor[i].length; row++) {
                for (int col = 0; col < argTensor[i][row].length; col++) {
                    System.out.printf("%3d", argTensor[i][row][col]);
                }
                System.out.println();
            }
        }
    }
    // Temp
    static void printTemp(int[][] temp) {
        for (int row = 0; row < temp.length; row++) {
            for (int col = 0; col < temp[row].length; col++) {
                System.out.printf("%3d", temp[row][col]);
            }
            System.out.println();
        }
    }

    // 2차원배열로 변환
    static int[][] resetTemp(int[][][] argTensor, int argNumOfMetrix) {
        //  2차원 배열의 크기 검사
        int tempRow = 0;
        for (int i = 0; i < argNumOfMetrix; i++) {
            tempRow += argTensor[i].length;
        }
        // 2차원 배열 생성
        int[][] temp = new int[tempRow][];
        // 복사
        for (int i = 0,tRow = 0; i < argNumOfMetrix; i++) {
            for (int row = 0; row < argTensor[i].length; row++, tRow++) {
                temp[tRow] = argTensor[i][row];
            }
        }
        return temp;
    }

    // 삭제
    static void deleteMatrix(Scanner sc, int[][][] argTensor, int argNumOfMetrix) {
        // 출력
        System.out.println("\n현재 생성된 매트릭스 목록:");
        for (int i = 0 ; i < argNumOfMetrix; i ++) {
            System.out.printf("▶ 매트릭스 ID: %d, 행(row): %d, 열(col): %d, 총 원소 개수: %d\n",
                    argTensor[i][0][0],  argTensor[i].length, argTensor[i][0].length, argTensor[i].length* argTensor[i][0].length);
        }

        int deleteId = 0;
        int deleteIndex = -1;
        while(true) {
            // 삭제하는 ID 입력 받기
            System.out.print("\n삭제할 매트릭스의 ID를 입력하세요: ");
            deleteId = sc.nextInt();
            // 없으면 재입력
            // 해당 매트릭스를 삭제
            for (int i = 0 ; i < argNumOfMetrix; i ++) {
                if (deleteId == argTensor[i][0][0]) {
                    // 삭제하는 인덱스 값을 저장
                    deleteIndex = i;
                }
            }
            // id가 있으면 탈출
            if(deleteIndex != -1) {
                break;
            }
            System.out.println("잘못된 매트릭스의 ID입니다. 다시 입력하세요.");
        }

        // 옮기기
        for (int i = deleteIndex ; i < argNumOfMetrix-1; i ++) {
            argTensor[i] = argTensor[i+1];
        }
        System.out.printf("매트릭스(ID: %d)가 삭제되었습니다.\n", deleteId);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 3차원 배열 생성 (초기 크기 2
        int tensorLength = 2;  // 3차원 크기
        int[][][] tensor = new int[tensorLength][][]; // 3차원 배열
        int numOfMetrix = 0; // 저장된 매트릭스 수
        int idCount = 0; // 최종 id를 저장
        int inputMenu = 0;

        while(true) {
            // 메뉴 출력
            printMenu(numOfMetrix);

            // 메뉴 입력 받기
            while(true) {
                inputMenu = sc.nextInt();
                // 1~5 이외 재입력
                if (inputMenu >= 1 && inputMenu <= 5) {
                    break;
                }
                System.out.println("메뉴 값은 1~5 사이 정수를 입력하세요!");
            }

            // 5 : break
            if(inputMenu == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // switch
            switch(inputMenu) {
                // 1: 메트릭스 생성
                case 1:
                    idCount++;
                    // 크기 검사
                    if (numOfMetrix >=  tensor.length) {
                        // 확장
                        tensor = sizeUp(tensor);
                        System.out.printf("메트릭스 배열의 크기를 %d에서 %d(으)로 확장합니다.\n", numOfMetrix, tensor.length);
                    }
                    // 메트릭스 생성
                    tensor[numOfMetrix] = createMatrix(sc, idCount);
                    numOfMetrix++;
                    System.out.printf("메트릭스(ID: %d) 가 생성되었습니다.\n", idCount);
                    break;

                // 2: 메트릭스 출력
                case 2:
                    if (numOfMetrix >= 0) {
                        printMatrix(tensor, numOfMetrix);
                    }else {
                        System.out.println("저장된 메트릭스가 없습니다.");
                    }
                    break;

                // 3: 2차원 배열로 변환
                case 3:
                    if (numOfMetrix >= 0) {
                        int[][] temp = resetTemp(tensor, numOfMetrix);
                        System.out.println("\n2차원 배열로 변환된 매트릭스:");
                        printTemp(temp);
                    }else {
                        System.out.println("저장된 메트릭스가 없습니다.");
                    }
                    break;

                // 4 메트릭스 삭제
                case 4:
                    if (numOfMetrix >= 0) {
                        deleteMatrix(sc, tensor, numOfMetrix);
                        numOfMetrix--;
                    }else {
                        System.out.println("저장된 메트릭스가 없습니다.");
                    }
                    break;

                default:
                    System.out.println("Error.");
                    break;
            }
            System.out.println();
        }
    }
}