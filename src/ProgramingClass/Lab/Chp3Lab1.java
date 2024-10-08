package ProgramingClass.Lab;
class BitSet{
    // 32비트(int=4byte) 정수형 변수
    int state = 0;

    // 비트 설정 메서드
    // void : 반환(return) 값이 없는 메서드 (다른 패키지에서도 메서드를 호출하고 싶을 때는 public void ~
    void setBit(int position, boolean value) {
        // position 위치에 비트 값 설정
        // 예외처리
//        if (position < 0 || position > 31) {
//            throw new IllegalArgumentException("Position must be between 0 and 31");
//        }

        // value가 true면 | 연산과 쉬프트 연산(1 << position)을 사용해 1로 설정
        if(value){
            // 1을 옮겨서 or로 연산을 하니까 무조건 1
            state |= (1 << position);
//            System.out.println(Integer.toBinaryString(state));
        }else{
            // value가 false면 & 연산과 비트 반전(~)을 사용해 0로 설정
            // 1의 반대인 0 이랑 &연산을 하니까 무조건 0
            state &= ~(1 << position) ;
        }
    }

    // 비트 설정 메서드
    // boolean 메서드는 return이 무조건 boolean형
    boolean getBit(int position){
        // position 위치의 비트 값 반환
        // return문 과 함께 & 연산과 쉬프트 연산(1 << position)을 사용해 특정 위치의 비트 값을 확인
        return (state & (1 << position)) != 0;
        // == 1 이 안되는 이유 : 2진수로 계산하지만 비교할 때는 10진법으로 하기 때문에
        //    예) (permission = 1) 때 (0010)면 해당 비트의 값이 1인데도 비교할 때는 (2 == 1)이 되니까 안됨
        // 만약에 0이면 & 연산을 했을때 답이 0000이 됨 -> 나머지는 어떤 계산이라도 10진수로 봤을 때 0이 아닌 수가 나온다
        //    예) (0100)일때 (permission = 1)면 (0100 & 0010) -> 둘다 1이면 1이기 때문에 (0000) == 0
    }
}

public class Chp3Lab1 {
    public static void main(String[] args) {
        // 메소드 작성 후 실행 예시:
        // class내의 변수나 함수를 호출할 수 있게 pm 이라는 인스턴스를 생성
        BitSet bitSet = new BitSet();

        // set
        bitSet.setBit(5, true);  // true: 1, false: 0
        // get
        System.out.println(bitSet.getBit(5)); // true
        System.out.println(bitSet.getBit(3)); // false
    }
}
