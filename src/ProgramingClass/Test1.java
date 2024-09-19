package ProgramingClass;

public class Test1 {
    public static void main(String[] args) {
        // A -> Z 출력
        for (char bar = 'A'; bar <= 'Z'; bar += 2){
            System.out.print(bar + "\t");
        }

        // 줄 바꿈
        System.out.println();

        // z -> a 출력
        for (char foo  = 'z'; foo >= 'a'; foo --){
            System.out.print(foo + "\t");
        }
        System.out.println();
        int kin = 2;
        System.out.println(kin++);
        System.out.println(++kin);
    }
}
