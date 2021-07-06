package dev.namtx.leetcode.besttimetobuyandsellstockwithcooldown;

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;

        /*
        Four states:
        - s1: has 1 stock and sell it
        - s2: has 1 stock and do nothing
        - s3: has 0 stock and buy stock
        - s4: has 0 stock and do nothing
         */

        int s1 = 1;
        int s2 = -prices[0];
        int s3 = -prices[0];
        int s4 = 0;

        for (int i = 1; i < n; i++) {
            s2 = Math.max(s2, s3);
            s3 = -prices[i] + s4;
            s4 = Math.max(s4, s1);
            s1 = prices[i] + s2;
        }

        return Math.max(s1, s4);
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxProfit(new int[]{1,2,3,0,2}));
    }
}
