package study.특강;

public class No3_2 {
    // 출석점수 게산 메소드 생성
    static float CalculateAttendanceScore(int hoursePerWeek, int absenceHours, int tardyCount) {
        // 1) 총 수업 시간 계산
        // 시수/주 × 15
        int allHours = hoursePerWeek * 15;

        // 2)  지각 3회 -> 결석 1시간
        if (tardyCount >= 3){
            absenceHours += tardyCount / 3;
        }
        // 3)  결석 시수가 총 수업 시수의 1/4을 초과 -> F
        if (absenceHours >= (allHours / 4)){
            return 0;
        }
        // 4) 출석 점수 계산
        // 20점- (20 × 결석시간 수 / 총 수업 시간수)
        float score = 20 - (20 * absenceHours / (float) allHours);

        // return 출석점수
        return score;
    }

    public static void main(String[] args) {

        // 입력
        // 1. 주당 수업 시간
        int hoursePerWeek = 6;
        // 2. 결석한 총 시간
        int absenceHours = 12;
        // 3. 지각 횟수
        int tardyCount = 4;

        // 출력
        float score = CalculateAttendanceScore(hoursePerWeek, absenceHours, tardyCount);
        // return값이 0 -> f
        if (score != 0) {
            System.out.printf("당신의 출석 점수는 %.2f점입니다.", score);
        }else{
            System.out.println("당신의 출석 점수는 F (학점 미부여)점입니다.");
        }
    }
}
