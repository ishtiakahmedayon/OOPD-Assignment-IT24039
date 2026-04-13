import java.util.ArrayList;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
    }

    void showBooks() {
        for (Book b : books) {
            b.display();
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book("Java Basics", "John"));
        lib.addBook(new Book("OOP Concepts", "Alice"));

        lib.showBooks();
    }
}
