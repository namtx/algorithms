package dev.namtx.leetcode.countvowelspermutation;

public class Solution {
    public int countVowelPermutation(int n) {
        int M = 1000000007;
        long [][] dp = new long[n+1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n ; i++) {
            dp[i][0] = (dp[i-1][1] % M + dp[i-1][2] % M + dp[i-1][4] % M) % M;
            dp[i][1] = (dp[i-1][0] % M + dp[i-1][2] % M) % M;
            dp[i][2] = (dp[i-1][1] % M + dp[i-1][3] % M) % M;
            dp[i][3] = dp[i-1][2] % M;
            dp[i][4] = (dp[i-1][2] % M + dp[i-1][3] % M) % M;
        }

        long result;
        result = (dp[n][0] + dp[n][1] + dp[n][2] + dp[n][3] + dp[n][4]) % M;

        return (int) result;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countVowelPermutation(144));
    }
}
