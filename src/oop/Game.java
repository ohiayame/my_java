package oop;
class Players {
    protected String name;
    protected String position;

    Players(String argName, String argPosition){
        this.name = argName;
        this.position = argPosition;
    }

    public void shoot(){
        System.out.println(position + " " + name + ": 기본 슛");
    }
}

class Sg extends Players {
    public Sg(String argName){
        super(argName, "슈팅 가드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 3점 슛");
    }
}

class Pg extends Players {
    public Pg(String argName){
        super(argName, "포인트 가드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 돌파 후 점퍼");
    }
}
class Center extends Players {
    public Center(String argName){
        super(argName, "센터");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 골밑슛!");
    }
}
class Sf extends Players {
    public Sf(String argName){
        super(argName, "스몰 포워드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 슬래시 앤 드라이브!");
    }
}
class Pf extends Players {
    public Pf(String argName){
        super(argName, "파워 포워드");
    }

    @Override
    public void shoot() {
        System.out.println(position + " " + name + ": 미들슛");
    }
}

public class Game {
    public static void main(String[] args) {
        Players[] team ={
                new Pg("민수"),
                new Sg("준호"),
                new Sf("지훈"),
                new Pf("명철"),
                new Center("성민")
        };

        System.out.println("[팀 슛 연습 시작]\n");

        for (Players p : team) {
            p.shoot();
        }
    }
}
