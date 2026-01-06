public class Dog {
    String name;
    int age;
    String breed;


    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }
    public void bark() {
        System.out.println(name + " каже: Гав-гав! 🐕");
    }

    public void eat(String food) {
        System.out.println(name + " їсть " + food);
    }

    public void sleep() {
        System.out.println(name + " спить... 😴");
    }

    public void introduce() {
        System.out.println("Привіт! Я " + name + ", мені " + age +
                " років, я " + breed);
    }


}
