package clase9;

public class Test1 {

    public static void main(String[] args) {
        //cuentaRegresiva(10);
        //cuentaProgresiva(10,0);
        System.out.println(factorial(4));
    }

    public static void cuentaRegresiva(int n) {
        // CASO BASE
        if (n == 0) {
            System.out.println("¡Despegue!");
            return;
        }
    
        // CASO RECURSIVO
        System.out.println(n);
        cuentaRegresiva(n-1);
    }

    public static void cuentaProgresiva(int n, int m) {
        if (n == m) {
            System.out.println(m);
            System.out.println("¡Despegue!");
            return;
        }
        // CASO RECURSIVO
        System.out.println(m);
        cuentaProgresiva(n,m+1);
    }

    public static void cuentaProgresiva2(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.println(i);
        }
        System.out.println("¡Despegue!");

    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }
}

