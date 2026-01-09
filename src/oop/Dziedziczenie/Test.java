package oop.Dziedziczenie;

public class Test {
    public static  void main(String[] args) {
        Dog dog1= new Dog("Rex", 3,"Pudil");
        Cat cat1= new Cat("Pudil",20,true);

        System.out.println("\n---Info---");
        dog1.getInfo();
        System.out.println();
        cat1.getInfo();
        System.out.println("\n---Info2---");
        dog1.walk();
        cat1.walk();

        System.out.println("\n---Info3---");
        dog1.fetch();
        cat1.scratch();

    }
}
