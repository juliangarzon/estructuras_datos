package clase11.ejercicio_2;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;


public class GestorTareas {
    private List<Tarea> alta;
    private List<Tarea> media;
    private List<Tarea> baja;

    public GestorTareas() {
        this.alta = new ArrayList<>();
        this.media = new ArrayList<>();
        this.baja = new ArrayList<>();
    }
    public void agregarTarea(String nombre, String prioridad) {
        Tarea tarea =  new Tarea(nombre, prioridad);
        switch (prioridad) {
            case "Alta":
                alta.add(tarea);
                break;
            case "Media":
                media.add(tarea);
                break;
            case "Baja":
                baja.add(tarea);
                break;
            default:
                break;
        }
    }
    public void completarTarea(String nombre) {
        Iterator<Tarea> iter = alta.iterator();
        while(iter.hasNext()){
            Tarea t = iter.next();
            if (t.getNombre().equalsIgnoreCase(nombre)){
                iter.remove();
                return;
            }
        }

        iter = media.iterator();
        while(iter.hasNext()){
            Tarea t = iter.next();
            if (t.getNombre().equalsIgnoreCase(nombre)){
                iter.remove();
                return;
            }
        }

        iter = baja.iterator();
        while(iter.hasNext()){
            Tarea t = iter.next();
            if (t.getNombre().equalsIgnoreCase(nombre)){
                iter.remove();
                return;
            }
        }
    }

    public String[] consultarTareas(){
        ArrayList<String> arSalida = new ArrayList<>();
        Iterator<Tarea> iter = alta.iterator();
        while(iter.hasNext()){
            Tarea tarea = iter.next();
            arSalida.add(tarea.toString());
        }

        iter = media.iterator();
        while(iter.hasNext()){
            Tarea tarea = iter.next();
            arSalida.add(tarea.toString());
        }

        iter = baja.iterator();
        while(iter.hasNext()){
            Tarea tarea = iter.next();
            arSalida.add(tarea.toString());
        }
        String[] salida = (String[])arSalida.toArray();
        return salida;
   }

   public int getContadorListas(String prioridad){
        switch (prioridad) {
            case "Alta":
                return alta.size();
            case "Media":
                return media.size();
            case "Baja":
                return baja.size();
            default:
                return 0;
        }
   }

}
