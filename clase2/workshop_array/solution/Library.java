/**
 * Library Class - Complete Solution
 */
public class Library {
    private Book[] books;
    private int bookCount;
    
    // Constructor
    public Library(int capacity) {
        this.books = new Book[capacity];
        this.bookCount = 0;
        System.out.println("Library created with capacity: " + capacity);
    }
    
    /**
     * Search for a book by title
     */
    public Book searchByTitle(String title) {
        System.out.println("Searching for: " + title);
        
        // Important: only search up to bookCount, not books.length
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equals(title)) {
                System.out.println("✅ Book found!");
                return books[i];
            }
        }
        
        System.out.println("❌ Book not found");
        return null;
    }
    
    /**
     * Add a new book to the library
     */
    public boolean addBook(Book book) {
        // Check if there's space
        if (bookCount >= books.length) {
            System.out.println("❌ Library is full! Cannot add book.");
            return false;
        }
        
        // Check book is not null
        if (book == null) {
            System.out.println("❌ Cannot add null book!");
            return false;
        }
        
        // Check if book with same ISBN already exists
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(book.getIsbn())) {
                System.out.println("❌ Book with ISBN " + book.getIsbn() + " already exists!");
                return false;
            }
        }
        
        // Add book at position bookCount
        books[bookCount] = book;
        bookCount++;
        System.out.println("✅ Added: " + book.getTitle() + " (Total books: " + bookCount + ")");
        return true;
    }
    
    /**
     * Remove a book by ISBN
     */
    public boolean removeBook(String isbn) {
        // Find the book position
        int position = -1;
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                position = i;
                break;
            }
        }
        
        // If not found
        if (position == -1) {
            System.out.println("❌ Book with ISBN " + isbn + " not found!");
            return false;
        }
        
        // Store title for message
        String removedTitle = books[position].getTitle();
        
        // Shift all books after the removed position to the left
        for (int i = position; i < bookCount - 1; i++) {
            books[i] = books[i + 1];
        }
        
        // Clear the last position and decrement counter
        bookCount--;
        books[bookCount] = null;
        
        System.out.println("✅ Removed: " + removedTitle + " (Total books: " + bookCount + ")");
        return true;
    }
    
    /**
     * Display all books in the library
     */
    public void displayAllBooks() {
        System.out.println("\n=== LIBRARY (" + bookCount + "/" + books.length + " books) ===");
        
        if (bookCount == 0) {
            System.out.println("Library is empty");
        } else {
            for (int i = 0; i < bookCount; i++) {
                System.out.println((i + 1) + ". " + books[i]);
            }
        }
        System.out.println("=================\n");
    }
    
    /**
     * Display only available books
     */
    public void displayAvailableBooks() {
        System.out.println("\n=== AVAILABLE BOOKS ===");
        int availableCount = 0;
        
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                System.out.println("- " + books[i]);
                availableCount++;
            }
        }
        
        if (availableCount == 0) {
            System.out.println("No books available for borrowing");
        } else {
            System.out.println("Total available: " + availableCount);
        }
        System.out.println("=================\n");
    }
    
    /**
     * Borrow a book (set available to false)
     */
    public boolean borrowBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                if (!books[i].isAvailable()) {
                    System.out.println("❌ Book is already borrowed!");
                    return false;
                }
                books[i].setAvailable(false);
                System.out.println("✅ Book borrowed: " + books[i].getTitle());
                return true;
            }
        }
        System.out.println("❌ Book with ISBN " + isbn + " not found!");
        return false;
    }
    
    /**
     * Return a book (set available to true)
     */
    public boolean returnBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                if (books[i].isAvailable()) {
                    System.out.println("⚠️ Book was not borrowed!");
                    return false;
                }
                books[i].setAvailable(true);
                System.out.println("✅ Book returned: " + books[i].getTitle());
                return true;
            }
        }
        System.out.println("❌ Book with ISBN " + isbn + " not found!");
        return false;
    }
    
    // Helper methods
    public boolean isEmpty() {
        return bookCount == 0;
    }
    
    public boolean isFull() {
        return bookCount >= books.length;
    }
    
    public int getBookCount() {
        return bookCount;
    }
    
    public int getCapacity() {
        return books.length;
    }
}