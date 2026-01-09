package oop.abstractClass;

public class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    public Motorcycle(String brand, boolean sidecar) {
        super(brand);
        this.hasSidecar = sidecar;
    }

    @Override
    public void startEngine() {
        System.out.println(brand + " (мотоцикл): Мотор ревє! 🏍️");
    }

    @Override
    public void brake() {
        speed = Math.max(0, speed - 20);
        System.out.println(brand +"гальмує різко!");
    }
}
