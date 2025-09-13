package clase5.workshop;

public class UniversidadTest {
    private static Universidad universidad;
    public static void main (String args[]){
        universidad = new Universidad();
        testAdd();

    }
    public static boolean testAdd(){
        Alumno a = new Alumno();
        a.nombre="Julian";
        a.id="1106";
        a.correo="correo@asdas.com";
        universidad.addAlumno(a);
        if (universidad.getUniversidadSize() ==1){
            return true;
        }
        return false;
    }
    
}
