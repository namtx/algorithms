package dev.namtx.leetcode.numberofislands;

import java.util.Arrays;

public class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] mark = new boolean[grid.length][grid[0].length];
        for (boolean[] r : mark) {
            Arrays.fill(r, false);
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (mark[i][j]) {
                    continue;
                }

                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, mark, grid);
                }
            }
        }

        return count;
    }

    public void dfs(int i, int j, boolean[][] mark, char[][] grid) {
        mark[i][j] = true;
        // top
        if (i > 0 && !mark[i - 1][j] && grid[i - 1][j] == '1') {
            dfs(i - 1, j, mark, grid);
        }
        //bottom
        if (i < grid.length - 1 && !mark[i + 1][j] && grid[i + 1][j] == '1') {
            dfs(i + 1, j, mark, grid);
        }
        // left
        if (j > 0 && !mark[i][j - 1] && grid[i][j - 1] == '1') {
            dfs(i, j - 1, mark, grid);
        }
        // right
        if (j < grid[0].length - 1 && !mark[i][j + 1] && grid[i][j + 1] == '1') {
            dfs(i, j + 1, mark, grid);
        }
    }
}

class Main {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Solution solution = new Solution();
        System.out.println(solution.numIslands(grid));
    }
}
