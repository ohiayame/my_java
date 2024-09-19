package ProgramingClass.Lab;

public class Chp2Lab2 {
    public static void main(String[] args) {
        byte maxValue = 127;
        byte minValue = -128;

        maxValue++;
        minValue--;

        System.out.println("오버플로우된 값: " + maxValue);  // 더하기 1을 해버리면 byte의 메모리가 1byte이기 때문에 byte의 최대 값 127 넘어서 -128(최소값)이 출력 된다  -> 오버플로우
        System.out.println("언더플로우된 값: " + minValue);  // 오버플로우의 반대 현상(언더플로우)이 일어난다 -> 출력 값: 127
    }
}
