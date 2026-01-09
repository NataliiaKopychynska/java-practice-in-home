package lessons.Upcasting;

public class UpcastingExample {
    public static void main(String[] args) {
        // Створення об'єктів
        Dog myDog = new Dog("Рекс");
        Cat myCat = new Cat("Мурка");

        // UPCASTING - автоматичне (неявне)
        // Dog → Animal (дочірній клас → батьківський клас)
        Animal animal1 = myDog;  // Автоматично!
        Animal animal2 = myCat;  // Автоматично!

        System.out.println("=== Після upcasting ===");

        // Можемо викликати методи Animal
        animal1.eat();           // ✅ Працює
        animal1.makeSound();     // ✅ Викликає Dog.makeSound() (поліморфізм!)

        animal2.eat();           // ✅ Працює
        animal2.makeSound();     // ✅ Викликає Cat.makeSound()

        // НЕ можемо викликати специфічні методи
        // animal1.fetch();      // ❌ ПОМИЛКА! Animal не знає про fetch()
        // animal2.scratch();    // ❌ ПОМИЛКА! Animal не знає про scratch()

        System.out.println("\n=== Upcasting у методах ===");
        feedAnimal(myDog);  // Передаємо Dog, але метод приймає Animal
        feedAnimal(myCat);  // Передаємо Cat, але метод приймає Animal
    }

    // Метод приймає Animal, тому може працювати з будь-яким нащадком
    public static void feedAnimal(Animal animal) {
        System.out.println("Годуємо тварину:");
        animal.eat();
        animal.makeSound();
    }
}
