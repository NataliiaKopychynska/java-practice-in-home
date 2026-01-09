package lessons.Default;

interface  Payment {
    void pay(double amount );
    default void printReceipt(double amount) {
        System.out.println("╔═══════════════════╗");
        System.out.println("║      ЧЕК          ║");
        System.out.println("║  Сума: " + amount + " грн  ║");
        System.out.println("╚═══════════════════╝");
    }
    default void refound(double amount){
        System.out.println("Повернення: " + amount + " грн");
    }

}
