package dev.namtx.leetcode.longestsubstringwithoutrepeatingcharacters;

import java.util.HashMap;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 1;
        int maxLength = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        h.put(s.charAt(start), start);
        while(end < s.length()) {
            int previousOccurrence = h.getOrDefault(s.charAt(end), -1);
            if (previousOccurrence >= start && previousOccurrence <= end) {
                if (end - start + 1 > maxLength) {
                   maxLength = end - start;
                }
                start = previousOccurrence + 1;
            } else {
                h.put(s.charAt(end), end);
                end++;
            }
        }

        if (end - start > maxLength) {
            maxLength = end - start;
        }

        return maxLength;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}
