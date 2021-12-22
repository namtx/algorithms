package dev.namtx.leetcode.longestpalindromicsubstring;

public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = countFromMiddle(s, i, i);
            int len2 = countFromMiddle(s, i, i+1);

            int m = Math.max(len1, len2);
            if (m > max) {
                max = m;
                start = i - (m -1)/2;
                end = i + (m/2);
            }
        }

        return s.substring(start, end+1);
    }

    public int countFromMiddle(String s, int start, int end) {
        while(start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }

            start--;
            end++;
        }

        return end - start - 1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("badad"));
    }
}
