import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Book class to store book details
    static class Book {
        private int bookID;
        private String title;
        private String author;
        private boolean isAvailable;

        public Book(int bookID, String title, String author) {
            this.bookID = bookID;
            this.title = title;
            this.author = author;
            this.isAvailable = true; // Default to available
        }

        public int getBookID() {
            return bookID;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            this.isAvailable = available;
        }

        @Override
        public String toString() {
            return "BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
        }
    }

    // Library class to manage a list of books
    static class Library {
        private List<Book> books;

        public Library() {
            books = new ArrayList<>();
        }

        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added: " + book.getTitle());
        }

        public void removeBook(int bookID) {
            books.removeIf(book -> book.getBookID() == bookID);
            System.out.println("Book removed with ID: " + bookID);
        }

        public Book searchBook(int bookID) {
            for (Book book : books) {
                if (book.getBookID() == bookID) {
                    return book;
                }
            }
            System.out.println("Book not found with ID: " + bookID);
            return null;
        }

        public void displayBooks() {
            if (books.isEmpty()) {
                System.out.println("No books available in the library.");
            } else {
                System.out.println("Books available in the library:");
                for (Book book : books) {
                    System.out.println(book);
                }
            }
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookID, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    bookID = scanner.nextInt();
                    library.removeBook(bookID);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    bookID = scanner.nextInt();
                    Book foundBook = library.searchBook(bookID);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    }
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
