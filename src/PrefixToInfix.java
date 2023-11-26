import java.util.Scanner;

public class PrefixToInfix {
    static StringDoubleEndedQueueImpl<String> stack = new StringDoubleEndedQueueImpl<>();

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static boolean isValidOperand(char c) {
        return Character.isDigit(c);
    }

    static boolean isValidInfix(String infix) {
        int operandCount = 0;
        int operatorCount = 0;

        for (int i = infix.length() - 1; i >= 0; i--) {
            char c = infix.charAt(i);

            if (isOperator(c)) {
                operatorCount++;
            } else if (isValidOperand(c)) {
                operandCount++;
            } else {
                return false; // Invalid character in the infix expression
            }
        }
        // For a valid infix expression, the number of operators should be one less than the number of operands
        return operandCount == operatorCount + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the infix expression: ");
        String infix = sc.nextLine();
        while (!isValidInfix(infix)) {
            System.out.println("The infix expression you entered is invalid\nEnter the infix expression: ");
            infix = sc.nextLine();
        }
        System.out.println("The infix expression is: " + stack.removeFirst());
    }
}