package ProgramingClass;

public class LogicalOperatorExample {
    public static void main(String[] args) {
        // 1)
        // 나이: 20
        int age = 20;
        // boolean 선언
        boolean ticket = true;

        // 나이가 18세 이상이고 boolean이 참인지 결과를 저장하는 변수를 선언
        boolean Enter = (age >= 18) && ticket;
        // 결과 출력
        System.out.println(Enter);

        // 2)
        // 비가 오는지
        boolean rain  = false;
        boolean cloudy = true;

        // 비가 오거나 날씨가 흐리면 boolean 결과를 저장하는 변수를 선언
        boolean Umbrella = rain || cloudy;

        // 결과 출력
        System.out.println(Umbrella);

        // 3)
        // 가게가 닫혀 있음 = false 선언
        boolean closed = false;
        // 가게가 닫혀 있지 않으면 방문하는 변수를 선언
        boolean go = !closed;
        // 결과를 출력
        System.out.println(go);

        // 4)
        // 주차장이 비어있음 = false
        boolean full = false;
        // 전기차 아님 = false
        boolean lightcar = false;
        // 주차장이 비어있거나 전기차일 경우 참인 변수를 선언
        boolean parking = !full || lightcar;
        // 결과 출력
        System.out.println(parking);

        // 5)
        // 나이 : 12
//        int age = 12;
        // 나이가 8세 이상이고 15세이하면 참인 변수를 선언
        boolean ok = (age >= 8) && (age <= 15);
        // 결과 출력
        System.out.println(ok);

        // ６）
        // 나이 : 30
//        int age = 30;
        // 나이가 13세 미만이거나 65세 이상이면 참인 변수를 선언
        boolean check = (age < 13) || (age >= 65);
        // 결과 출력
        System.out.println(check);

        // 7)
        int a = 10;
        int b = 5;

        boolean result = (a > 0) && (b++ > 5);
        System.out.println(b);

        result = (a < 0) || (b++ > 5);
        System.out.println(b);
    }
}
