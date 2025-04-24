package oop.lab;

class Player{
    protected String name;
    protected String position;

    Player(String argName, String argPosition){
        this.name = argName;
        this.position = argPosition;
    }

    public void shoot(){
        System.out.println(position + " " + name + ": 기본 슛");
    }
}

class Sg extends Player{
    public Sg(String argName){
        super(argName, "슈팅 가드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 3점 슛");
    }
}
class Pg extends Player{
    public Pg(String argName){
        super(argName, "포인트 가드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 돌파 후 점퍼");
    }
}
class Sf extends Player{
    public Sf(String argName){
        super(argName, "스몰 포워드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 슬래시 앤 드라이브");
    }
}
class Pf extends Player{
    public Pf(String argName){
        super(argName, "파워 포워드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 미들 슛");
    }
}
class Center extends Player{
    public Center(String argName){
        super(argName, "센터");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 골밑슛");
    }
}
public class BasketMain {
    public static void main(String[] args) {
        Player[] team = {
                new Pg("아"),
                new Sg("이"),
                new Sf("우"),
                new Pf("에"),
                new Center("오")
        };

        System.out.println("슛 시작");

        for (Player p : team) {
            p.shoot();
        }
    }
}
