package lessons.Upcasting;

class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " їсть");
    }

    public void makeSound() {
        System.out.println(name + " видає звук");
    }
}
