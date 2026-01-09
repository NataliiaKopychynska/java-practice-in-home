package oop.hemetyzacja;

public class Test {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("UA001", "Іван Петренко");
        BankAccount acc2 = new BankAccount("UA002", "Марія Коваль");

        acc1.deposit(1000);
        acc1.withdraw(300);
        acc1.withdraw(1000);

        acc1.transfer(acc2, 200);

        acc1.displayInfo();
        acc2.displayInfo();
    }
}
