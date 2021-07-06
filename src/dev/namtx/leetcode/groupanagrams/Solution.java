package dev.namtx.leetcode.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int [] primes = new int[] {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 67, 71, 83, 89, 101, 107, 109, 113, 127
        };
        HashMap<Long, ArrayList<String>> h = new HashMap<>();
        for (String str : strs) {
            long val = 1;
            for (char c : str.toCharArray()) {
                val *= primes[c - 'a'];
            }
            ArrayList<String> anagrams = h.getOrDefault(val, new ArrayList<>());
            anagrams.add(str);
            h.put(val, anagrams);
        }

        List<List<String>> r = new ArrayList<>();

        for (Long k: h.keySet()) {
            r.add(h.get(k));
        }

        return r;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","baz"}));
    }
}
