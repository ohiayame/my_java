package oop;


import java.io.IOException;
import java.security.cert.CertificateException;

class Bar{
    void level1(){
        level2();
    }
    void level2(){
        level3();
    }
    void level3(){
        // RuntimeException의 객체 생성
        try {
            throw new RuntimeException("예외 발생 위치 : level3()");
        }catch (RuntimeException e){
            System.out.println("예외");
        }

    }
}



public class test0512 {
    public static void main(String[] args) {
        int pos = 3;
        try{
            System.out.println("t-1");

            if (pos == 0)
                throw new Exception();

            if (pos == 1)
                throw new CertificateException();
            if (pos == 2)
                throw new IOException();

            System.out.println("t-2");

        }catch (CertificateException e){
            System.out.println("CertificateException");
        }catch (IOException e){
            System.out.println("IOException");
        }catch (Exception e){
            System.out.println("Exception");

        }finally {
            System.out.println("finally");
        }

        System.out.println("t-3");
    }
}
