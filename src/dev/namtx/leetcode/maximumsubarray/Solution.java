package dev.namtx.leetcode.maximumsubarray;

/*
https://leetcode.com/problems/maximum-subarray

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

### Solution
- Dynamic programming
- dp[i] = nums[i]
- dp[1] = max(dp[0] + nums[1], dp[1])
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        System.arraycopy(nums, 0, dp, 0, nums.length);

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
            if (dp[i] > max ) {
                max = dp[i];
            }
        }

        return max;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
