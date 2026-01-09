package oop.Dziedziczenie;

public class Dog extends Animal {
    private String breed;

    public Dog( String name, int age, String breed) {
        super(name,age);
        this.breed = breed;
        System.out.println("create new dog" + breed);
    }

    @Override
    public void walk() {
        System.out.println(name + "walk... and barks");
    }

    public void fetch(){
        System.out.println("Fetching Dog" + name +"brings a stick");
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Bread" + breed);
    }
}
