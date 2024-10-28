package study.특강;

public class No3_1 {
    public static void main(String[] args) {
        int age = 20;
        String eventCode = "E1";
        int reservationDate = 30;

        boolean isReservation = true;
        String msg = "";
        
        if (reservationDate < 1 && reservationDate > 30) {
            isReservation = false;
            msg = "잘못된 입력입니다. 프로그램을 종료합니다.";
        }
        
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
