import java.util.HashMap;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + title + ", Author: " + author);
    }
}

class Library {
    HashMap<Integer, Book> books = new HashMap<>();

    void addBook(int id, Book b) {
        books.put(id, b);
    }

    void showBooks() {
        for (Integer id : books.keySet()) {
            System.out.print("ID: " + id + " ");
            books.get(id).display();
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(1, new Book("Java Basics", "John"));
        lib.addBook(2, new Book("OOP Concepts", "Alice"));

        lib.showBooks();
    }
}
