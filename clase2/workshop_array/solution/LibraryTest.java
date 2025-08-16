/**
 * Library Test - Complete Solution
 */
public class LibraryTest {
    public static void main(String[] args) {
        System.out.println("=== LIBRARY MANAGEMENT SYSTEM TEST ===\n");
        
        // Create a library with space for 5 books
        Library library = new Library(5);
        
        // Create and add some books
        System.out.println("--- Adding Books ---");
        Book book1 = new Book("1984", "George Orwell", "978-0-452-28423-4", true);
        Book book2 = new Book("Hamlet", "William Shakespeare", "978-0-7434-7712-3", true);
        Book book3 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0-547-92822-7", true);
        Book book4 = new Book("Don Quixote", "Miguel de Cervantes", "978-0-06-093434-7", true);
        
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        
        // Display all books
        library.displayAllBooks();
        
        // Search for a book
        System.out.println("--- Searching for Books ---");
        Book found = library.searchByTitle("1984");
        if (found != null) {
            System.out.println("Found book details: " + found);
        }
        
        // Search for non-existent book
        System.out.println("\n--- Searching for Non-existent Book ---");
        Book notFound = library.searchByTitle("Harry Potter");
        
        // Borrow some books
        System.out.println("\n--- Borrowing Books ---");
        library.borrowBook("978-0-452-28423-4");  // 1984
        library.borrowBook("978-0-7434-7712-3");  // Hamlet
        
        // Display available books
        library.displayAvailableBooks();
        
        // Try to borrow already borrowed book
        System.out.println("--- Trying to Borrow Already Borrowed Book ---");
        library.borrowBook("978-0-452-28423-4");  // 1984 again
        
        // Return a book
        System.out.println("\n--- Returning Books ---");
        library.returnBook("978-0-452-28423-4");  // Return 1984
        
        // Display available books again
        library.displayAvailableBooks();
        
        // Remove a book
        System.out.println("--- Removing a Book ---");
        library.removeBook("978-0-7434-7712-3");  // Remove Hamlet
        
        // Display all books after removal
        library.displayAllBooks();
        
        // Test edge cases
        System.out.println("--- Testing Edge Cases ---");
        
        // Try to add null book
        System.out.println("\nTrying to add null book:");
        library.addBook(null);
        
        // Try to add duplicate ISBN
        System.out.println("\nTrying to add duplicate ISBN:");
        Book duplicate = new Book("Another 1984", "Someone Else", "978-0-452-28423-4", true);
        library.addBook(duplicate);
        
        // Fill the library to capacity
        System.out.println("\n--- Filling Library to Capacity ---");
        Book book5 = new Book("The Odyssey", "Homer", "978-0-14-026886-7", true);
        Book book6 = new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8", true);
        
        library.addBook(book5);  // This should work (5th book)
        library.addBook(book6);  // This should fail (6th book, over capacity)
        
        // Display final state
        System.out.println("\n--- Final Library State ---");
        library.displayAllBooks();
        
        // Show library statistics
        System.out.println("--- Library Statistics ---");
        System.out.println("Total capacity: " + library.getCapacity());
        System.out.println("Current books: " + library.getBookCount());
        System.out.println("Is empty? " + library.isEmpty());
        System.out.println("Is full? " + library.isFull());
    }
}