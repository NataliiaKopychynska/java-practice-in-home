package oop.abstractClass;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Toyote", 4);
        car.startEngine();
        car.accelerate(50);
        car.accelerate(30);
        car.brake();

        System.out.println();

        Motorcycle moto = new Motorcycle("Harley",false);
        moto.startEngine();
        moto.accelerate(50);
        moto.brake();
    }
}
