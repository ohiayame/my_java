package ProgramingClass;

public class BitOperationPowCalPer {
    public static void main(String[] args) {
        // 반복 횟수 (계산을 충분히 많이 해서 시간을 측정)
        int iterations = 100000000;

        // * 연산자 사용 (곱셈 연산)
        long startTimeMultiplication = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            int result = 10 * (int) Math.pow(2, 2);  // 10 * 2^2
        }
        long endTimeMultiplication = System.nanoTime();
        long timeTakenMultiplication = endTimeMultiplication - startTimeMultiplication;

        // << 연산자 사용 (비트 시프트 연산)
        long startTimeShift = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            int result = 10 << 2;  // 10 * 2^2은 10 << 2와 동일
        }
        long endTimeShift = System.nanoTime();
        long timeTakenShift = endTimeShift - startTimeShift;

        // 결과 출력
        System.out.println("Time taken using * operator: " + timeTakenMultiplication + " ns");
        System.out.println("Time taken using << operator: " + timeTakenShift + " ns");
    }
}
