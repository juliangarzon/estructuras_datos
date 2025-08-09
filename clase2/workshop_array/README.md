# Workshop: Library with Book Objects (30 minutes)

## Overview
Transform the simple string array library from class into a more realistic system using Book objects. This workshop will help you practice working with arrays of objects.

## What You'll Build
A library system that stores Book objects instead of just strings, with basic operations like search, add, remove, and display.

## Part 1: Create the Book Class (5 minutes)

Create `Book.java` with these attributes:
```java
public class Book {
    private String title;
    private String author;
    private String isbn;  // unique identifier
    private boolean available;
    
    // Constructor
    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }
    
    // Add getters and setters
    // Add a toString() method to display book info
}
```

## Part 2: Create the Library Class (20 minutes)

### Basic Structure
```java
public class Library {
    private Book[] books;
    private int bookCount;  // Why do we need this?
    
    public Library(int capacity) {
        // Initialize array and counter
    }
}
```

### Core Methods to Implement

#### 1. Search by Title (5 minutes)
```java
public Book searchByTitle(String title) {
    // Loop through books (only up to bookCount!)
    // Return book if found, null if not
}
```

#### 2. Add Book (5 minutes)
```java
public boolean addBook(Book book) {
    // Check if there's space
    // Check book is not null
    // Add at position bookCount
    // Increment bookCount
    // Return true/false
}
```

#### 3. Remove Book (5 minutes)
```java
public boolean removeBook(String isbn) {
    // Find the book
    // Shift all books after it to the left (no gaps!)
    // Decrement bookCount
    // Return true/false
}
```

**Remember to shift elements:**
```java
for (int i = position; i < bookCount - 1; i++) {
    books[i] = books[i + 1];
}
```

#### 4. Display All Books (5 minutes)
```java
public void displayAllBooks() {
    // Show count: "Library has X of Y books"
    // Print each book (only up to bookCount)
    // Handle empty library case
}
```

## Part 3: Quick Test (5 minutes)

Create `LibraryTest.java`:
```java
public class LibraryTest {
    public static void main(String[] args) {
        // Create library
        Library library = new Library(5);
        
        // Add 3 books
        library.addBook(new Book("1984", "Orwell", "123", true));
        library.addBook(new Book("Hamlet", "Shakespeare", "456", true));
        
        // Display all
        library.displayAllBooks();
        
        // Search for a book
        Book found = library.searchByTitle("1984");
        if (found != null) {
            System.out.println("Found: " + found);
        }
        
        // Remove a book
        library.removeBook("123");
        library.displayAllBooks();
    }
}
```

## Key Concepts to Remember

1. **Why use bookCount instead of books.length?**
   - The array might have empty spaces
   - bookCount tracks actual books, not capacity

2. **Why shift elements when removing?**
   - Avoid gaps in the array
   - Keep all books consecutive

3. **Always validate:**
   - Check for null
   - Check array bounds
   - Check if space available

## Bonus (If Time Permits)

Add one more feature:
- `borrowBook(String isbn)` - Set available to false
- `returnBook(String isbn)` - Set available to true
- `displayAvailableBooks()` - Show only available books

## Common Mistakes to Avoid

- Forgetting to increment/decrement bookCount
- Looping to books.length instead of bookCount
- Not handling null cases
- Forgetting to shift elements when removing

## Tips
- Test after each method
- Start simple, then add validation
- Work with a partner if stuck
- Ask questions!

Good luck and have fun exploring!