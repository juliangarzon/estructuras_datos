public class TestValidator {
    public static void main(String[] args) {
        ParenthesisValidator validator = new ParenthesisValidator();

        // Test cases
        String[] validCases = {
            "()",
            "()[]{}",
            "{[()]}",
            "((()))",
            ""  // Empty string is valid
        };

        String[] invalidCases = {
            "(]",
            "([)]",
            "(((",
            ")))",
            "{[(])}"
        };

        for (int i = 0 ; i < validCases.length; i++){
            System.out.println(validCases[i]);
            System.out.println("Expected: true");
            System.out.println("Executed: "+validator.isValid(validCases[i]));
            System.out.println("-----------------------");
        }

        for (int i = 0 ; i < invalidCases.length; i++){
            System.out.println(invalidCases[i]);
            System.out.println("Expected: false");
            System.out.println("Executed: "+validator.isValid(invalidCases[i]));
            System.out.println("-----------------------");
        }
    }
}