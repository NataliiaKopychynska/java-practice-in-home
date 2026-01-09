package Konstruktory;

public class Book {
    String title;
    String author;
    int pages;
    double price;

    public Book(){
        title = "Unknow name";
        author = "Unknow author";
        pages = 0;
        price = 0.0;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.pages = 100;
        this.price = 50.0;
    }


    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    public Book(String title){
        this(title,"Unknow author",0,0.0 );
    }



    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public void getInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: " + price);

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
