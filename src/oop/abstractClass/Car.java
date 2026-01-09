package oop.abstractClass;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int doors){
        super(brand);
        this.numberOfDoors = doors;
    }

    public Car(String brand) {
        super(brand);
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " (машина): Двигун запущено! Врум-врум! 🚗");
    }

    @Override
    public void brake() {
        speed = 0;
        System.out.println(brand + " гальмує. Швидкість: " + speed);
    }

//    @Override
//    public void accelerate(int amount) {
//        super.accelerate(amount);
//    }
//
//    @Override
//    public void displayInfo() {
//        super.displayInfo();
//    }
}
