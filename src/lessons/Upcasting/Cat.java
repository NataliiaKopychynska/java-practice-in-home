package lessons.Upcasting;

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " нявкає: Мяу! 🐱");
    }

    public void scratch() {
        System.out.println(name + " дряпає");
    }
}
