package stack;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new ValidParentheses().isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char last = stack.peek();
                    if ((last == '[' && ch == ']') || (last == '{' && ch == '}') || (last == '(' && ch == ')')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();

    }
}
