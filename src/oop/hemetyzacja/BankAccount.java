package oop.hemetyzacja;

public class BankAccount {
    // private - доступ тільки всередині класу
    private String accountNumber;
    private double balance;
    private String ownerName;

    // Конструктор
    public BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    // Getter - читання приватного поля
    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter з перевіркою
    public void setOwnerName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.ownerName = name;
        } else {
            System.out.println("Помилка: ім'я не може бути пустим");
        }
    }

    public void deposit (double amount) {
        if(amount>0){
            balance += amount;
            System.out.println(amount +" , " + balance);
        }else{
            System.out.println("Amount is -");
        }
    }

    // Метод для зняття
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Помилка: сума має бути додатною");
            return false;
        }

        if (amount > balance) {
            System.out.println("❌ Недостатньо коштів");
            System.out.println("Доступно: " + balance + " грн");
            return false;
        }

        balance -= amount;
        System.out.println("✅ Знято: " + amount + " грн");
        System.out.println("Новий баланс: " + balance + " грн");
        return true;
    }

    // Метод для переказу
    public boolean transfer(BankAccount recipient, double amount) {
        System.out.println("\n💸 Переказ з " + this.ownerName +
                " до " + recipient.ownerName);
        if (this.withdraw(amount)) {
            recipient.deposit(amount);
            return true;
        }
        return false;
    }


    public void displayInfo() {
        System.out.println("\n--- Інформація про рахунок ---");
        System.out.println("Власник: " + ownerName);
        System.out.println("Номер: " + accountNumber);
        System.out.println("Баланс: " + balance + " грн");
    }

}
