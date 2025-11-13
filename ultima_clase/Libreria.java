package ultima_clase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Libreria {
    private ArrayList<Libro> libros = new ArrayList<Libro>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Stack<Transaccion> historial = new Stack<Transaccion>();

    // paso 1, recibe nombre, autor, isbn
    public void agregarLibro(String nombre, String autor, String isbn){
        //paso 2 valida que el isbn no exista
        Libro libro = consultarLibro(isbn);
        if (libro == null){
            //paso 3 se crea el libro
            libro = new Libro(nombre, autor, isbn);
            libros.add(libro);
            // paso 4 agrega el libro a la estructura de deshacer
            Transaccion transaccion = new Transaccion(libro, "insertar");
            historial.add(transaccion);
        }
    }

    public void modificarLibro(String nombre, String autor, String isbn){
        Libro libro = consultarLibro(isbn);
        if (libro != null){
            Libro libroOld = new Libro(libro.getNombre(),libro.getAutor(),libro.getIsbn());
            libro.setAutor(autor);
            libro.setNombre(nombre);
            Transaccion transaccion = new Transaccion(libroOld, "modificar");
            historial.add(transaccion);
        }
    }

    public Libro consultarLibro(String isbn){
        Iterator<Libro> iter = libros.iterator();
        while(iter.hasNext()){
            Libro libro = iter.next();
            if (libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public void agregarUsuario(String username, String name){
        Usuario user = consultarUsuario(username);
        if(user == null){
            user = new Usuario(username, name);
            usuarios.add(user);
            Transaccion transaccion = new Transaccion(user,"Usuario","Insertar");
            historial.add(transaccion);
        }
    }

    public Usuario consultarUsuario(String username){
        Iterator<Usuario> iter = usuarios.iterator();
        while(iter.hasNext()){
            Usuario user = iter.next();
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public void deshacer(){
        Transaccion transaccion = historial.pop();
        switch (transaccion.getTipo()) {
            case "Usuario":
                deshacerUsuario((Usuario)transaccion.getObjeto(), transaccion.getOperacion());
                break;
            case "Libro":
                deshacerLibro((Libro)transaccion.getObjeto(), transaccion.getOperacion());
                break;
        }

        
    }
    public void deshacerUsuario(Usuario user, String operacion){
        switch (operacion) {
            case "Insertar":
                
                break;
        
            default:
                break;
        }
    }

    public void deshacerLibro (Libro libro, String operacion){
        switch (operacion) {
            case "insertar":
                // 2 eliminar el libro agregado
                Iterator<Libro> iter = libros.iterator();
                while(iter.hasNext()){
                    Libro libroActual = iter.next();
                    if (libro.getIsbn().equals(libroActual.getIsbn())){
                        iter.remove();
                    }
                }         
                break;
            case "modificar":
                Libro libroActual= consultarLibro(libro.getIsbn());
                libroActual.setAutor(libro.getAutor());
                libroActual.setNombre(libro.getNombre());
            default:
                break;
        }
    }

}
