package study;

public class Calendar {
    public static void main(String[] args) {


        int[][][] calendder = new int[12][][];

        for(int month = 0; month < calendder.length ; month++) {
            if(month == 1){
                calendder[month] = new int[4][];
            }else{
                calendder[month] = new int[5][];
            }
            for(int week = 0; week < calendder[month].length ; week++) {
                if (week == 4){
                    if ((month+1) % 2 == 0 && month != 7){
                        calendder[month][week] = new int[2];
                    }else{
                        calendder[month][week] = new int[3];
                    }
                }else {
                    calendder[month][week] = new int[7];
                }
                for(int day = 0; day < calendder[month][week].length ; day++) {

                    calendder[month][week][day] = 7*week + day+1;
                }
            }
        }


        for(int month = 0; month < calendder.length ; month++) {
            System.out.println((month+1) + "월");
            for(int week = 0; week < calendder[month].length ; week++) {
                for(int day = 0; day < calendder[month][week].length ; day++) {
                    System.out.print(calendder[month][week][day] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
