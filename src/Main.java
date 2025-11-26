import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        library.loadBooks(FileHandler.loadData());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library Management =====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. List All Books");
            System.out.println("5. List Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    library.addBook(id, title, author);
                    FileHandler.saveData(library.getBooks());
                    break;

                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    library.issueBook(sc.nextLine());
                    FileHandler.saveData(library.getBooks());
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextLine());
                    FileHandler.saveData(library.getBooks());
                    break;

                case 4:
                    library.listAllBooks();
                    break;

                case 5:
                    library.listAvailableBooks();
                    break;

                case 6:
                    System.out.println("Saving data...");
                    FileHandler.saveData(library.getBooks());
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
