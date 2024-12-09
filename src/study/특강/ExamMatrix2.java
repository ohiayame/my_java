package study.특강;
import java.util.Scanner;
public class ExamMatrix2 {



    // 메뉴 출력
    static void printMenu() {
        System.out.println("===== 빙고 게임 메뉴 =====");
        System.out.println("1. 빙고판 생성");
        System.out.println("2. 숫자별 발생 빈도 분석");
        System.out.println("3. 빙고판 출력");
        System.out.println("4. 종료");
        System.out.print("메뉴 선택: ");
    }
    static int inputMatrixSize(Scanner sc) {
        while(true) {
            //입력 받기
            System.out.print("빙고 메트릭스의 N 값을 입력하세요 (3 이상 9 이하 홀수): ");
            int size = sc.nextInt();

            // 3 이상 9 이하 정수 중 홀수
            if(size >= 3 && size <= 9 && size % 3 == 0) {
                return size;
            }
            System.out.println("N 값은 3 이상 9 이하 정수 중 홀수 값만 입력 가능합니다.");
        }
    }
    // random 값의 범위 입력 받기
    static int[] inputRange(Scanner sc, int argBingoSize) {
        int[] range = new int[2];
        // 입력 받기
        while(true) {
            System.out.print("난수 범위의 시작값을 입력 하세요: ");
            range[0] = sc.nextInt();
            System.out.print("난수 범위의 종료값을 입력 하세요: ");
            range[1] = sc.nextInt();

            // 종료 값 - 시작 값 +1 >= N*N
            if ((range[1] - range[0] + 1) >= argBingoSize* argBingoSize) {
                return range;
            }
            System.out.println("종료 값 - 시작 값이 N x N 보다 크거나 같아야 합니다.");
        }
    }
    static int inputMatrixNum(Scanner sc) {
        while(true) {
            //입력 받기
            System.out.print("작성할 빙고 매트릭스 수 M을 입력하세요 (1 이상 7 이하): ");
            int num = sc.nextInt();

            // 1 이상 7 이하
            if(num >= 1 && num <= 7) {
                return num;
            }
            System.out.println("M 값은 1 이상 7 이하 양수만 입력 가능합니다.");
        }
    }

    // 중복이 있으면 true
    static boolean overLap(int[][] argMatrix, int value) {
        for (int row = 0; row < argMatrix.length; row++) {
            for (int col = 0; col < argMatrix[0].length; col++) {
                if (argMatrix[row][col] == value) {
                    return true;
                }else if (argMatrix[row][col] == 0) {
                    return false;
                }
            }
        }
    }
    // 랜덤 값을 생성해 overLap()로 중복이 없는지 확인후 없으면 반환
    static int createRandom(int[][] argMatrix, int[] argRange) {
        int random = 0;
        while(true) {
            random = argRange[0] + (int) (Math.random() * (argRange[1] - argRange[0] + 1));
            if (! overLap(argMatrix, random )) {
                return random;
            }
        }
    }


    static void printNumCount(int[][][] bingoBords, int argNum, int argCount) {
        // 백분율
        float parcent = (float)argCount / (float)(bingoBords.length *  bingoBords[0].length *bingoBords[0].length) * 100.0f;
        // 출력
        System.out.printf("%d: %d회 (%.2f%%) ",argNum, argCount, parcent);
        // * 출력
        for (int star = 0; star < parcent /10; star++) {
            System.out.print("*");
        }
    }


    static void numCount(int[][][] bingoBords, int[] argRange) {
        // 범위의 수 반복
        System.out.println("===== 숫자별 발생 빈도 =====");
        for(int num = argRange[0]; num <= argRange[1]; num++) {
            int count = 0;
            for (int matrix = 0; matrix < bingoBords.length; matrix++) {
                // 중복이 있으며 count
                if (overLap(bingoBords[matrix], num)){
                    count ++;
                }
            }
            printNumCount(bingoBords, num, count);
            System.out.println();
        }

    }


    // 빙고판 출력
    static void printBingo(int[][][] bingoBoards) {
        for (int i = 0; i < bingoBoards.length; i++) {
            System.out.println("\n빙고 메트릭스 #" + (i + 1));
            for (int[] row : bingoBoards[i]) {
                for (int cell : row) {
                    System.out.printf("%3d", cell);
                }
                System.out.println();
            }
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 배열, random 값 범위저장 배열 초기화
        int[][][] bingoTensor = null;
        int[] numRange = new int[2];

        while(true) {
            // 메뉴 출력
            printMenu();

            // 입력 받기
            int inputMenu = sc.nextInt();

            // 1~4 이외 continue
            if (inputMenu < 1 || inputMenu > 4) {
                System.out.println("1~4만 입력 가능합니다.");
                continue;
            }else if ( inputMenu == 4) {
                // 4 : 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            // switch
            switch(inputMenu) {
                // 1. 빙고판 생성
                case 1	:
                    // matrix 크기 입력 받기
                    int matrixSize = inputMatrixSize(sc);

                    // random 값의 범위 입력 받기
                    numRange = inputRange(sc, matrixSize);

                    // matrix 개수를 입력 받기
                    int matrixNum = inputMatrixNum(sc);

                    // 빙고판 생성
                    bingoTensor = new int[matrixNum][matrixSize][matrixSize];

                    // 한 matrix 씩 중복하지 않은 빙고판 생성
                    for(int matrix = 0; matrix < bingoTensor.length; matrix++) {
                        for (int row = 0; row < bingoTensor[0].length; row++) {
                            for (int col = 0; col < bingoTensor[0][0].length; col++) {
                                // random 값을 대입
                                bingoTensor[matrix][row][col] = createRandom(bingoTensor[matrix], numRange);
                            }
                        }
                    }
                    System.out.println("빙고 메트릭스가 생성외었습니다.");
                    break;

                // 2. 숫자별 발생 빈도 분석
                case 2:
                    if (bingoTensor != null) {
                        numCount(bingoTensor, numRange);
                    }else {
                        System.out.println("빙고판이 없습니다.");
                    }
                    break;

                // 3. 빙고판 출력
                case 3:
                    if (bingoTensor != null) {
                        printBingo(bingoTensor);
                    }else {
                        System.out.println("빙고판이 없습니다.");
                    }
                    break;

                default:
                    System.out.println("Error");
                    break;
            }
            System.out.println();
        }
    }

}