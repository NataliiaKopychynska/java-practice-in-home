package lessons.Downcasting;

import oop.Dziedziczenie.Animal;
import oop.Dziedziczenie.Cat;
import oop.Dziedziczenie.Dog;

public class SafeDowncasting {
    public static void handleAnimal(Animal animal) {
        System.out.println("\n--- Обробка тварини ---");

        // Загальні дії для всіх тварин
        animal.eat();
        animal.makeSound();

        // Перевірка типу перед downcasting
        if (animal instanceof Dog) {
            System.out.println("Це собака! Можемо грати:");
            Dog dog = (Dog) animal;
            dog.fetch();
        } else if (animal instanceof Cat) {
            System.out.println("Це кіт! Будьте обережні:");
            Cat cat = (Cat) animal;
            cat.scratch();
        } else {
            System.out.println("Це просто тварина");
        }
    }

    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Рекс", 1,"haski"),
                new Cat("Мурка",2,true),
                new Dog("Рекс", 1,"haski"),
                new Animal("Загальна тварина",3)
        };

        for (Animal animal : animals) {
            handleAnimal(animal);
        }
    }
}