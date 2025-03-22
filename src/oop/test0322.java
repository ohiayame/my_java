package oop;

class Bar {
    int b; // 인스턴트 멤버 변수 -> 오프셋 (객체와 같이 heap영역에 저장)
    static int staticB;  // 클래스 멤버 변수 -> metaspace에 저장

    // default 생성자
    Bar(){
        System.out.println("Bar Constructor");
        this.setFoo(); // private 메서드 호출
    }
    // parameter 생성자
    Bar(int argB){
        this.b = argB; // 매개변수의 값을 b(인스턴트 멤버 변수)에 대입 -> 객체와 같이 heap영역에 저장
        System.out.printf("Bar Constructor : %d", this.b);
        System.out.println();
    }
    // 클래스 내부에서만 호출 가능한 메서드
    private void setFoo(){
        staticB ++; // 클래스 맴버 변수 +1
        Foo foo = new Foo();// foo객체 생성 -> 이 메서드 종료시 생명주기 끝남
        // mata space: Class Loader로 Foo.class 로딩후 저장
        // heap: Foo객체(foo) 생성(default 생성자)
        // stack: Foo객체의 주소값 저장
        System.out.println("Foo Constructor load");

        printF(); // 인스턴스 멤버 메서드 호출 ( stack영역의 foo전달 안함 -> 죽음 )
        printF(foo);  // 인스턴스 멤버 메서드 호출 ( stack영역의 foo객체 전달 )
    }
    // 메서드 종료시 stack영역에서 foo(참조변수) 죽음
    // -> heap영역의 객체는 GC가 자동으로 삭제

    // 인스턴스 멤버 메서드 -> metaspace에 저장
    void printB(){
        System.out.println(this.b);
    }

    // // 인스턴스 멤버 메서드 -> metaspace에 저장
    void printF(){
//        foo.printB();  // -> foo객체는 이미 죽어있기 때문에 에러
    }
    // printF()과 오버로딩
    // 인스턴스 멤버 메서드 -> metaspace에 저장
    void printF(Foo foo){
        foo.printB();  // -> foo객체를 인자 값(매개변수)로 받았기 때문에 가능
    }
}

class Foo{
    int f; // 인스턴트 멤버 변수 -> 오프셋 (객체와 같이 heap영역에 저장)

    // 초기화 블록 -> class로딩시(21라인) 맨 처음에 실행
    static {
        //
        System.out.printf("Bar.staticB: %d", Bar.staticB);
        // Bar = Bar 메타데이터의 주소값
        // Bar 메타데이터의 주소값에서 해당 클래스 멤버 변수를 찾아 출력
        System.out.println();
    }

    // default 생성자 -> metaspace에 저장되어 있음
    // 초기화 블록 실행 후 실행
    Foo(){
        System.out.println("foo Constructor");
        this.f = Bar.staticB;
        // 객체 생성시 Bar의 클래스 멤버 변수의 값을 f(인스턴트 멤버 변수)에 대입
        // -> 객체(foo(21라인))와 같이 heap영역에 저장
    }
    // 인스턴스 멤버 메서드 -> metaspace에 저장
    void printB(){
        System.out.println(this.f);
    }
}

class Pos{
    Pos(int argpos){
        System.out.println("Pos Constructor");
    }
    // 호출되지 않기 때문에 Pos.class파일만 존재하고 JVM은 클래스 자체를 로딩하지 않음
    // 만약 new Pos()로 호출한 경우
    // 이미 parameter생성자가 존재하기 때문에 에러
    // -> default 생성자는 생성자가 없을때만 자동완성기능 제공
}

public class test0322 {
    //  mata space: Class Loader로 test0322.java과 동일 이름인 test0322.class 로드
    public static void main(String[] args) {
        int mainNum = 3; // 지역 변수
        // stack : mainNum = 3 저장

        Bar bar = new Bar();
        // mata space: Class Loader로 Bar.class 로딩후 저장
        // heap: bar객체(bar) 생성(default 생성자)
        // stack: bar객체의 주소값 저장

        Bar barNum = new Bar(mainNum);
        // heap: bar객체(barNum) 생성(parameter 생성자 -> int b = 3)
        // stack: bar객체의 주소값 저장

        // 각 Bar객체에 저장되어있는 클래스메타데이터를 참조하여
        // 각 객체가 가지고있는 b값 출력
        bar.printB();
        barNum.printB();

    }
    // main코드 종료시 stack영역 main()프레임 제거 (bar, barNum 참조 제거)
    // -> heap영역의 객체는 GC가 자동으로 삭제
    // -> 프로그램 종료
}

