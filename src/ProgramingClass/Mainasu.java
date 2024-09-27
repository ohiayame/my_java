package ProgramingClass;

public class Mainasu {
    public static void main(String[] args) {
        int foo = 1;
        int bar = -1;

        int temp1 = foo - bar;
        int temp2 = foo + (-bar);

        System.out.println(Integer.toBinaryString(foo)); // 1
        System.out.println(Integer.toBinaryString(bar)); // 11111111111111111111111111111111
    }
}
