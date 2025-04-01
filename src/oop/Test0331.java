package oop;


import java.util.Scanner;

class Foo {}
// 변수
// 1) 멤버변수
//    A. 인스턴스 멤버 변수
//    B. 클래스 멤버 변수
// 2) 지역변수 -> 메서드 내 선언된 변수

class Student {
    // ID, 이름, 국어, 영어, 수학, 합계점수, 평균
    int id;
    String name;
    private int scoreKorean;
    private int scoreEnglish;
    private int scoreMath;
    private int sum;
    private float avg;

    Student() {
        id = 0;
        name = "Guest";
    }

    Student(int argId, String argName) {
        id = argId;
        name = argName;
    }

    boolean setScore(int argKorean, int argEnglish, int argMath) {
        if(argKorean < 0 || argEnglish < 0 || argMath < 0) {
            return false;
        }

        if(argKorean > 100 || argEnglish > 100 || argMath > 100) {
            return false;
        }

        scoreKorean = argKorean;
        scoreEnglish = argEnglish;
        scoreMath = argMath;

        return true;
    }


    int getScoreKorean() {
        return scoreKorean;
    }

    int getScoreEnglish() {
        return scoreEnglish;
    }

    public int getScoreMath() {
        return scoreMath;
    }

    int getSum() {
        sum = scoreKorean + scoreEnglish + scoreMath;
        return sum;
    }

    float getAvg() {
        avg = (float)sum / 3;
        return avg;
    }
}

class StdScoreMgr{
    Student[] stdList;
    int numOfStudents;

    StdScoreMgr(int argNumOfStudents){
        stdList = new Student[argNumOfStudents];
        numOfStudents = argNumOfStudents;
    }

    void addStudent() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numOfStudents; i++) {

            System.out.println("ID 입력 : ");
            int stdId = sc.nextInt();

            System.out.println("이름 입력 : ");
            String stdName = sc.next();

            Student student = new Student(stdId, stdName);

            System.out.println("국어 성적 입력 : ");
            int scoreKorean = sc.nextInt();

            System.out.println("영어 성적 입력 : ");
            int scoreEnglish = sc.nextInt();

            System.out.println("수학 성적 입력 : ");
            int scoreMath = sc.nextInt();

            if (student.setScore(scoreKorean, scoreEnglish, scoreMath)) {
                stdList[i] = student;
            }
        }
    }

    Student getStd(Scanner sc) {
        System.out.println("조회할 학번을 입력해주세요: ");
        int stdId = sc.nextInt();
        for (Student std : stdList) {
            if (std.id == stdId) {
                return std;
            }
        }
        return null;
    }
}

class Prt {
    void prtStudent(Student std) {
        System.out.printf("학번: %d\n", std.id);
        System.out.printf("이름: %s\n", std.name);
    }
    void prtAllStd(Student[] stdList) {
        for (Student std : stdList) {
            System.out.printf("학번: %d, 이름: %s\n", std.id, std.name);
        }
    }
    void prtScores(Student std) {
        System.out.printf("국어 성적: %d\n", std.getScoreKorean());
        System.out.printf("영어 성적: %d\n", std.getScoreEnglish());
        System.out.printf("수학 성적: %d\n", std.getScoreMath());
    }
    void prtSum(Student std) {
        System.out.printf("성적 함계: %d", std.getSum());
    }
    void prtAvg(Student std) {
        System.out.printf("성적 평균: %f", std.getAvg());
    }
    void prtScore(Student std, int i) {
        if (i == 1){
            System.out.printf("국어 성적: %d\n", std.getScoreKorean());
        }else if (i == 2){
            System.out.printf("영어 성적: %d\n", std.getScoreEnglish());
        }else {
            System.out.printf("수학 성적: %d\n", std.getScoreMath());
        }
    }
}





public class Test0331 {

    static void menu() {
        System.out.println("\n--------menu---------");
        System.out.println("1. 학생 새로 등록");
        System.out.println("2. 학생 정보 조회");
        System.out.println("3. 성적 조회");
        System.out.println("4. 프로그램 종료");
    }
    static void ScoreMenu() {
        System.out.println("\n--------menuScore--------");
        System.out.println("1. 모든 성적");
        System.out.println("2. 특정 성적");
        System.out.println("3. 3과목 합계");
        System.out.println("4. 3과목 평균");
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println(" 학생 성적 관리 시스템 ");

        Prt prt = new Prt();
        StdScoreMgr stdMgr = null;

        boolean isRun = true;

         while (isRun) {
             menu();
             System.out.println("메뉴를 입력해주세요: ");
             int menuId = sc.nextInt();
             if (1 > menuId || menuId > 4) {
                continue;
             }
             if (menuId != 1 && stdMgr == null){
                 System.out.println("학생정보를 등록해주세요");
                 continue;
             }
             switch (menuId) {
                 case 1:
                     System.out.println("입력 학생 수: ");
                     int stdNum = sc.nextInt();

                     stdMgr = new StdScoreMgr(stdNum);
                     stdMgr.addStudent();
                     break;
                 case 2:
                     prt.prtStudent(stdMgr.getStd(sc));
                     break;
                 case 3:
                     Student std = stdMgr.getStd(sc);
                     ScoreMenu();
                     System.out.println("메뉴를 입력해주세요: ");
                     int scoreId = sc.nextInt();
                     if (1 > scoreId || scoreId > 4) {
                         continue;
                     }
                     switch (scoreId) {
                          case 1:
                              prt.prtScores(std);
                             break;
                          case 2:
                             System.out.println("1:국어, 2:영어, 3:수학  입력: ");
                             int serected = sc.nextInt();
                             prt.prtScore(std, serected);
                             break;
                          case 3:
                             prt.prtSum(std);
                             break;
                          case 4:
                             prt.prtAvg(std);
                             break;
                          default:
                             break;
                     }
                     break;
                 case 4:
                     isRun = false;
                     break;
                 default:
                     break;
         }


    }

}
}