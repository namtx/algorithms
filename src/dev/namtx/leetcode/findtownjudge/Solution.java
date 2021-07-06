package dev.namtx.leetcode.findtownjudge;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n + 1];
        int[] trusted = new int[n + 1];

        for (int[] pair : trust) {
            trusts[pair[0]]++;
            trusted[pair[1]]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (trusts[i] == 0 && trusted[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
//        int[][] arr = {};
        System.out.println(solution.findJudge(4, arr));
    }
}
