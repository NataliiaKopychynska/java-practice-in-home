public class DogTest {
    public static void main(String[] args) {
        Dog rex = new Dog("Rex", 3,"korgi");

        rex.introduce();
        rex.bark();
        rex.eat("meet");
        rex.sleep();
    }
}
