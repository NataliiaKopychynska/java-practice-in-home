package lessons.Box;

public class ReassignExample {
    public static void replaceBox(Box box){
        box = new Box(999);
        box.v = 100;
        System.out.println("Всередині методу: box.value = " + box.v);
    }

    public static void main(String[] args) {
        Box myBox = new Box(5);
        System.out.println("До виклику: myBox.value = " + myBox.v);
        replaceBox(myBox);
        System.out.println("Після виклику: myBox.value = " + myBox.v);
    }
}
