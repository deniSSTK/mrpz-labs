package lab3;

public class Book {
    int id;
    String title;
    String author;
    String publisher;
    int year;
    int pages;
    double price;

    public Book(int id, String title, String author, String publisher, int year, int pages, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.pages = pages;
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getYear() { return year; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }
}