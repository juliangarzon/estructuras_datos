package clase11.ejercicio_1;

public class ValidadorNicolas {
    
    public static boolean validarContraseña(String password){
        char[] passwordArray = password.toCharArray();
        if(passwordArray.length < 8){
            return false;
        }
        boolean hasUpper= false;
        for( int i =0 ; i <= passwordArray.length;i++){
            if (Character.isUpperCase(passwordArray[i])) {
                hasUpper=true;
                break;
            }
        }
        if (!hasUpper){
            return false;
        }
        boolean hasLower = false;
        for( int i =0 ; i <= passwordArray.length;i++){
            if (Character.isLowerCase(passwordArray[i])){
                hasLower=true;
                break;
            }
        }
        if (!hasLower){
            return false;
        }
        boolean hasNumber = false;
        for( int i =0 ; i <= passwordArray.length;i++){
            if(Character.isDigit(passwordArray[i])){
                hasNumber=true;
                break;
            }
        }
        if(!hasNumber){
            return false;
        }

        boolean hasSpecialCharacters = false;
        for( int i =0 ; i <= passwordArray.length;i++){
            if(passwordArray[i] == '('){
                hasSpecialCharacters=true;
                break;
            }
            if(passwordArray[i] == '%'){
                hasSpecialCharacters=true;
                break;
            }
        }
        if (!hasSpecialCharacters){
            return false;
        }
        return true;
    }


    public static void main (String args[]){
        System.out.println(validarContraseña("miMama1%"));
    }
}
