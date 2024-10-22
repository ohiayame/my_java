package ProgramingClass;

public class Loopfor {
    public static void main(String[] args){
//        int bar = 0;
//        for (int i = 0; i < 10; i++){
//            int k =  0;
//        }
//        System.out.println(i);
//        System.out.println(k);
//
//        for (int i = 0,pos = 1; i < 5 && pos > -3; i ++, pos--){
//            System.out.println("Hello World");
//            System.out.println(pos);
//        }
//
//        for (int i = 0; i < 10; i++){
//            if (i % 2 == 0){
//                System.out.println(i);
//            }
//        }
//
//        for (int i = 0; i < 10; i += 2){
//            System.out.println(i);
//        }
//
//        for(char chValue = 'Z'; chValue >= 'A'; chValue--){
//            System.out.print(chValue);
//        }

        int bar[] = new int[5];
        for(int i = 0, value = '*'; i < bar.length; i++, value += '*'){
            bar[i] = value;
        }

        for(int i = 0;i < bar.length; i++){
            System.out.println(bar[i]);
        }
    }
}
