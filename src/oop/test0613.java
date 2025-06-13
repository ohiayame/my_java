package oop;

interface MathOperator {
//    int operate(int a, int b);
    void operation(String a);
}
//class CalculatorAdd implements MathOperator {
//    public int operate(int a, int b) {
//        return a + b;
//    }
//}
//
//class CalculatorMul implements MathOperator {
//    public int operate(int a, int b) {
//        return a * b;
//    }
//}
//
//class Computer{
//    static void doSomething(int x, int y, MathOperator m){
//        System.out.println(m.operate(x,y));
//    }
//}

public class test0613 {
    public static void main(String[] args) {
//        Computer.doSomething(1, 2, new CalculatorAdd());
//        Computer.doSomething(1, 2,new CalculatorMul());

        MathOperator opAdd = a -> { System.out.println(a);};
        opAdd.operation("opAdd");

        MathOperator opSub = System.out::println;
        opSub.operation("opSub");



        //함수형 인터페이스, lamda 표현식 -> 인터페이스 단일 내용
//        MathOperator opAdd;
//        opAdd = (a, b) -> a + b;
//
//        MathOperator opMul = (a, b) -> {
//            int mul = a * b;
//            return mul;
//        };
//
//        System.out.println(opAdd.operate(1,2));
//        System.out.println(opMul.operate(1,2));
    }
}
