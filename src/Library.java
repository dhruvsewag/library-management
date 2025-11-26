import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void loadBooks(List<Book> loadedBooks) {
        this.books = loadedBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(String id, String title, String author) {
        books.add(new Book(id, title, author, false));
        System.out.println("Book added successfully!");
    }

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n--- All Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void listAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        boolean found = false;

        for (Book b : books) {
            if (!b.isIssued()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books.");
        }
    }

    public void issueBook(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                if (!b.isIssued()) {
                    b.issue();
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("This book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void returnBook(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                if (b.isIssued()) {
                    b.returnBook();
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("This book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }
}
