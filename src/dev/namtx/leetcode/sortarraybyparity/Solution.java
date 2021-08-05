package dev.namtx.leetcode.sortarraybyparity;

import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int N = nums.length;
        int l = 0;
        int h = N - 1;

        while (l < h) {
            if (nums[l] % 2 == 0) {
                l++;
            } else if (nums[h] % 2 != 0) {
                h--;
            } else {
                int tmp = nums[l];
                nums[l] = nums[h];
                nums[h] = tmp;
            }
        }

        return nums;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[] {1,3,2,4};
        System.out.println(Arrays.toString(solution.sortArrayByParity(arr)));
    }
}
