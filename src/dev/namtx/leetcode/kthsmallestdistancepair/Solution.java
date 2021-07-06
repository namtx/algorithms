package dev.namtx.leetcode.kthsmallestdistancepair;

import java.util.Arrays;

public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int max = nums[n - 1] - nums[0];
        int min = 0;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            int left = 0;
            int right = 0;
            int count = 0;

            while (right < n) {
                if (nums[right] - nums[left] > mid) {
                    left++;
                } else {
                    int pairs = right - left;
                    count += pairs;
                    right++;
                }
            }

            if (count >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.smallestDistancePair(new int[]{38, 33, 57, 65, 13, 2, 86, 75, 4, 56}, 26));
    }
}
