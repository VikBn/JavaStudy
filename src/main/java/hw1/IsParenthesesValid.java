package hw1;

import java.util.Stack;

class IsParenthesesValid {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); // Push opening brackets onto the stack
            } else {
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false; // Mismatched closing bracket
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsParenthesesValid validator = new IsParenthesesValid();

        // Test cases
        System.out.println(validator.isValid("()"));      // true
        System.out.println(validator.isValid("()[]{}"));  // true
        System.out.println(validator.isValid("(]"));      // false
        System.out.println(validator.isValid("([])"));    // true
    }
}
