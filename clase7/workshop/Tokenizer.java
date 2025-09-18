import java.util.StringTokenizer;

public class Tokenizer {
    public static void main (String args[]){
        String cadena1 = "mi+mama+me+mima";
        StringTokenizer st = new StringTokenizer(cadena1,"+",true);

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        
        String[] tokenizado = cadena1.split("");

        for (int i =0 ; i < tokenizado.length;i++){
            System.out.println(tokenizado[i]);
        }

    }
}
