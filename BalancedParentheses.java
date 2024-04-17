package assignment6;

import java.util.Stack;

public class BalancedParentheses {

    // Function to check if the given string has balanced parentheses
    public static boolean isBalanced(String expr) {
        // Using ArrayDeque is faster than using Stack class
        Stack<Character> stack = new Stack<>();

        // Traversing the expression
        for (char ch : expr.toCharArray()) {
            // If the current character is a starting bracket, push it to stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                continue;
            }

            // If current character is not a starting bracket, then it must be closing.
            // So stack cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            
            char check;
            switch (ch) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check empty stack
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String expr = "([{}])";

        // Function call
        if (isBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }
}

