package clase5.workshop;

import java.util.LinkedList;

public class Universidad {
    
    private LinkedList<Alumno> alumnos;
    public Universidad(){
        alumnos = new LinkedList<Alumno>();
    }

    public void addAlumno(Alumno a){
        alumnos.add(a);
    }
    public Alumno getAlumno(String id){
        for(int i=0; i < alumnos.size();i++){
            if (alumnos.get(i).id.equals(id)){
                return alumnos.get(i);
            }
        }
        return null;
    }
    public int getUniversidadSize(){
        return alumnos.size();
    }
}
