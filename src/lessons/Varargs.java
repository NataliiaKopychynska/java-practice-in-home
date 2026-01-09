package lessons;

public class Varargs {
    public static void main(String[] args) {
        // Varargs - можна передати скільки завгодно аргументів
        System.out.println("Сума: " + sum(1, 2, 3));
    }
        // Varargs - змінна кількість параметрів
    public static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        return total;
    }
}
