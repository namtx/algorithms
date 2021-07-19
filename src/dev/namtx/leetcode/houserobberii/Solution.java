package dev.namtx.leetcode.houserobberii;

public class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 1)
            return nums[0];
        int[] withFirstHouse = new int[nums.length];
        int[] withoutFirstHouse = new int[nums.length];

        withFirstHouse[0] = nums[0];
        withoutFirstHouse[0] = 0;

        withFirstHouse[1] = nums[0];
        withoutFirstHouse[1] = nums[1];

        if (N == 2) {
            return Math.max(withoutFirstHouse[1], withFirstHouse[1]);
        }

        for (int i = 2; i < N-1; i++) {
            withFirstHouse[i] = Math.max(nums[i] + withFirstHouse[i-2], withFirstHouse[i-1]);
            withoutFirstHouse[i] = Math.max(nums[i] + withoutFirstHouse[i-2], withoutFirstHouse[i-1]);
        }
        
        int i = N-1;
        int with = Math.max(withFirstHouse[i-1], withFirstHouse[i-2]);
        int without = Math.max(withoutFirstHouse[i-1], nums[i] + withoutFirstHouse[i-2]);

        return Math.max(with, without);
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};

        Solution solution = new Solution();

        System.out.println(solution.rob(nums));
    }
}
