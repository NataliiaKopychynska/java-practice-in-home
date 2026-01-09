package lessons.Box;

public class ObjectExample {

    public static void changeBox(Box box){
        box.v = 100;
        System.out.println("Всередині методу: box.value = " + box.v);
    }

    public static void main(String[] args) {
        Box myBox = new Box(5);
        System.out.println("До виклику: myBox.value = " + myBox.v);
        changeBox(myBox);
        System.out.println("Після виклику: myBox.value = " + myBox.v);
    }
}
