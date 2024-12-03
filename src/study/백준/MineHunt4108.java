package study.백준;

import java.util.Scanner;

public class MineHunt4108 {

    static int foundMine(int argRow, int argCol, char[][] argMineMatrix) {
        int foundMine = 0;
        for (int i = -1; i <= 1; i++) {
            if (argRow + i >= 0 && argRow + i < argMineMatrix.length ){
                for (int j = -1; j <= 1; j++) {
                    if (argCol + j >= 0 && argCol + j < argMineMatrix[0].length) {
                        if (argMineMatrix[argRow + i][argCol + j] == '*') {
                            foundMine++;
                        }
                    }
                }
            }
        }
        return foundMine;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int inputRow = sc.nextInt();
            int inputCol = sc.nextInt();

            if (inputRow == 0 && inputCol == 0) {
                break;
            }

            sc.nextLine();
            char[][] inputMine = new char[inputRow][inputCol];
            // 지뢰 입력 받기
            for (int i = 0; i < inputRow; i++) {
                String input = sc.nextLine();
                inputMine[i] = input.toCharArray();
            }

            char[][] MineMatrix = new char[inputRow][inputCol];

            // 주변 지뢰 개수 세우기
            // 찾기
            for (int rowValue = 0; rowValue < MineMatrix.length; rowValue++) {
                for (int colValue = 0; colValue < MineMatrix[0].length; colValue++) {
                    if (inputMine[rowValue][colValue] != '*') {
                        int mine = foundMine(rowValue, colValue, inputMine);
                        MineMatrix[rowValue][colValue] = (char) ('0' + mine);
                    } else {
                        MineMatrix[rowValue][colValue] = '*';
                    }
                }
            }

            for (int i = 0; i < inputRow; i++) {
                for (int j = 0; j < inputCol; j++) {
                    System.out.print(MineMatrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
