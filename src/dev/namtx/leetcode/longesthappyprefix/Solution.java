package dev.namtx.leetcode.longesthappyprefix;

public class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        if (n == 1) {
            return "";
        }
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i++] = 0;
                }
            }
        }

        return s.substring(0, lps[n-1]);
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPrefix("AAACAAAA"));
    }
}
