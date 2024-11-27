package study.특강;

public class Delete1127 {
    // 행렬을 출력하는 메서드
    static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 초기 2차원 배열 설정
        int[][] matrix = {
                {10, 20, 30},
                {40, 50, 60},
                {70, 80, 90},
                {100, 110, 120}
        };

        // 행렬의 행 개수 저장
        int totalRows = matrix.length;

        // 삭제할 행의 인덱스 (현재는 첫 번째 행)
        int rowToRemove = 0;

        // 행 이동: 삭제할 행 이후의 행들을 위로 이동
        for (int i = rowToRemove; i < totalRows - 1; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i + 1][j];
            }
        }

        // 마지막 행을 0으로 초기화
        for (int j = 0; j < matrix[totalRows - 1].length; j++) {
            matrix[totalRows - 1][j] = 0;
        }

        // 수정된 행렬 출력
        displayMatrix(matrix);
    }

}
