package Konstruktory;

public class BookTest {
    public static void main(String[] args) {
        Book book1= new Book();
        Book book2= new Book("Кобзар", "Тарас Шевченко", 256, 150.0);
        Book book3 = new Book("Гаррі Поттер", "Дж.К. Роулінг");


        book1.getInfo();
        book2.getInfo();
        book3.getInfo();


    }
}
