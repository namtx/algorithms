package dev.namtx.leetcode;

import com.sun.tools.javac.util.Pair;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
    }

    public static int longestValidParentheses(String s) {
        int max = 0;
        int temp = 0;

        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair(s.charAt(i), i));
            } else {
                if (stack.peek().fst == '(' && s.charAt(i) == ')') {
                    stack.pop();
                } else {
                    stack.push(new Pair(s.charAt(i), i));
                }
            }
        }

        if (stack.isEmpty()) {
            return s.length();
        }

        return Integer.max(s.length(), 1);
    }
}
