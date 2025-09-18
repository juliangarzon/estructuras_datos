import java.util.Stack;
import java.util.StringTokenizer;

public class ParenthesisValidator {
    // TODO: Add any necessary attributes

    public ParenthesisValidator() {

    }

    public boolean isValid(String expression) {
        Stack<String> stackValidator = new Stack<String>();
        String [] tokens = expression.split("");
        boolean isValid = true;
        for(int i = 0 ; i< tokens.length; i++){
            String token = tokens[i];
            switch (token) {
                case "(":
                    stackValidator.push(token);    
                    break;
                case "{":
                    stackValidator.push(token);
                    break;
                case "[":
                    stackValidator.push(token);
                    break;
                case ")":
                    if(!stackValidator.isEmpty()){
                        String open = stackValidator.pop();    
                        if (!open.equals("(")){
                            isValid=false;
                        }
                    }else{
                        isValid=false;
                    }
                    break;
                  case "]":
                    if(!stackValidator.isEmpty()){
                        String open = stackValidator.pop();    
                        if (!open.equals("[")){
                            isValid=false;
                        }
                    }else{
                        isValid=false;
                    }
                    break;
                case "}":
                    if(!stackValidator.isEmpty()){
                        String open = stackValidator.pop();    
                        if (!open.equals("{")){
                            isValid=false;
                        }
                    }else{
                        isValid=false;
                    }
                    break;
                default:
                    break;
            }
        }
        if( stackValidator.size()>0) {
            isValid=false;
        }
        return isValid;
    }

    // TODO: Add any helper methods you need
}



