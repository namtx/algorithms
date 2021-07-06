package dev.namtx.leetcode.kthhappystring;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    HashMap<Character, String[]> h = new HashMap<>();
    public String getHappyString(int n, int k) {
        h.put('a', new String[]{"b", "c"});
        h.put('b', new String[]{"a", "c"});
        h.put('c', new String[]{"a", "b"});

        String[] r = recursive(n, h);
        if (r.length < k) {
            return "";
        }

        return r[k-1];
    }

    public static String[] recursive(int n, HashMap<Character, String[]> h) {
        if (n == 1) {
            return new String[]{"a", "b", "c"};
        }

        String[] child = recursive(n-1, h);
        String[] r = new String[child.length * 2];
        for (int i = 0; i < child.length; i++) {
            r[i*2] = child[i].concat(h.get(child[i].charAt(child[i].length() - 1))[0]);
            r[i*2+1] = child[i].concat(h.get(child[i].charAt(child[i].length() - 1))[1]);
        }

        return r;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.getHappyString(4, 3));
    }
}
