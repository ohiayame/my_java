package ProgramingClass;

public class IncrementDecrementExample {
    public static void main(String[] args) {
        // 배열 초기화
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int index = 0;

        // 1. 후위 증감 연산자 활용 예: 배열 요소 탐색 (인덱스를 처리할 떄)
        System.out.println("후위 증감 연산자 활영 예:");

        // 배열을 순차적으로 탐색하면서 값을 출력
        while (index < numbers.length) {
            System.out.println("현재 요소 (후위)" + numbers[index++]);  // 출력후 index를 1 증가
        }

        // index 초기화
        index = 0;
        System.out.println("\n전위 증감 연산자 활영 예:");
        while (index < numbers.length) {
            if (++index == 4) {
                System.out.println("4번째 요소에 도달함 (전위)" + numbers[index - 1]);
                break;
            }
        }

        System.out.println("\n증감 연산자와 반복문 예:");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                System.out.println("짝수 요소: " + numbers[i]);
            }
        }
    }
}
