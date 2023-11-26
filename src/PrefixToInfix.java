import java.util.Scanner;

public  class PrefixToInfix {
    static StringDoubleEndedQueueImpl<String> stack = new StringDoubleEndedQueueImpl<>();
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static boolean prefixToInfix(String prefix) {

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);
            if (isOperator(c)) {
                String s1 = stack.removeFirst();
                String s2 = stack.removeFirst();
                String temp = "(" + s1 + c + s2 + ")";
                stack.addFirst(temp);
            }
            else {
                stack.addFirst(c + "");
            }
        }
        return stack.size() == 1;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the prefix expression: ");
        String prefix = sc.nextLine();
        while (!prefixToInfix(prefix)){
            System.out.println("The prefix expression you entered is wrong\nEnter the prefix expression: ");
            prefix = sc.nextLine();
        }
        System.out.println("The infix expression is: " + stack.removeFirst());
    }
}
