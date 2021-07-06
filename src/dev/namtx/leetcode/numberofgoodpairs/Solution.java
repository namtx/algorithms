package dev.namtx.leetcode.numberofgoodpairs;

import java.util.HashMap;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int val = h.getOrDefault(num, 0);
            if (val == 0) {
                h.put(num, 1);
            } else {
                count += val;
                h.put(num, val + 1);
            }
        }

        return count;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution  = new Solution();
        System.out.println(solution.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}
