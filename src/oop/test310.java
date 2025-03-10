package oop;

class Student {
    // 데이터 + 함수
    int korean;
    int math;
    int english;
    int sum;
    final int NUM_OF_SUBJECT = 3;

    int id;
    String name;

    void setGrade(int argKorean, int argMath, int argEnglish) {
        korean = argKorean;
        math = argMath;
        english = argEnglish;
        sum = korean + math + english;
    }

    double getSum() {
        return sum;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getAvg() {
        return sum / NUM_OF_SUBJECT;
    }
}

class Bar{
    String name;
    // 생성자 (객체 생성시 실행)
    Bar(){
        System.out.println("Bar 생성자 호출");
    }
    // 메소드 (메소드 명시적으로 호출시 실행)
    void printInfo(){
        System.out.println(name);
    }
}
// 실행 코드
public class test310 {
    public static void main(String[] args) {
//        // Student 객체를 저장할 배열을 선언
//        Student stdList[] = new Student[10];
//
//        stdList[0] = new Student();
//        stdList[1] = new Student();
//        stdList[2] = new Student();
//        stdList[3] = new Student();

        Bar bar = new Bar(); // 객체 생성 (동시에 생성자 실행)
        bar.printInfo(); // 메소드 실행
    }

}
