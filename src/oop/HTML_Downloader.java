package oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HTML_Downloader {
    public static void main(String[] args) {
        try {
            // 1. 접근할 웹 페이지 URL 지정

            // ✅ 정상 작동: 에러 없음
            URL url = new URL("https://www.example.com");

            // 🔴 아래 문법 실행함: 에러 주석을 하나씩 해제해보세요

            // ✅ MalformedURLException 발생 (프로토콜 철자 오류)
            // URL url = new URL("ht://www.example.com");

            // ✅ UnknownHostException 발생 (존재하지 않는 도메인)
            // URL url = new URL("https://www.example.222222com");

            // 2. 스트림을 통해 HTML 문서 읽기
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())  // IOException 발생 가능
            );

            // 3. 한 줄씩 읽어서 화면에 출력
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 4. 리소스 해제
            reader.close();

        } catch (MalformedURLException e) {
            // URL 생성 시 형식이 잘못되었을 때 발생 (ex: "ht://")
            System.out.println("URL 형식이 잘못되었습니다: " + e.getMessage());

        } catch (UnknownHostException e) {
            // 호스트 이름이 DNS에서 해석되지 않을 때 발생 (ex: 도메인이 존재하지 않음)
            System.out.println("도메인이 존재하지 않습니다: " + e);

        } catch (IOException e) {
            // 스트림 열기/읽기 중 오류 (ex: 연결 실패, 파일 없음, 네트워크 오류 등)
            System.out.println("데이터를 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
