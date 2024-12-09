package study.특강;

import java.util.Scanner;

public class ExamMatrix {
    static void printMenu(){
        System.out.println("===== 빙고 게임 메뉴 =====");
        System.out.println("1. 빙고판 생성");
        System.out.println("2. 숫자별 발생 빈도 분석");
        System.out.println("3. 빙고판 출력");
        System.out.print("메뉴 선택: ");
    }


    // 1)
    // 빙고 크기 입력
    static int inputBingoSize(Scanner sc){
        int size = 0;
        while(true){
            System.out.print("빙고 메트릭스의 N값을 입력하세요 (3이상 9이하 홀수): ");
            size = sc.nextInt();
            if (size >= 3 && size <= 9 && size % 3 == 0){
                return size;
            }
            System.out.println("N 값은 3이상 9이하 홀수만 입력 가능합니다.");
        }
    }

    // 렌덤 숫자 범위 입력
    static int[] inputRandomRange(Scanner sc, int argBingoSize){
        int[] range = new int[2];
        while (true){
            System.out.print("난수 범위의 시작 값을 입력하세요: ");
            range[0] = sc.nextInt();
            System.out.print("난수 범위의 종료 값을 입력하세요: ");
            range[1] = sc.nextInt();
            if ((range[1] - range[0]+1) >= argBingoSize){
                return range;
            }
            System.out.println("종료 값 - 시작 값이 N x N 보다 크거나 같아야 합니다.");
        }
    }
    // 빙고의 수 입력
    static int inputBingoNum(Scanner sc){
        int num = 0;
        while(true){
            System.out.print("작성할 빙고 메트릭스 수 M을 입력하세요: ");
            num = sc.nextInt();
            if (num >= 1 && num <= 7){
                return num;
            }
            System.out.println("M 값은 1이상 7이하 양수만 입력 가능합니다.");
        }
    }
    // 중복 확인
    static boolean isOverlap(int[][] argMatrix, int argValue){
        for (int row = 0; row < argMatrix.length; row++){
            for (int col = 0; col < argMatrix[row].length; col++){
                // 중복 있으면
                if (argValue != 0 && argMatrix[row][col] == argValue){
                    return true;
                }
            }
        }
        return false;
    }
    // random 숫자 선택
    static int randomNum(int[][] argMatrix, int[]argRandomRange){
        while (true) {
            // 10~20 -> 10과 20도 포함
            int randomNum = argRandomRange[0] + (int) (Math.random() * (argRandomRange[1] - argRandomRange[0] + 1));
            // 중복확인
            if (!isOverlap(argMatrix, randomNum)) {
                return randomNum;
            }
        }
    }
    // 빙고 세트
    static void setBingo(int[][][] argTensor, int[] argRandomRange){
        for (int matrix = 0; matrix < argTensor.length; matrix++){
            for (int row = 0; row < argTensor[matrix].length; row++){
                for (int col = 0; col < argTensor[matrix][row].length; col++){
                    // random 숫자 대입
                    argTensor[matrix][row][col] = randomNum(argTensor[matrix], argRandomRange);
                }
            }
        }
    }

    // 2)
    // 빈도 출력
    static void printValueFrequency(float[][] valueFrequency){
        //출력
        System.out.println("===== 숫자별 발생 빈도 =====");

        for (int i = 0; i < valueFrequency.length; i++){
            System.out.printf("%.0f: %.0f회 (%.2f%%) ", valueFrequency[i][0], valueFrequency[i][1], valueFrequency[i][2]);
            // 10단위
            for(int j = 0; j <= valueFrequency[i][2]/10; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 빈도 계산
    static float[][] ValueFrequency(int[][][] argTensor, int[] argRandomRange){
        float[][] valueFrequency = new float[argRandomRange[1]+1 - argRandomRange[0]][3];
        // valueFrequency = [[수, 회수, 확률], [수, 회수, 확률], ...]

        // 첫번째 원소에 숫자를 대입
        // 첫번째로 저장된 숫자가 몇개 있는지 검사
        for (int i = 0, value = argRandomRange[0]; i < valueFrequency.length; i++, value++) {
            valueFrequency[i][0] = value;
            for (int j = 0; j < argTensor.length; j++) {
                if (isOverlap(argTensor[j], (int) valueFrequency[i][0])) {
                    valueFrequency[i][1]++;
                }
            }
        }
        // 빈도 확률
        float num = argTensor.length * argTensor[0].length * argTensor[0].length;
        for (int i = 0; i < valueFrequency.length; i++) {
            valueFrequency[i][2] = valueFrequency[i][1] / num * 100f;
        }

        return valueFrequency;
    }



    // 3)
    // 출력
    static void printBingo(int[][][] argTensor){
        for (int matrix = 0; matrix < argTensor.length; matrix++){
            System.out.println();
            System.out.println("빙고 메트릭스 #" + (matrix + 1));
            for (int row = 0; row < argTensor[matrix].length; row++){
                for (int col = 0; col < argTensor[matrix][row].length; col++){
                    System.out.print(" " + argTensor[matrix][row][col]);
                }
                System.out.println();
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][][] bingoMatrix = null;
        int[] randomRange = null;
        while (true) {
            // 메뉴 출력
            printMenu();
            // 메뉴 입력 받기
            int inputMenu = sc.nextInt();

            // 1~4 아니면 다시 입력 (continue)
            if (!(inputMenu >= 1 && inputMenu <= 4)) {
                System.out.println("1~4 사이 정수를 입력하세요");
                continue;
            }
            // 4면 종료
            if (inputMenu == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }


            switch (inputMenu) {
                // 1)
                case 1:
                    // 1. 빙고 크기 입력
                    int bingSize = inputBingoSize(sc);

                    // 2. 난수 범위 입력 받기
                    randomRange = inputRandomRange(sc, bingSize*bingSize);
                    // 3. 빙고의 메트릭스 수 입력 받기
                    int bingoNum = inputBingoNum(sc);

                    // 4. 난수 생성 -> 배열에 대입
                    bingoMatrix = new int[bingoNum][bingSize][bingSize];
                    setBingo(bingoMatrix, randomRange);

                    System.out.println("빙고 메트릭스가 생성되었습니다.");
                    break;
                // 2)
                case 2:
                // 난수 범위을 기준으로 생성한 빙고판의 숫자의 개수를 세워서
                // 각 숫자의 발생 빈도를 분석해 출력
                    if (bingoMatrix != null) {
                        // 빈도 계산
                        float[][] valueFrequency = ValueFrequency(bingoMatrix, randomRange);
                        printValueFrequency(valueFrequency);
                    }else{
                        System.out.println("생성된 빙고가 없습니다.");
                    }
                    break;
                // 3)
                case 3:
                // 빙고판 출력
                    if (bingoMatrix != null) {
                        printBingo(bingoMatrix);
                    }else{
                        System.out.println("생성된 빙고가 없습니다.");
                    }
                    break;


                default:
                    System.out.println("Error");

            }
            System.out.println();
        }

    }
}
