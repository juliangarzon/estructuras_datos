/**
 * Quick Test - 5 minutes
 * Run this to test your implementation!
 */
public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY TEST ===\n");
        
        // Step 1: Create a library with space for 5 books
        Library library = new Library(5);
        
        // Step 2: Create and add some books
        System.out.println("--- Adding Books ---");
        Book book1 = new Book("1984", "George Orwell", "123", true);
        Book book2 = new Book("Hamlet", "Shakespeare", "456", true);
        Book book3 = new Book("The Hobbit", "Tolkien", "789", true);
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        
        // Step 3: Display all books
        library.displayAllBooks();
        
        // Step 4: Search for a book
        System.out.println("--- Searching ---");
        Book found = library.searchByTitle("1984");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Book not found!");
        }
        
        // Step 5: Remove a book
        System.out.println("\n--- Removing book with ISBN 456 ---");
        library.removeBook("456");
        
        // Step 6: Display again to see the change
        library.displayAllBooks();
        
        // Bonus: Try these if you have time!
        // - What happens if you try to add a null book?
        // - What happens if you try to add more than 5 books?
        // - What happens if you search for a book that doesn't exist?
    }
}