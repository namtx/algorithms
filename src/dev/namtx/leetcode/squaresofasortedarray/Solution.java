package dev.namtx.leetcode.squaresofasortedarray;

import java.util.Arrays;

// https://leetcode.com/problems/squares-of-a-sorted-array
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];
        int pointer = nums.length - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[pointer] = nums[left] * nums[left];
                left++;
            } else {
                result[pointer] = nums[right] * nums[right];
                right--;
            }
            pointer--;
        }

        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(solution.sortedSquares(new int[]{-5, -3, -2, -1})));
    }
}
