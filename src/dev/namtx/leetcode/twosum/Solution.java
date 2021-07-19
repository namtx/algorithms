package dev.namtx.leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (h.containsKey(remaining)) {
                return new int[]{i, h.get(remaining)};
            } else {
                h.put(nums[i], i);
            }
        }

        return new int[]{0,0}; // never reach
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,2,4};
        System.out.println(Arrays.toString(solution.twoSum(arr, 6)));
    }
}
