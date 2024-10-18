package ProgramingClass.Lab;
class PermissionManager {
//  권한 비트 위치 상수 정의
    // private로 선언된 멤버는 해당 클래스 내부에서만 접근 가능
    // public으로 선언된 멤버는 모든 클래스에서 접근 가능
    // 동일한 패키지 내에서는 public없이 선언해도 됨
    // static : 모든 인스턴스에서 동일한 값을 유지
    public static final int READ = 0;  // 읽기 권한 비트 위치
    public static final int WRITE = 1;  // 쓰기 권한 비트 위치
    public static final int EDIT = 2;  // 수정 권한 비트 위치
    public static final int DELETE = 3;  // 삭제 권한 비트 위치


    private byte permissions = 0; // 초기 권한 설정은 모두 비활성화 (0)

// 권한 설정 메소드
    // permission : 무슨 권한인지 번호로 전달 // enable : true or false 지정
    void setPermission(int permission, boolean enable){
        // enable이 true인 경우
        // - permission 위치에 있는 비트를 1로 설정(| 연산과 << 연산 사용)
        if(enable){
            permissions |= 1 << permission;
//            System.out.println(Integer.toBinaryString(permissions)); // (.. |= 1 << ..)는 0이든 1이든 1이됨
        }else {
            // enable이 false인 경우
            // - permission 위치에 있는 비트를 0으로 설정 (& 연산과 ~ 연산 사용)
            permissions &= ~(1 << permission);  // 1을 이동시키고 그걸 반전하니까 0이되고 &연산(한쪽이라도 0이면 0)을 통해 상대도 무조건 0이 됨
        }

    }
// 권한 확인 메소드
    // boolean : return이 무조건 boolean형 (다른 패키지에서도 메서드를 호출하고 싶을 때는 public boolean ~
    boolean checkPermission(int permission){
    // permission : 확인하려는 권하 (0번째, 1번째, 2번째, 3번째 비트 자리 중 하나)
    // - permisson 위치 비트가 0이 아니면(1) true, 그렇지 않으면 false를 반환
        // (1 << permission)로 1의 자리를 permission만큼 옮겨서 permissions의 해당비트가 1인지 0인지 &로 확인 (!= 0 -> 1
        return (permissions & (1 << permission)) != 0;  // 0이 아니면 true
    }

    // 모든 권한 초기화 메소드
    void removeAllPermissions(){
        // permissions 값을 0으로 설정하여 모든 비트를 0으로 만듦
        permissions = 0;
    }
}
public class Chp3Lab2 {
    public static void main(String[] args) {
        // PermissionManager class내의 변수나 함수를 호출할 수 있게 pm 이라는 인스턴스를 생성
        PermissionManager pm = new PermissionManager();

    // 읽기 쓰기 삭제 권한 설정
        // 인스턴스(class).메소드 호출(class.상수(permission), enable)
        pm.setPermission(PermissionManager.READ, true);    // 읽기 권한 활성화
        pm.setPermission(PermissionManager.WRITE, true);   // 쓰기 권하 활성화
        pm.setPermission(PermissionManager.DELETE, true); // 삭제 권한 활성화

        // 권한 확인
        System.out.println("읽기 권한: " + pm.checkPermission(PermissionManager.READ));  // true
        System.out.println("쓰기 권한: " + pm.checkPermission(PermissionManager.WRITE)); // true
        System.out.println("수정 권한: " + pm.checkPermission(PermissionManager.EDIT));  // false
        System.out.println("삭제 권한: " + pm.checkPermission(PermissionManager.DELETE));// true

        // 모든 권한 제거
        pm.removeAllPermissions();
        System.out.println("읽기 권한: " + pm.checkPermission(PermissionManager.READ));  // false
        System.out.println("삭제 권한: " + pm.checkPermission(PermissionManager.DELETE));// false
    }
}
