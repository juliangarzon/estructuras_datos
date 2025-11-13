package ultima_clase;

public class Libro {
    private String nombre;

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private String autor;

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    private String isbn;

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Libro(String nombre,String autor, String isbn){
        this.autor = autor;
        this.nombre = nombre;
        this.isbn = isbn;
    }
    
}
