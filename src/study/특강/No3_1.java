package study.특강;

import java.util.Scanner;

public class No3_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();

        System.out.print("예약하려는 이벤트 코드를 입력하세요: ");
        String eventCode = sc.next();

        System.out.print("원하는 예약 날짜를 입력하세요: ");
        int reservationDate = sc.nextInt();
        // 예약 가능한지
        boolean isReservation = true;
        // 안될 때 문장
        String msg = "";
        // 범위 외의 날짜를 입력하면 종료
        if (reservationDate < 1 && reservationDate > 30) {
            System.out.print("잘못된 입력입니다. 프로그램을 종료합니다.");
            return;
        }
        // 이벤트 코드에 따라 오류 메시지를 설정
        switch (eventCode){
            case "E1":
                if (age < 18) {
                    isReservation = false;
                    msg = "나이 제한으로 인해 예약할 수 없읍니다.";
                }
                break;
            case "E2":
                if (reservationDate % 2 != 0) {
                    isReservation = false;
                    msg = "선택하신 날짜에는 예약할 수 없습니다.";
                }
                break;
            case "E3":
                if (age < 16 ){
                    isReservation = false;
                    msg = "나이 제한으로 인해 예약할 수 없읍니다.";
                } else if (reservationDate % 7 != 0) {
                    isReservation = false;
                    msg = "선택하신 날짜에는 예약할 수 없습니다.";
                }
                break;
            default:
                msg = "잘못된 입력입니다. 프로그램을 종료합니다.";
        };

        if (isReservation){
            System.out.println("예약이 완료 되었습니다!");
        }
        else{
            System.out.println(msg);
        }
    }
}
