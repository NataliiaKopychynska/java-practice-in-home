package lessons.Upcasting;

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " гавкає: Гав-гав! 🐕");
    }

    // Унікальний метод для Dog
    public void fetch() {
        System.out.println(name + " приносить палицю");
    }
}
