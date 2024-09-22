package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int result = 0;
                if (token.equals("+")) {
                    result += num2 + num1;
                } else if (token.equals("-")) {
                    result += (num2 - num1);
                } else if (token.equals("*")) {
                    result += (num2 * num1);
                } else if (token.equals("/")) {
                    result += (num2 / num1);
                }
                stack.push(Integer.toString(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());

    }

    private boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        }
        return false;
    }
}
