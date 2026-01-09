package lessons.FunctionalInterface;

public class FunctionalExample {
    public static void main(String[] args) {
        // БЕЗ лямбди (довго 😢)
        Calculator add1 = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        // З ЛЯМБДОЮ (коротко 😊)
        Calculator add2 = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;
        Calculator subtract = (a, b) -> a - b;

        // Використання
        System.out.println("5 + 3 = " + add2.calculate(5, 3));
        System.out.println("5 × 3 = " + multiply.calculate(5, 3));
        System.out.println("5 - 3 = " + subtract.calculate(5, 3));
    }
}
