package ProgramingClass;

public class If {
    public static void main(String[] args) {
//        int bar = 3;
//        if (bar == 2) {
//            System.out.println("true");
//        }else{
//            System.out.println("false");
//        }
//
//
//
////        {
//            int foo = 5;
//            System.out.println("false");
////        }
//        System.out.println(foo);

        String myTeam = "lg";

        switch (myTeam) {
            case "samsung":
                System.out.println("Samsung");
            case "lg":
                System.out.println("LG");
            default:
                System.out.println("Unknown");
        }

        String day = "토요일";
        switch (day) {
            case "토요일":
            case "일요일":
                System.out.println("주말");
                break;
            default:
                System.out.println("평일");
        }
    }
}
