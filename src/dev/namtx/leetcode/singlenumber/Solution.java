package dev.namtx.leetcode.singlenumber;

/*
https://leetcode.com/problems/single-number/
 */
class Solution {
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int n: nums) {
            r ^= n;
        }
        return r;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
