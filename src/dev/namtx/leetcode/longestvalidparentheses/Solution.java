package dev.namtx.leetcode.longestvalidparentheses;

import com.sun.tools.javac.util.Pair;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
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

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()())"));
    }
}
