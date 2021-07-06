package dev.namtx.leetcode.graycode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> r = new ArrayList<>();
        HashSet<Integer> s = new HashSet<>();
        int i = 0;
        int prev = 0;
        s.add(prev);
        r.add(0);

        while (i < n) {
            int next = prev^(1 << i);
            if (s.contains(next)) {
                i++;
            } else {
                prev = next;
                s.add(next);
                r.add(next);
                i = 0;
            }
        }
        
        return r;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(5));
    }
}

