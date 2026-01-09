package oop.Dziedziczenie;

public class Cat extends Animal {
    private boolean isIndoor;

    public Cat(String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    public void makeSound() {
        System.out.println(name + " нявкає: Мяу! 🐱");
    }

    public void scratch() {
        System.out.println(name + " дряпає меблі");
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Домашня: " + (isIndoor ? "Так" : "Ні"));
    }
}

