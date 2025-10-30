package clase11.ejercicio_1;

public class ValidadorSantiago {
    public boolean validatePassword(String password){
        if (password.length()<8){
            return false;
        }
        if(!hasUppercase(password)){
            return false;
        }
        
        return true;
    }

    public boolean hasUppercase(String password){
        char[] passwordArray = password.toCharArray();
        for( int i =0 ; i <= passwordArray.length;i++){
            if (Character.isUpperCase(passwordArray[i])) {
                return true;
            }
        }
        return false;
    }
}
