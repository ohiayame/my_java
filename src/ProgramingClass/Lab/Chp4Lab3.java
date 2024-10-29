package ProgramingClass.Lab;

import java.util.Scanner;

public class Chp4Lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char grade ; // 성적 등급이
        String level; // 출석 등급

        // 입력
        while (true) {
            System.out.print("학생의 성적 등급을 입력하세요 (A, B, C, D, F): ");
            grade = sc.nextLine().charAt(0); // nextLine()말고 next()로 하면 grade를 입력 했을 때 Enter가 gradeStr에 적용되어버림으로 출셕 등급입력 못하고 "학생의 ~, Poor):잘못된 입력입니다.~" 이래 버림
            System.out.print("학생의 출셕 등급을 입력하세요 (Excellent, Average, Poor):");
            String levelInput = sc.nextLine();


            // 입력받은 알파벳을 대문자로 반환하여 처리 (대소문자의 차: 32)
            grade -= 32;

            char[] levelCharArray = levelInput.toCharArray();  // 입력받은 문자열을 배열로해서 각각의 알파벳에 접근
            for (int i = 0; i < levelCharArray.length; i++) {
                levelCharArray[i] -= 32;
            }
//                System.out.println(charArray);

            // 조건 확인
            if (grade == 'A' || grade == 'B' || grade == 'C' || grade == 'D' || grade == 'F') {
                level = new String(levelCharArray);  // 배열에서 String로 반환
                if (level.equals("EXCELLENT") || level.equals("AVERAGE") || level.equals("POOR")) {
                    break;
                }
            }

            System.out.println("잘못된 입력입니다. 다시 입력하세요.");
        }
        sc.close();

        // 성적 등급과 출석 등급에 따라 msg를 선택
        // 모든 조건이 반환해야 실행됨 지정없는 조건의 결과 -> Unknown
        String msg = switch (grade){
            case 'A'-> {
                if (level.equals("EXCELLENT")) {
                    yield "전액 장학금 및 추가 지원금 지급";
                } else if (level.equals("AVERAGE")) {
                    yield "전액 장학금";
                }
                else{ // ???
                    yield "Unknown";
                }
            }
            case 'B'-> {
                if (level.equals("EXCELLENT")) {
                    yield "반액 장학금";
                }
                else{ // ???
                    yield "Unknown";
                }
            }

            case 'C','D'-> {
                if (level.equals("POOR")) {
                    yield "장학금 없음, 재수강 권장";
                } else {
                    yield "장학금 없음";
                }
            }

            case 'F'-> "장학금 없음, 재수강 권장";
            // ???
            default -> throw new IllegalStateException("Unknown");
        };

        System.out.println(msg);
    }
}
