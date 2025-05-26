package oop;

import java.io.IOException;
import java.util.Scanner;

class Bar implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Bar ~ close");
    }
}

public class test05232 {
    public static void main(String[] args) {
        try(Bar bar = new Bar()){
            System.out.print("숫자를 입력 하세요 (1. 정상 실행, 그 외: IOException 발생): ");
            int input = new Scanner(System.in).nextInt();

            if (input == 1){
                System.out.println("try 블록 정상 실행");
            }else{
                throw new IOException("입력값이 1 아님");
            }
        }catch (IOException e){
            System.out.println("catch ~ IOException: " + e.getMessage());

            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("-> Suppressed: " + suppressed);
            }
        }catch (Exception e){
            System.out.println("catch ~ Exception: " + e.getMessage());
        }
    }
}
