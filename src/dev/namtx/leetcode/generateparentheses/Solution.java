package dev.namtx.leetcode.generateparentheses;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        backtrack(r, "", 0, 0, n);

        return r;
    }

    public void backtrack(List<String> r, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            r.add(current);
            return;
        }

        if (open < n) backtrack(r, current + "(", open + 1, close, n);
        if (close < open) backtrack(r, current + ")", open, close + 1, n);
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
