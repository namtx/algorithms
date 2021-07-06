package dev.namtx.leetcode.partitionofmaximumsum;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (arr[n-1-i] > max) {
                max = arr[n-1-i];
            }
            dp[n-1-i] = max * (i+1);
        }

        for (int i = n-k-1; i >=0; i--) {
            max = arr[i];
            int m1 = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                if (arr[i+j] > max) {
                    max = arr[i+j];
                }
                int temp = max*(j+1) + dp[i+j+1];
                if (temp > m1) {
                    m1 = temp;
                }
            }
            dp[i] = m1;
        }

        return dp[0];
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,4,1,5,7,3,6,1,9,9,3};
        System.out.println(solution.maxSumAfterPartitioning(arr, 4));
    }
}
