package easyproblems;

import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println("Test Case 1: " + isValid("[]") + ", Expected: true");

        System.out.println("\n========================");

        System.out.println("Test Case 2: " + isValid("([{}])") + ", Expected: true");

        System.out.println("\n========================");

        System.out.println("Test Case 3: " + isValid("[(])") + ", Expected: false");

        System.out.println("\n========================");

        System.out.println("Test Case 4: " + isValid("()[]{}") + ", Expected: true");
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Stack<Character> bracketsStack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (!pairs.containsKey(bracket)) { // opening bracket
                bracketsStack.push(bracket);
            } else { // closing bracket
                if (bracketsStack.isEmpty() || bracketsStack.pop() != pairs.get(bracket)) return false;
            }
        }
        return true;
    }
}
