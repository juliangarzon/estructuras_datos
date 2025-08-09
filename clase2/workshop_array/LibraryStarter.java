/**
 * Library Class - Core Methods Only
 * Time: 20 minutes
 */
public class Library {
    private Book[] books;
    private int bookCount;  // Why do we need this? Discuss in class!
    
    // Constructor
    public Library(int capacity) {
        // TODO: Initialize books array with given capacity
        // TODO: Set bookCount to 0
        System.out.println("Library created with capacity: " + capacity);
    }
    
    /**
     * Method 1: Search for a book by title
     * Time: 5 minutes
     */
    public Book searchByTitle(String title) {
        // TODO: Loop through books (careful: only up to bookCount, not books.length!)
        // TODO: If you find a book with matching title, return it
        // TODO: If not found, return null
        
        return null;
    }
    
    /**
     * Method 2: Add a new book
     * Time: 5 minutes
     */
    public boolean addBook(Book book) {
        // TODO: Check if there's space (bookCount < books.length)
        // TODO: Check book is not null
        // TODO: Add book at position bookCount
        // TODO: Increment bookCount
        // TODO: Print success message
        // TODO: Return true if added, false if not
        
        return false;
    }
    
    /**
     * Method 3: Remove a book by ISBN
     * Time: 5 minutes
     */
    public boolean removeBook(String isbn) {
        // TODO: Find the book position (loop and check ISBN)
        // TODO: If found:
        //       - Shift all books after it one position left
        //       - Set last position to null
        //       - Decrement bookCount
        //       - Return true
        // TODO: If not found, return false
        
        // Hint for shifting:
        // for (int i = position; i < bookCount - 1; i++) {
        //     books[i] = books[i + 1];
        // }
        
        return false;
    }
    
    /**
     * Method 4: Display all books
     * Time: 5 minutes
     */
    public void displayAllBooks() {
        System.out.println("\n=== LIBRARY (" + bookCount + "/" + books.length + " books) ===");
        
        // TODO: If bookCount is 0, print "Library is empty"
        // TODO: Otherwise, loop through and print each book (only up to bookCount!)
        
        System.out.println("=================\n");
    }
    
    // Quick helper methods (implement if time permits)
    public boolean isEmpty() {
        return bookCount == 0;
    }
    
    public boolean isFull() {
        return bookCount >= books.length;
    }
}