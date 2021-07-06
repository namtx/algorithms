package dev.namtx.leetcode.knightdialer;

public class Solution {
    public int knightDialer(int n) {
        final int mod = (int) 1e9 + 7;
        final int[][] m = new int[][]{
                new int[]{4, 6},
                new int[]{6, 8},
                new int[]{7, 9},
                new int[]{4, 8},
                new int[]{0, 3, 9},
                new int[]{},
                new int[]{0, 1, 7},
                new int[]{2, 6},
                new int[]{1, 3},
                new int[]{2, 4}
        };
        double[][] dp = new double[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k : m[j]) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] = dp[i][j] % mod;
            }
        }
        double sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i];
        }

        return (int) (sum % mod);
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.knightDialer(3131));
    }
}
