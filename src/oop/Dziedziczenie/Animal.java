package oop.Dziedziczenie;

public class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(name + age );
    }

    public void eat(){
        System.out.println(name + "eat" );
    }
    public void sleep(){
        System.out.println(name + "sleep" );
    }
    public void walk(){
        System.out.println(name + "walk" );
    }

    public void getInfo(){
        System.out.println(name + "has" + age );
    }

    public void makeSound() {
        System.out.println(name + "make sound" );
    }
}
