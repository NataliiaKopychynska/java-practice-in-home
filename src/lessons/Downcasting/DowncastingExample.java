package lessons.Downcasting;

import oop.Dziedziczenie.Animal;
import oop.Dziedziczenie.Cat;
import oop.Dziedziczenie.Dog;

public class DowncastingExample {
    public static void main(String[] args) {
        // Upcasting
        Animal animal = new Dog("Рекс", 1,"haski");  // Dog → Animal

        animal.eat();        // ✅ Працює
        animal.makeSound();  // ✅ Працює
        // animal.fetch();   // ❌ ПОМИЛКА! Animal не має fetch()

        System.out.println("\n=== DOWNCASTING ===");

        // DOWNCASTING - ЯВНЕ перетворення (потрібні дужки)
        Dog dog = (Dog) animal;  // Animal → Dog

        dog.eat();        // ✅ Працює
        dog.makeSound();  // ✅ Працює
        dog.fetch();      // ✅ Тепер працює!

        System.out.println("\n=== НЕБЕЗПЕЧНИЙ downcasting ===");

        // Це НЕБЕЗПЕЧНО!
        Animal animal2 = new Cat("Мурка", 1, false);

        // Спроба перетворити Cat на Dog
        // Dog fakeDog = (Dog) animal2;  // ❌ ClassCastException!

        // ПРАВИЛЬНИЙ спосіб - перевірка типу
        if (animal2 instanceof Dog) {
            Dog dog2 = (Dog) animal2;
            dog2.fetch();
        } else {
            System.out.println("Це не собака! Це " + animal2.getClass().getSimpleName());
        }
    }
}
