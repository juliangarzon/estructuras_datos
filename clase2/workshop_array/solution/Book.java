/**
 * Book Class - Complete Solution
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;
    
    // Constructor
    public Book(String title, String author, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    // toString method for nice display
    @Override
    public String toString() {
        return String.format("Book[Title: %s, Author: %s, ISBN: %s, Available: %s]",
                title, author, isbn, available ? "Yes" : "No");
    }
}