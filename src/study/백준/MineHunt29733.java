package study.백준;

import java.util.Scanner;

public class MineHunt29733 {
    static int foundMine(int argHeight, int argRow, int argCol, char[][][] argMineMatrix) {
        int foundMine = 0;
        // Height
        for (int h = -1; h <= 1; h++) {
            if (argHeight + h >= 0 && argHeight + h < argMineMatrix.length) {
                // Row
                for (int r = -1; r <= 1; r++) {
                    if (argRow + r >= 0 && argRow + r < argMineMatrix[0].length) {
                        // Col
                        for (int c = -1; c <= 1; c++) {
                            if (argCol + c >= 0 && argCol + c < argMineMatrix[0][0].length) {
                                // * 면 추가
                                if (argMineMatrix[argHeight + h][argRow + r][argCol + c] == '*') {
                                    foundMine++;
                                }
                            }
                        }
                    }
                }
            }
        }
        // 10으로 나눈 나머지
        return foundMine;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputRow = sc.nextInt();
        int inputCol = sc.nextInt();
        int inputHeight = sc.nextInt();

        sc.nextLine();
        char[][][] inputMine = new char[inputHeight][inputRow][inputCol];
        // 지뢰 입력 받기
        for (int h = 0; h < inputHeight; h++) {
            for (int r = 0; r < inputRow; r++) {
                String input = sc.nextLine();
                inputMine[h][r] = input.toCharArray();
            }
        }

        // 주변 지뢰 개수 세우기
        // 찾기
        for (int heightValue = 0; heightValue < inputMine.length; heightValue++){
            for (int rowValue = 0; rowValue < inputMine[0].length; rowValue++) {
                for (int colValue = 0; colValue < inputMine[0][0].length; colValue++) {
                    // 지뢰 아니면 세우기
                    if (inputMine[heightValue][rowValue][colValue] != '*') {

                        System.out.print( foundMine(heightValue, rowValue, colValue, inputMine) % 10);

                    } else {
                        System.out.print('*');
                    }
                }
                System.out.println();
            }
        }
    }
}
