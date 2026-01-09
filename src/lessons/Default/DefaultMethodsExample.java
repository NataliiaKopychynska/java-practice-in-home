package lessons.Default;

public class DefaultMethodsExample {
    public static void main(String[] args) {
        Payment card = new CreditCardPayment();
        Payment cash = new CashPayment();

        FileLogger logger = new FileLogger();
        logger.log("Щось сталося");

        System.out.println("=== Оплата карткою ===");
        card.pay(100);
        card.printReceipt(100);     // Використовує default реалізацію

        System.out.println("\n=== Оплата готівкою ===");
        cash.pay(50);
        cash.printReceipt(50);
    }
}
