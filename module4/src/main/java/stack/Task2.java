package stack;

import java.util.Scanner;
import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : s) {
            if (c == '(' || c == '[' | c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    System.out.println("no");
                    return;
                }
                char last = stack.peek();
                if (c - last <= 2) {
                    stack.pop();
                }
            }
        }
        System.out.println(stack.isEmpty() ? "yes" : "no");
    }
}
