package Leetcode.stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String s = "/home/";
        System.out.println(new SimplifyPath().simplifyPath(s));

    }

    public String simplifyPath(String path) {

        String components[] = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(component);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String comp : stack) {
            sb.append("/").append(comp);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
