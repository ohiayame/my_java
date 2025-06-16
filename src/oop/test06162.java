package oop;
import java.util.ArrayList;
import java.util.function.Consumer;
class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;  this.age = age;
    }
}

class Add<T extends Number, R>{
//    int add(int a,int b){return a+b;}
    R op(T a, T b){return a+b;}
}
class Box<T> {
    private T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}


public class test06162 {
    public static void main(String[] args) {
//        ArrayList<Person> list = new ArrayList<Person>();
//
//        list.add(new Person("Yon", 20));
//        list.add(new Person("Jane", 31));
//        list.add(new Person("Tack", 41));
//        list.add(new Person("Qill", 51));
//
//
//        Consumer<Person> prt = (obj) -> System.out.println(obj.name + " : " + obj.age);
//
//        list.stream().filter((obj) -> obj.age > 30).forEach(prt);

        Box<String> stringBox = new Box<>();
        Box<Integer> intBox = new Box<>();

        stringBox.set("Hello");
        intBox.set(1);
        System.out.println(stringBox.get());
        System.out.println(intBox.get());

        Integer myValue = 10;
        int myAge = myValue; // Unboxing




    }
}
