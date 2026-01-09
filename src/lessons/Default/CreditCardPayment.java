package lessons.Default;

class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("💳 Оплата карткою: " + amount + " грн");
    }

}
