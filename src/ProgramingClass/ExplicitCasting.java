package ProgramingClass;

public class ExplicitCasting {
    public static void main(String[] args) {
        double realNum = 9.99;
        int num = (int) realNum;  // 강제 형변환 (double -> int)

        System.out.println("형변환된 int 값은 " + num);  // 9 (소수점 이하 버려짐)



        //        long kin = (10 + 2) / 2.0;  // error

        long kin1 = (long) ((11 + 2) / 2.0); // 6 -> long 자료형 통일
        System.out.println(kin1);

        double kin2 = (10 + 2) / 2.0;  // 6.0 -> float 통일
        System.out.println(kin2);
    }
}
