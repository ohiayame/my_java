package study;

public class Calendar {
    public static void main(String[] args) {

        int[][][] calendar = new int[12][][];

        // 각 월별 일 수를 배열로 정의 (윤년을 고려하지 않음)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int month = 0; month < calendar.length; month++) {
            // 각 월의 일수를 가져옵니다.
            int daysInCurrentMonth = daysInMonth[month];

            // 해당 월의 주 수 계산 (1주일씩 7일씩 나누기)
            // 나머지를 처리하기 위해 +6을 해서 나누기 연산을 함
            int numWeeks = (daysInCurrentMonth + 6) / 7;

            calendar[month] = new int[numWeeks][];

            for (int week = 0; week < numWeeks; week++) {
                int startDay = week * 7 + 1; // 주의 첫날
                int endDay = Math.min(startDay + 6, daysInCurrentMonth); // 그 주에서 마지막날이 언제인지를 그 달의 마지막 날짜와 비교해서 구함

                // 각 주마다 날짜 배열을 할당
                // 마지막주와 배열 크기를 위해 하는거임
                calendar[month][week] = new int[endDay - startDay + 1];

                // 주마다 날짜를 채우기
                for (int day = startDay; day <= endDay; day++) {
                    calendar[month][week][day - startDay] = day;
                }
            }
        }

        // 달력을 출력
        for (int month = 0; month < calendar.length; month++) {
            System.out.println((month + 1) + "월:");
            for (int week = 0; week < calendar[month].length; week++) {
                for (int day : calendar[month][week]) {
                    System.out.print(day + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

