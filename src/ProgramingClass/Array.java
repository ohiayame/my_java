package ProgramingClass;

public class Array {
    static float[] getsumAvg(int a, int b, int c){

        float result[] = new float[2];
        result[0] = a + b + c;
        result[1] = result[0] / 3;

        return result;
    }
    public static void main(String[] args) {
        float[] result = getsumAvg(1, 2, 3);
        System.out.println("Sum : " + result[0]);
        System.out.println("Avg : " + result[1]);


        int[][] bar = new int[3][3];

        // Loop: row 0 -> 2
        for(int row = 0, value = 10; row < bar.length; row++, value += 10) {
            // Loop : col 0 -> 2
            for (int col = 0; col < bar[row].length; col++) {
                bar[row][col] = value * (col+1);
                System.out.print(bar[row][col] + " ");
            }
            System.out.println();
        }

        int[][] foo = {{10, 20, 30}, {40 , 50, 60}, {70, 80, 90} };

    }
}
