package study.특강;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoiseMeasurement {
    public static void main(String[] args) {
        // 프로그램은 사용자가 Ctrl+C를 누르기 전까지 계속 실행(break 없이 실행)
        // 2초 동안 100ms 간격으로 소음을 측정하고 평균값을 계산
        int[] noiseArray = new int[20];
        int index = 0;
        while(true) {
            // 현재 시간 가져오기
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String currentTime = formatter.format(new Date());

            int sumNoiseLevel = 0;
            // 100ms 간격으로 총 20번 소음을 측정 -> 배열로 저장
            for (int i = 0; i < noiseArray.length; i++) {
                // 소음 값은 20 ~ 60 사이의 랜덤 정수로 생성
                int noiseLevel = 20 + (int) (Math.random() * 41);
                noiseArray[i] = noiseLevel;
                sumNoiseLevel += noiseLevel;

//                try {
//                    Thread.sleep(100); // 100ms = 0.1초
//                } catch (InterruptedException e) {
//                    System.err.println("스레드 대기 중 오류 발생: " + e.getMessage());
//                }
            }


            // 2초 동안 총 20개의 소음 값을 저장하여
            // 평균을 계산하고 현재 시간(시:분:초 형식)과 같이 출력
            System.out.println("======== 실시간 소음 측정 ========");
            System.out.printf("현제 시간: %s%n",currentTime);
            System.out.printf("측정된 소음 값: %s%n",sumNoiseLevel/noiseArray.length);
            System.out.println("===============================");


            try{
                Thread.sleep(2000);

            }catch(InterruptedException e){
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}
