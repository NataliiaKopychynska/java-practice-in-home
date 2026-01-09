package oop.abstractClass;

public abstract class Vehicle {
    protected String brand;
    protected int speed ;

    public Vehicle(String brand) {
        this.brand = brand;
        this.speed = 0;
    }


    // Абстрактний метод - немає реалізації
    public abstract void startEngine();

    // Абстрактний метод
    public abstract void brake();

    // Звичайний метод з реалізацією
    public void accelerate(int amount) {
        speed += amount;
        System.out.println(brand + " прискорюється до " + speed + " км/год");
    }

    public void displayInfo() {
        System.out.println("Транспорт: " + brand + ", Швидкість: " + speed);
    }

}
