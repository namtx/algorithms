package dev.namtx.leetcode.toepliztmatrix;

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r-1; i++) {
            for (int j = 0; j < c-1; j++) {
                if (matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }

        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {44, 35, 39}, {15, 44, 35}, {17, 15, 44}, {80, 17, 15}, {43, 80, 0}, {77, 43, 80}
        };
        Solution solution = new Solution();

        System.out.println(solution.isToeplitzMatrix(matrix));
    }
}
