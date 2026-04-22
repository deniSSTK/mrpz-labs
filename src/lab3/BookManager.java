package lab3;

import java.util.Scanner;
import java.util.ArrayList;

class Book {
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

public class BookManager {
    
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Book Management System ===");
        System.out.println();
        
        Book[] books = initializeBooks(scanner);
        
        System.out.println("\nInitial Book List:");
        displayBooks(books);
        
        while (true) {
            System.out.println("\nSearch Options:");
            System.out.println("1. Search by Author");
            System.out.println("2. Search by Publisher");
            System.out.println("3. Search by Year (published after)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            
            int choice = getIntInput(scanner, 1, 4);
            
            switch (choice) {
                case 1:
                    System.out.print("Enter author name: ");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    searchByAuthor(books, author);
                    break;
                case 2:
                    System.out.print("Enter publisher name: ");
                    scanner.nextLine();
                    String publisher = scanner.nextLine();
                    searchByPublisher(books, publisher);
                    break;
                case 3:
                    System.out.print("Enter year (books published after this year): ");
                    int year = getIntInput(scanner, 0, 2024);
                    searchByYear(books, year);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
            }
        }
    }
    
    private static Book[] initializeBooks(Scanner scanner) {
        Book[] books = new Book[5];
        
        System.out.println("Enter details for 5 books:");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("\nBook " + (i + 1) + ":");
            
            System.out.print("ID: ");
            int id = getIntInput(scanner, 1, 9999);
            
            System.out.print("Title: ");
            scanner.nextLine();
            String title = scanner.nextLine();
            
            System.out.print("Author: ");
            String author = scanner.nextLine();
            
            System.out.print("Publisher: ");
            String publisher = scanner.nextLine();
            
            System.out.print("Year: ");
            int year = getIntInput(scanner, 1000, 2024);
            
            System.out.print("Pages: ");
            int pages = getIntInput(scanner, 1, 10000);
            
            System.out.print("Price: ");
            double price = getDoubleInput(scanner);
            
            books[i] = new Book(id, title, author, publisher, year, pages, price);
        }
        
        return books;

    }
    
    private static int getIntInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.print("Error: Value must be between " + min + " and " + max + ". Try again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Error: Invalid integer. Try again: ");
            }
        }
    }
    
    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                if (value >= 0.0 && value <= 10000.0) {
                    return value;
                } else {
                    System.out.print("Error: Value must be between " + 0.0 + " and " + 10000.0 + ". Try again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Error: Invalid number. Try again: ");
            }
        }
    }
    
    private static void displayBooks(Book[] books) {
        System.out.println("+------+----------------------+----------------------+----------------+------+-------+--------+");
        System.out.println("|  ID  |        Title         |        Author        |   Publisher    | Year | Pages | Price  |");
        System.out.println("+------+----------------------+----------------------+----------------+------+-------+--------+");
        
        for (Book book : books) {
            System.out.printf("| %-4d | %-20s | %-20s | %-14s | %-4d | %-5d | %-6.2f |\n",
                book.getId(), book.getTitle(), book.getAuthor(), 
                book.getPublisher(), book.getYear(), book.getPages(), book.getPrice());
        }
        
        System.out.println("+------+----------------------+----------------------+----------------+------+-------+--------+");
    }
    
    private static void searchByAuthor(Book[] books, String author) {
        ArrayList<Book> results = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        
        System.out.println("\nBooks by '" + author + "':");
        if (results.isEmpty()) {
            System.out.println("No results found");
        } else {
            displayBookList(results.toArray(new Book[0]));
        }
    }
    
    private static void searchByPublisher(Book[] books, String publisher) {
        ArrayList<Book> results = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getPublisher().equalsIgnoreCase(publisher)) {
                results.add(book);
            }
        }
        
        System.out.println("\nBooks published by '" + publisher + "':");
        if (results.isEmpty()) {
            System.out.println("No results found");
        } else {
            displayBookList(results.toArray(new Book[0]));
        }
    }
    
    private static void searchByYear(Book[] books, int year) {
        ArrayList<Book> results = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getYear() > year) {
                results.add(book);
            }
        }
        
        System.out.println("\nBooks published after " + year + ":");
        if (results.isEmpty()) {
            System.out.println("No results found");
        } else {
            displayBookList(results.toArray(new Book[0]));
        }
    }
    
    private static void displayBookList(Book[] books) {
        System.out.println("+------+----------------------+----------------------+----------------+------+-------+--------+");
        System.out.println("|  ID  |        Title         |        Author        |   Publisher    | Year | Pages | Price  |");
        System.out.println("+------+----------------------+----------------------+----------------+------+-------+--------+");
        
        for (Book book : books) {
            System.out.printf("| %-4d | %-20s | %-20s | %-14s | %-4d | %-5d | %-6.2f |\n",
                book.getId(), book.getTitle(), book.getAuthor(), 
                book.getPublisher(), book.getYear(), book.getPages(), book.getPrice());
        }
        
        System.out.println("+------+----------------------+----------------------+----------------+------+-------+--------+");
    }
}
