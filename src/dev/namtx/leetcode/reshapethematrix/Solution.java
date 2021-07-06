package dev.namtx.leetcode.reshapethematrix;

import java.util.Arrays;

public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;

        if (m*n != r*c)
            return mat;

        int[][] shaped = new int[r][c];

        int rr = 0;
        int cc = 0;
        for (int[] rows : mat) {
            for (int j = 0; j < m; j++) {
                if (cc >= c) {
                    rr++;
                    cc = 0;
                }
                shaped[rr][cc++] = rows[j];
            }
        }

        return shaped;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = new int[][]{{1,2,3,4,5,6}, {3,4,5,6,7,8}};

        System.out.println(Arrays.deepToString(solution.matrixReshape(mat, 3, 4)));
    }
}
