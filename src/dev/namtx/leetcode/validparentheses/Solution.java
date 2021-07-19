package dev.namtx.leetcode.validparentheses;

import java.util.HashMap;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        for (char c: s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty())
                    return false;

                if (stack.peek() == pairs.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}

class Main {
    public static void main(String[] args) {
        String s = "()[]{}";

        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
