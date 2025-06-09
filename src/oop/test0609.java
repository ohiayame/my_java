package oop;


class Barr implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("* ");
                Thread.sleep(500);
            }
        }catch (Exception e) {}

    }
}
class Foo implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("- ");
                Thread.sleep(500);
            }
        }catch (Exception e) {}

    }
}


public class test0609 {
    public static void main(String[] args) {
        Barr b = new Barr();
        Foo f = new Foo();

        Thread t1 = new Thread(b);
        Thread t2 = new Thread(f);

        t1.start();
        t2.start();

        // 익명 클래스
        Thread t = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("- ");
                        Thread.sleep(500);
                    }
                }catch (Exception e) {}

            }
        });

        t.start();

    }
}
