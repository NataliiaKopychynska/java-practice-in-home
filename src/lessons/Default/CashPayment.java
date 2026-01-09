package lessons.Default;

public class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("💵 Оплата готівкою: " + amount + " грн");
    }

    // Перевизначаємо default метод
    @Override
    public void printReceipt(double amount) {
        System.out.println("--- Касовий чек ---");
        System.out.println("Готівка: " + amount + " грн");
        System.out.println("-------------------");
    }
}
