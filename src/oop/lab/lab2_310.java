package oop.lab;
class User{
    private String username;
    private String email;

    // Default constructor
    User(){
        this.username = "Guest";
        this.email = "guest@gmail.com";
        System.out.println("Guest User created");
    }
    // Parameter Constructor
    User(String username, String email){
//        if(username.isEmpty() || email.isEmpty()){
//            throw new IllegalArgumentException("Username and email cannot be empty");
//        }
        this.username = username;
        this.email = email;
        System.out.println("User created");
    }

    void printUserInfo(){
        System.out.println("Username: " + username + ", Email: " + email);
    }
}

public class lab2_310 {
    public static void main(String[] args) {
        User user1 = new User();
        user1.printUserInfo();

        System.out.println("--------------------------------");
        User user2 = new User("hong", "hong@gmail.com");
        user2.printUserInfo();
    }
}
