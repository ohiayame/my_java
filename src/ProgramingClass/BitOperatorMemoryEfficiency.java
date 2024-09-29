package ProgramingClass;

public class BitOperatorMemoryEfficiency {
    public static void main(String[] args) {
        // 8가지 플래그(읽기, 쓰기, 실행 등)를 각각 1비트로 저장해,
        // 1바이트(8비트) 안에 모든 플래그를 저장 가능

        byte READ = 1;  // 00000001
        byte WRITE = 0b00000010; // 2, 접두사 표기 사용 예
        byte EXECUTE = 4; // 00000100
        byte DELETE = 0B00001000;  // 8, 접두사 표기 사용 예

        // 읽기와 쓰기 권한 설정 (00000011)
        byte permissions = (byte) (READ | WRITE);

        // 권한이 있는지 확인 (읽기 권한 확인)
        boolean canRead = (permissions & READ) != 0;  // 00000011 & 00000001 = 00000001
        System.out.println("canRead: " + canRead);  // true

        // 실행 권한이 있는지 확인
        boolean canExecute = (permissions & EXECUTE) != 0;  // 00000011 & 00000100 = 00000000
        System.out.println("canExecute: " + canExecute);  // false
    }
}
