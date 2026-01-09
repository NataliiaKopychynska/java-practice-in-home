package lessons;

public class Types {
    public static int changeNumber(int x) {
        x = 100;  // Змінюємо КОПІЮ
        System.out.println("Всередині методу: x = " + x);;
        return x;
    }



    public static void main(String[] args) {
        int myNumber = 5;
        System.out.println("До виклику: myNumber = " + myNumber);
        myNumber = changeNumber(myNumber);
        System.out.println("Після виклику: myNumber = " + myNumber);
    }
}
